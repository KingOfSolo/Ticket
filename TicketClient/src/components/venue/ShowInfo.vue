<template>
  <div class="plan-info">
    <div class="plan-left">
      <img :src="showInfo.poster"/>
    </div>
    <div class="plan-center">
      <div class="plan-title">{{showInfo.name}}</div>
      <div class="plan-start-time">{{showInfo.start_time}} - {{showInfo.end_time}}</div>
      <div class="plan-place">{{showInfo.address}}</div>
      <div class="plan-intro">{{showInfo.introduce}}</div>
    </div>
    <div class="plan-right">
      <el-table
        :data="showInfo.showPrices"
        border
        style="width: 100%">
        <el-table-column
          prop="seat_name"
          label="座位类型">
        </el-table-column>
        <el-table-column
          prop="price"
          label="价格">
        </el-table-column>
        <el-table-column
          prop="remain_num"
          label="剩余数量">
        </el-table-column>

      </el-table>
    </div>
  </div>
</template>

<script>
  export default{
    props: ['showInfo'],
    data(){
      return{
//        totalPrice: 0
      }
    },
    created(){
//      var self = this
//      this.$http({
//        method: 'post',
//        url: '/Show/totalPrice/'+this.showId,
//      }).then(function (res) {
//        console.log(res.data)
//        self.totalPrice = res.data
//      }).catch(function (err) {
//        console.log(err)
//      })
    }
  }
</script>

<style>
  .plan-info{
    width: 100%;
    display: flex;
    justify-content:flex-start;
    overflow: hidden;
  }

  .plan-left{
    width: 150px;
    margin-right: 20px;
  }

  .plan-center{
    width: 350px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 180px;
  }

  .plan-left img{
    height: 180px;
    border-radius: 10px;
  }

  .plan-right{
    /*width: 200px;*/
    margin-left: 20px;
  }

  .plan-title{
    font-weight: bold;
    font-size: 18px;
  }
</style>
