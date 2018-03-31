<template>
  <div id="order-display">
    <div style="color: #EA2000;font-size: small" v-show="orderInfo.state == 4">交易取消</div>
    <div class="order-info-number">
      <div>订单号：{{orderInfo.number}}</div>
      <div>{{orderInfo.date}}</div>
    </div>
    <div id="order-info-container">
      <div class="order-info">
        <img :src="showInfo.poster"/>
        <div class="order-info-content">
          <div class="order-info-name">{{showInfo.name}}</div>
          <div><span class="order-info-label">票面：</span><span class="order-info-detail">{{orderInfo.price}}</span></div>
          <div><span class="order-info-label">数量：</span><span class="order-info-detail">{{orderInfo.num}}张</span></div>
          <div><span class="order-info-label">时间：</span><span class="order-info-detail">{{showInfo.start_time}}</span></div>
          <div><span class="order-info-label">场馆：</span><span class="order-info-detail">{{showInfo.address}}</span></div>
          <div><span class="order-info-label">座位：</span><span class="order-info-detail">{{seatInfo.seat_name}}</span></div>
          <div><span class="order-info-label">订单金额：</span><span class="order-info-price">{{orderInfo.total - orderInfo.discount}}元</span></div>
        </div>
      </div>
      <el-button @click="toPay" v-show="orderInfo.state == 1 && showPayButton" type="primary" style="align-self: center">去支付<span>{{this.minutes}}:{{this.seconds}}</span></el-button>
    </div>
  </div>
</template>

<script>
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default{
    components: {ElButton},
    props: ['orderInfo'],
    data (){
      return {
        restTime: 15 * 60 * 1000,
        rootTime: '',
        time: "",
        minutes: "",
        seconds: "",
        timer: "",
        showInfo: {},
        seatInfo: {},
        showPayButton: true
      }
    },
    methods: {
      countdownTime(){
        this.rootTime = +new Date(this.orderInfo.date)
        this.timer = window.setInterval(this.countdown1, 100);
      },
      countdown1(){
        this.time = new Date((this.restTime + this.rootTime) - new Date());
        this.minutes = (this.time.getMinutes() < 10 ? "0" + this.time.getMinutes() : this.time.getMinutes());
        this.seconds = (this.time.getSeconds() < 10 ? "0" + this.time.getSeconds() : this.time.getSeconds());
        if(this.time <= 0){
          this.minutes = "00";
          this.seconds = "00";
          this.showPayButton = false
//          this.overtime()
          clearInterval(this.timer);
        }
      },
      toPay(){
        this.$router.push({name: 'OrderPay', params: {number: this.orderInfo.number}})
      },
      overtime(){
        this.$http({
          method: 'post',
          url: '/Order/fail/'+this.orderInfo.number,
        }).then(function (res) {
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    mounted(){
      let self = this
      this.$http({
        method: 'post',
        url: '/Show/id/'+this.orderInfo.show,
      }).then(function (res) {
        console.log(res.data)
        self.showInfo = res.data
      }).catch(function (err) {
        console.log(err)
      })

      this.$http({
        method: 'post',
        url: '/Order/seat/'+this.orderInfo.seat,
      }).then(function (res) {
        console.log(res.data)
        self.seatInfo = res.data
      }).catch(function (err) {
        console.log(err)
      })

      this.countdownTime()
    }
  }
</script>

<style>
  #order-display{
    margin-top: 20px;
  }

  .order-info{
    display: flex;
    align-items: flex-start;
  }

  .order-info img{
    width: 110px;
    height: 150px;
    border-radius: 10px;
  }

  .order-info-content{
    text-align: left;
    margin-left: 10px;
  }

  .order-info-name{
    margin-bottom: 10px;
    font-size: medium;
    color: #505050;
    font-weight: bold;
  }

  .order-info-label{
    color: #747576;
    font-size: small;
    line-height: 20px;
    margin-left: 5px;
  }

  .order-info-detail{
    font-size: small;
  }

  .order-info-price{
    font-size: medium;
    color: #EA2000;
    font-weight: bold;
  }

  .order-info-number{
    display: flex;
    justify-content: space-between;
    font-size: small;
    padding-bottom: 10px;
  }

  #order-info-container{
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    padding: 10px 0;
    border-top: 1px dotted #cccccc;
    border-bottom: 1px dotted #cccccc;
  }

  .remain-time{

  }
</style>
