<template>
  <div id="venue-check">
    <el-table
      :data="payList"
      style="width: 100%">
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
        label="待结算金额（元）"
        width="150">
        <template slot-scope="props">
          <pay-price :venue-info="props.row"></pay-price>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary"
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">结算</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import PayPrice from './PayPrice.vue'
  export default{
    components: {
      PayPrice
    },
    data () {
      return {
        payList: []
      }
    },
    methods:{
      handleEdit(index, row) {
        this.payList.splice(index,1)
//        console.log(index, row);
//        var self = this
//        self.venueList.splice(index,1)
//        this.$http({
//          method: 'post',
//          url: '/Manage/email/'+this.venueList[index].venue_id,
//        }).then(function (res) {
//          console.log(res.data)
//
//          self.init()
//        }).catch(function (err) {
//          console.log(err)
//        })
      },
    },
    created(){
      console.log('哈哈哈哈哈')
      var self = this
      this.$http({
        method: 'post',
        url: '/Manage/payList',
      }).then(function (res) {
        console.log(res.data)
        self.payList = res.data
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style>

</style>
