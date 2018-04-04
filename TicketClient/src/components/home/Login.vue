<template>
  <div>
    <div class="container">
      <div id="page-wrapper">
        <div id="modal-wrapper">
          <div id="modal">
            <div id="cards">
              <div class="card" id="login1">
                <div class="box">
                  <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="84px" height="70px" viewBox="0 0 600 332" enable-background="new 0 0 600 332" xml:space="preserve">
                  <path id="SVGID_1_" d="M48.207,322.346H2.201l195.546-296.91l29.083,24.881L48.207,322.346L48.207,322.346z M366.916,323.3L184.581,45.545l22.235-34.362l182.337,277.754L366.916,323.3L366.916,323.3z M206.816,322.346c0,0-32.511-50.283-67.621-102.999c-7.233-10.859-14.576-21.821-21.768-32.47c-0.586-0.867,14.985-46.926,21.658-36.678c7.217,11.086,14.388,22.232,21.347,33.138c36.734,57.58,67.509,108.465,67.509,108.465L206.816,322.346L206.816,322.346z M313.043,162.238l-39.053,59.399c-31.744,48.284-57.467,87.41-57.467,87.41l-31.942-22.019c0,0,29.998-44.644,67.215-101.253c5.132-7.806,10.351-15.742,15.577-23.694c4.91-7.47,9.831-14.953,14.699-22.356C321.356,79.969,366.42,11.184,366.42,11.184h45.049C411.469,11.184,353.769,100.292,313.043,162.238L313.043,162.238z M375.986,309.048l-29.083-24.882L526.486,11.184h45.046L375.986,309.048L375.986,309.048z"></path>
                </svg>
                </div>
                <form id="login-form">
                  <label>邮箱</label>
                  <input type="text" id="login-email" class="textbox" v-model="loginData.email">
                  <label>密码</label>
                  <input type="password" id="login-password" class="textbox" v-model="loginData.password">
                </form>
                <button type="submit" class="proceed" @click="login">确认登录</button>
              </div>
              <div class="card" id="register">
                <div class="box">
                  <div id="branding-small">
                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="42px" height="35px" viewBox="0 0 600 332" enable-background="new 0 0 600 332" xml:space="preserve">
                  <path id="SVGID_1_" d="M48.207,322.346H2.201l195.546-296.91l29.083,24.881L48.207,322.346L48.207,322.346z M366.916,323.3L184.581,45.545l22.235-34.362l182.337,277.754L366.916,323.3L366.916,323.3z M206.816,322.346c0,0-32.511-50.283-67.621-102.999c-7.233-10.859-14.576-21.821-21.768-32.47c-0.586-0.867,14.985-46.926,21.658-36.678c7.217,11.086,14.388,22.232,21.347,33.138c36.734,57.58,67.509,108.465,67.509,108.465L206.816,322.346L206.816,322.346z M313.043,162.238l-39.053,59.399c-31.744,48.284-57.467,87.41-57.467,87.41l-31.942-22.019c0,0,29.998-44.644,67.215-101.253c5.132-7.806,10.351-15.742,15.577-23.694c4.91-7.47,9.831-14.953,14.699-22.356C321.356,79.969,366.42,11.184,366.42,11.184h45.049C411.469,11.184,353.769,100.292,313.043,162.238L313.043,162.238z M375.986,309.048l-29.083-24.882L526.486,11.184h45.046L375.986,309.048L375.986,309.048z"></path>
                </svg>
                  </div>
                  <div class="box-header">注册</div>
                  <form id="register-form">
                    <label>邮箱</label>
                    <input type="text" id="register-email" class="textbox" v-model="registerData.email">
                    <label>昵称</label>
                    <input id="register-password" class="textbox" v-model="registerData.name">
                    <label>密码</label>
                    <input type="password" id="register-password-conf" class="textbox" v-model="registerData.password">
                  </form>
                </div>
                <button type="submit" class="proceed" @click="register">确认注册</button>
              </div>
            </div>
            <div id="toggle-tabs">
              <div class="tab" id="toggle-login">登录</div>
              <div class="tab" id="toggle-register">注册</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  export default{
    data () {
      return {
        showSign: false,
        showSignButton: false,
        radio: 1,
        loginData: {
          email: '',
          password: ''
        },
        registerData: {
          name: '',
          email: '',
          password: ''
        },
      }
    },
    methods: {
      login(){
        var self = this
        this.$http({
          method: 'post',
          url: '/User/login',
          data: this.loginData
        }).then(function (res) {
          console.log(res)
          if(res.data == ""){
            self.$message({
              message:'未找到用户或者用户未激活',
              type: 'error'
            })
          }else{
            self.$store.dispatch('USER_SIGNIN',res.data)
            self.$emit('loginSuccess')
            window.localStorage.setItem('userId', JSON.stringify(res.data.id))
          }

        }).catch(function (err) {
          alert(err)
        })
      },
      register(){
        var self = this
        this.$http({
          method: 'post',
          url: '/User/register',
          data: this.registerData
        }).then(function (res) {
          console.log(res)
//          self.$store.dispatch('USER_SIGNIN',res.data)
//          self.$emit('loginSuccess')
        }).catch(function (err) {
          alert(err)
        })
      },
      signUp () {
        var self = this
//        this.$emit('signUpSuccess', 'success')
//        this.$http({
//          method: 'post',
//          url: '/login/signUp',
//          data: {
//            vo: {
//              nickName: this.signUpNickName,
//              username: this.signUpUserName,
//              password: this.signUpPassword,
//              intro: '无个性签名',
//              follows: 0,
//              fans: 0,
//              gender: '男',
//              phone: '未绑定手机',
//              headUrl: 'https://picsum.photos/200/200/?random'
//            }
//          }
//        }).then(function (res) {
//          self.$emit('signUpSuccess', res.data.token, '注册成功')
//        }).catch(function (err) {
//          alert(err)
//        })
      },
      signIn () {
        var self = this
//        this.$http({
//          method: 'post',
//          url: '/login/signIn',
//          data: {
//            username: this.signInUserName,
//            password: this.signInPassword
//          }
//        }).then(function (res) {
//          console.log(res)
//          self.$emit('signUpSuccess', res.data.token, '登录成功')
//        }).catch(function (err) {
//          alert(err)
//        })
      },
      showLogin () {
        this.showSign = true
        this.showSignButton = true
      },
      showSignUp () {
        this.showSign = false
        this.showSignButton = false
      },
    },
    mounted(){
      var login = $('#login1');
      var register = $('#register');
      var button_login = $('#toggle-login');
      var button_register = $('#toggle-register');
      var box = $('.box')
      register.hide();

      button_register.click(function() {
        login.slideUp(1000);
        register.slideDown(1000);
      });
      button_login.click(function() {
        register.slideUp(1000);
        login.slideDown(1000);
      });
    }
  }
</script>

<style>
  @import "../../style/scss/login.css";
  .transformSignUp{
    transform: translateX(0);
  }
</style>
