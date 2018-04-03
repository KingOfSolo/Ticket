<template>
  <div id="ticket-login">
    <div id="ticket-container">
      <div class="login">
        <div class="background-image-in" :style="backgroundStyle" @mousemove="mouseMove"></div>
        <div class="content">
          <h2 style="text-align: center">Tickets经理登录</h2>
          <div style="text-align: center;margin-top: 20px">
            <input class="ticket-login-input" placeholder="账号" v-model="loginInfo.account"/>
            <input class="ticket-login-input" placeholder="密码" type="password" v-model="loginInfo.password"/>
            <button class="ticket-login-button" @click="ticketLogin">登录</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    data () {
      return{
        backgroundStyle:{
          backgroundImage: "url(https://picsum.photos/400/701)",
          backgroundPosition: '0% 0%'
        },
        loginInfo: {
          account:'',
          password:''
        }
      }
    },
    methods: {
      mouseMove: function (event) {
        var amountMovedX = (event.pageX * -1 / 30);
        var amountMovedY = (event.pageY * -1 / 9);
        this.backgroundStyle.backgroundPosition = amountMovedX + 'px '+amountMovedY+'px';
      },
      ticketLogin: function () {
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/login',
          data: this.loginInfo
        }).then(function (res) {
          console.log(res)
          if (res.data != ''){
            self.$router.push({name: 'Ticket'})
          }else{
            self.$message({
              message:'用户名或密码错误',
              type: 'error'
            })
          }
        }).catch(function (err) {
          console.log(err)
        })
      }
    }
  }
</script>

<style>
  #ticket-login{
    padding-top: 40px;
  }

  #ticket-container{
    position: relative;
    overflow: hidden;
    text-align: left;
    display: inline-block;
    height: 500px;
    width: 700px;
    box-shadow: 0 0 30px rgba(0,0,0,.1);
  }

  .background-image-in{
    overflow: hidden;
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    display: inline-block;
    width: 50%;
    transition: all 0.2s;
  }

  .content{
    position: absolute;
    right: 0;
    top: 0;
    bottom: 0;
    display: inline-block;
    width: 48%;
    padding-top: 60px;
  }

  .ticket-login-input{
    display: inline;
    outline: none;
    width: 65%;
    height: 40px;
    font-size: 14px;
    margin-top: 30px;
    color: #999999;
    border: 1px solid #d9d9d9;
    border-radius: 2px;
    padding: 0 5%;
  }

  .ticket-login-input::-webkit-input-placeholder{
    color: #999999;
  }

  .ticket-login-input:-moz-placeholder{
    color: #999999;
  }

  .ticket-login-input::-moz-placeholder{
    color: #999999;
  }

  .ticket-login-button{
    margin-top: 30px;
    width: 75%;
    line-height: 40px;
    vertical-align: middle;
    border: 1px solid #10cf7d;
    background-color: transparent;
    border-radius: 2px;
    color: #10cf7d;
    cursor: pointer;
    padding: 0 10px;
    outline: none;
    letter-spacing: 5px;
    transition: all 0.3s;
  }

  .ticket-login-button:hover{
    background-color: #10cf7d;
    color: white;
  }
</style>
