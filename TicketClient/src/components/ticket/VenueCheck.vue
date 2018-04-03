<template>
  <div id="venue-check">
    <el-table
      :data="venueList"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <seat-info :seat-info="props.row.seats"></seat-info>
        </template>
      </el-table-column>
      <el-table-column
        label="ID"
        prop="venue_id"
        width="80">
      </el-table-column>
      <el-table-column
        label="名称"
        prop="name"
        width="150">
      </el-table-column>
      <el-table-column
        label="地址"
        prop="address"
        width="200">
      </el-table-column>
      <el-table-column
        label="识别码"
        prop="identification"
        width="150">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">通过</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">拒绝</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import SeatInfo from './SeatInfo.vue'
  export default{
    components: {
      SeatInfo
    },
    data () {
      return {
        venueList: []
      }
    },
    methods:{
      handleEdit(index, row) {
        console.log(index, row);
        var self = this
        self.venueList.splice(index,1)
        this.$http({
          method: 'post',
          url: '/Manage/email/'+this.venueList[index].venue_id,
        }).then(function (res) {
          console.log(res.data)

          self.init()
        }).catch(function (err) {
          console.log(err)
        })
      },
      handleDelete(index, row) {
        console.log(index, row);
        var self = this
        self.venueList.splice(index,1)
        this.$http({
          method: 'post',
          url: '/Manage/notPass/'+this.venueList[index].venue_id,
        }).then(function (res) {
          console.log(res.data)
          self.init()
        }).catch(function (err) {
          console.log(err)
        })
      },
      init(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/checkList/',
        }).then(function (res) {
          console.log(res.data)
          self.venueList = res.data
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    created(){
      this.init()
    }
  }
</script>

<style>

</style>
