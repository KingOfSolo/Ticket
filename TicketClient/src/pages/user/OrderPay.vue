<template>
  <div>
    <div id="order-pay">
      <div id="order-pay-container">
        <div class="banner">
          <div>
            <img src="../../assets/order.svg"/>
            <h2>订单提交成功！去付款咯~~~</h2>
          </div>
          <span class="redFont">应付总金额：{{order.total - order.discount}}元</span>
        </div>
        <div class="timer">
          <div>请在15分钟内完成支付</div>
          <div>还剩<span class="remain">{{minutes}}:{{seconds}}</span></div>
        </div>
      </div>
      <div class="order-pay-method">
        <span>支付方式：</span>
        <span class="pay-method" @click="dialogVisible = true"><img src="../../assets/remain.svg"/><span>账户余额</span></span>
        <span class="pay-method"><img src="../../assets/wechat.svg"/><span>微信支付</span></span>
        <span class="pay-method"><img src="../../assets/alipay.svg"/><span>支付宝</span></span>
      </div>
    </div>
    <el-dialog
      title="输入密码"
      :visible.sync="dialogVisible"
      width="400px"
      center>
      <div>
        <el-input v-model="payPassword"></el-input>
        <div class="label" :class="{displayNone: labelVisible}">密码错误，请重新输入</div>
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="payment">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import {mapGetters} from 'vuex'
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  export default{
    components: {ElInput},
    computed:{
//      ...mapGetters({
//        order: 'order'
//      })
    },
    data(){
      return{
        time: "",
        restTime: 15 * 60 * 1000,
        rootTime: "",
        minutes: "",
        seconds: "",
        timer: "",
        order: {},
        dialogVisible: false,
        labelVisible: true,
        userInfo: {},
        payPassword: ''
      }
    },
    created(){
      var userId = JSON.parse(window.localStorage.getItem('userId'))
      var self = this
      this.$http({
        method: 'get',
        url: '/User/findById/id/'+userId
      }).then(function (res) {
        console.log(res)
        self.userInfo = res.data
      }).catch(function (err) {
        console.log(err)
      })
      console.log(this.userInfo)
    },
    methods: {
      countdownTimer: function () {
        this.rootTime = +new Date(this.order.date)
        this.timer = window.setInterval(this.countdown, 100);
      },
      countdown: function () {
        this.time = new Date((this.restTime + this.rootTime) - new Date());
        this.minutes = (this.time.getMinutes() < 10 ? "0" + this.time.getMinutes() : this.time.getMinutes());
        this.seconds = (this.time.getSeconds() < 10 ? "0" + this.time.getSeconds() : this.time.getSeconds());
        if(this.time <= 0){
          this.minutes = "00";
          this.seconds = "00";
//          this.overtime1()
          clearInterval(this.timer);
        }
      },
      overtime1(){
        this.$http({
          method: 'post',
          url: '/Order/fail/'+this.$route.params.number,
        }).then(function (res) {
        }).catch(function (err) {
          console.log(err)
        })
      },
      payment(){
        var self = this
        if (this.payPassword == this.userInfo.password){
          this.$http({
            method: 'post',
            url: '/Order/pay/'+this.$route.params.number,
          }).then(function (res) {
            self.$router.push({name: 'OrderSuccess',params:{id: self.userInfo.id}})
          }).catch(function (err) {
            console.log(err)
          })
        }else{
            this.labelVisible = false
        }
      }
    },
    mounted(){
      var self = this
      this.$http({
        method: 'post',
        url: '/Order/number/'+this.$route.params.number
      }).then(function (res) {
        self.order = res.data
        self.countdownTimer()
      })
    }
  }
</script>

<style>
  #order-pay{
    display: inline-block;
    width: 720px;
  }

  #order-pay-container{
    display: inline-block;
    width: 700px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    margin-top: 40px;
    border-radius: 5px;
    text-align: left;
  }

  .order-pay-method{
    display: inline-block;
    width: 700px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    margin-top: 40px;
    border-radius: 5px;
    text-align: left;
  }

  .banner{
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 20px;
  }

  .banner div{
    display: flex;
    align-items: center;
  }

  .banner h2{
    display: inline-block;
    margin-left: 20px;
  }

  .redFont{
    color: #EA2000;
    font-size: 18px;
  }

  .timer{
    margin-left: 70px;
    font-size: 18px;
    line-height: 35px
  }

  .remain{
    font-size: 25px;
    color: #EA2000;
  }

  .order-pay-method{
    display: flex;
    align-items: center;
  }

  .pay-method{
    display: flex;
    align-items: center;
    margin-left: 30px;
    cursor: pointer;
  }

  .label{
    font-size: 13px;
    color: #EA2000;
    text-align: center;
  }

  .displayNone{
    visibility: hidden;
  }

</style>
