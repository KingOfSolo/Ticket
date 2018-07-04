<template>
  <div id="order-success">
    <div class="order-success-container">
      <div style="display: flex;align-items: center">
        <img src="../../assets/success.svg"/>
        <h2 style="margin-left: 20px">订单支付成功!</h2>
      </div>
      <div style="margin-left: 70px">
        <h2>您可以在个人中心
        <!--<a @click="toMyOrder">我的订单</a>-->
        <router-link :to="path">我的订单</router-link>
        查看订单信息~~~</h2>
        <h2><span style="color: #EA2000">{{restTime}}</span>秒后自动跳转</h2>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    data(){
      return{
//        userId: '',
        path: '',
        time: "",
        restTime: 10,
        timer: "",
      }
    },
    created(){
      var userId = JSON.parse(window.localStorage.getItem('userId'));
      this.path = '/User/'+userId+'/1'
    },
    mounted(){
      this.countdownTimer();
    },
    methods: {
      countdownTimer: function () {
        this.timer = window.setInterval(this.countdown, 1000);
      },
      countdown: function () {
        this.restTime -= 1;
        if(this.restTime <= 0){
          this.isOverTime = true
          clearInterval(this.timer);
          this.$router.push({name: 'User', params: {userId: this.userId, index: 1}})
        }
      },
    }
  }
</script>

<style>
  #order-success{
    display: inline-block;
    width: 700px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    margin-top: 40px;
    border-radius: 5px;
    text-align: left;
  }

    /*.order-success-container{*/
      /*display: flex;*/
      /*align-items: center;*/
    /*}*/

  .order-success h2{
    display: inline-block;
  }

</style>
