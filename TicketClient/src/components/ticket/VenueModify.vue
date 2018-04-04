<template>
  <div id="venue-modify">
    <el-table
      :data="modifyList"
      style="width: 100%">
      <el-table-column
        label="ID"
        prop="venue_id"
        width="80">
      </el-table-column>
      <el-table-column
        label="名称"
        width="280">
        <template slot-scope="scope">
          <name-container :venue-id="scope.row.venue_id"></name-container>
        </template>
      </el-table-column>
      <el-table-column
        label="地址"
        width="280">
        <template slot-scope="scope">
          <address-container :venue-id="scope.row.venue_id"></address-container>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="modifySuccess(scope.$index, scope.row)">通过</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="modifyFail(scope.$index, scope.row)">拒绝</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import NameContainer from './NameContainer.vue'
  import AddressContainer from './AddressContainer.vue'
  export default{
    components: {
      NameContainer,
      AddressContainer
    },
    data () {
      return {
        modifyList: []
      }
    },
    methods:{
      modifySuccess(index, row) {
        console.log(index, row);
        var self = this
        self.modifyList.splice(index,1)
        this.$http({
          method: 'post',
          url: '/Manage/modifySuccess/'+row.venue_id,
        }).then(function (res) {
          console.log(res.data)
          self.modifyInit()
        }).catch(function (err) {
          console.log(err)
        })
      },
      modifyFail(index, row) {
        console.log(index, row);
        var self = this
        self.modifyList.splice(index,1)
        this.$http({
          method: 'post',
          url: '/Manage/modifyFail/'+row.venue_id,
        }).then(function (res) {
          console.log(res.data)
          self.modifyInit()
        }).catch(function (err) {
          console.log(err)
        })
      },
      modifyInit(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/modifyList',
        }).then(function (res) {
          console.log(res.data)
          self.modifyList = res.data
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    created(){
      this.modifyInit()
    }
  }
</script>

<style>

</style>
