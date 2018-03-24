<template>
  <div id="venue-login">
    <div class="container">
      <div class="sign-in">
        <div class="content">
          <h2 style="text-align: center">掠影</h2>
          <div style="text-align: center;margin-top: 20px">
            <input class="venue-login-input" placeholder="识别码" v-model="identification"/>
            <input class="venue-login-input" placeholder="密码" v-model="password"/>
            <button class="venue-login-button" @click="venueLogin">登录</button>
            <div class="more" @click="toSignUp">场馆注册></div>
          </div>
        </div>
        <div class="background-image-in" :style="backgroundStyleIn" @mousemove="mouseMove">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import qs from 'qs'
  export default{
    components: {ElFormItem},
    data () {
      return {
        backgroundStyleIn:{
          backgroundImage: "url(https://picsum.photos/400/701)",
          backgroundPosition: '0% 0%'
        },
        backgroundStyleUp:{
          backgroundImage: "url(https://picsum.photos/400/701)",
          backgroundPosition: '0% 0%'
        },
        sign: true,
        identification: '',
        password: ''
      }
    },
    methods: {
      mouseMove: function (event) {
        var amountMovedX = (event.pageX * -1 / 30);
        var amountMovedY = (event.pageY * -1 / 9);
        this.backgroundStyleIn.backgroundPosition = amountMovedX + 'px '+amountMovedY+'px';
      },
      toSignUp: function () {
        this.$router.push({name: 'SignUp'})
      },
      venueLogin: function () {
        var self = this
        this.$http({
          method: 'post',
          url: '/Venue/login',
          data: {
            identification: this.identification,
            password: this.password
          }
        }).then(function (res) {
          console.log(res)
          self.$router.push({name: 'Venue',params: {venueId: res.data}})
        })
      }
    }
  }
</script>

<style>
  #venue-login{
    padding-top: 40px;
  }

  .container{
    position: relative;
    overflow: hidden;
    text-align: left;
    display: inline-block;
    height: 500px;
    width: 700px;
    box-shadow: 0 0 30px rgba(0,0,0,.1);
  }

  .content{
    display: inline-block;
    width: 48%;
    padding-top: 60px;
  }

  .background-image-in{
    overflow: hidden;
    position: absolute;
    right: 0;
    top: 0;
    bottom: 0;
    display: inline-block;
    width: 50%;
    transition: all 0.2s;
  }

  .venue-login-input{
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

  .venue-login-input::-webkit-input-placeholder{
    color: #999999;
  }

  .venue-login-input:-moz-placeholder{
    color: #999999;
  }

  .venue-login-input::-moz-placeholder{
    color: #999999;
  }

  .venue-login-button{
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

  .venue-login-button:hover{
    background-color: #10cf7d;
    color: white;
  }

  .more{
    margin-top: 20px;
    font-size: 12px;
    color: #999999;
    cursor: pointer;
  }

  .more:hover{
    text-decoration: underline;
  }

  .background-image-up{
    overflow: hidden;
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    display: inline-block;
    width: 50%;
    transition: all 0.2s;
  }


  .signUpContent{
    display: inline-block;
    width: 48%;
    padding-top: 30px;
    position: absolute;
    right: 0;
    top: 0;
    bottom: 0;
  }

</style>
