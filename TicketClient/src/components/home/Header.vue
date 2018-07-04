<template>
  <div id="header">
    <el-button type="text" id="logo" @click="toHome">
      <div style="display: flex;align-items: center">
        <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="40px" height="35px" viewBox="0 0 600 332" enable-background="new 0 0 600 332" xml:space="preserve">
          <path id="SVGID_1_" d="M48.207,322.346H2.201l195.546-296.91l29.083,24.881L48.207,322.346L48.207,322.346z M366.916,323.3L184.581,45.545l22.235-34.362l182.337,277.754L366.916,323.3L366.916,323.3z M206.816,322.346c0,0-32.511-50.283-67.621-102.999c-7.233-10.859-14.576-21.821-21.768-32.47c-0.586-0.867,14.985-46.926,21.658-36.678c7.217,11.086,14.388,22.232,21.347,33.138c36.734,57.58,67.509,108.465,67.509,108.465L206.816,322.346L206.816,322.346z M313.043,162.238l-39.053,59.399c-31.744,48.284-57.467,87.41-57.467,87.41l-31.942-22.019c0,0,29.998-44.644,67.215-101.253c5.132-7.806,10.351-15.742,15.577-23.694c4.91-7.47,9.831-14.953,14.699-22.356C321.356,79.969,366.42,11.184,366.42,11.184h45.049C411.469,11.184,353.769,100.292,313.043,162.238L313.043,162.238z M375.986,309.048l-29.083-24.882L526.486,11.184h45.046L375.986,309.048L375.986,309.048z"></path>
        </svg>
        掠影
      </div>
    </el-button>
    <span style="display: flex;align-items: center">
      <input id="search-input" placeholder="搜索演出、场馆"/>
        <div id="search-button" @click="searchDialogVisible = true">
          <i class="el-icon-search"></i>
          搜索
        </div>
    </span>
    <span style="margin-right: 10%">
      <div v-if="isLogin">
        <el-dropdown style="margin-left: 10px" @command="handleCommand">
          <span class="el-dropdown-link">
            <span class="flex-center">
              <img id="head-portrait" :src="headUrl"/>
              <span id="username">{{username}}</span>
            </span>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="a">个人中心</el-dropdown-item>
            <el-dropdown-item command="d">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <div v-else>
        <el-button type="text" class="header-button" @click="loginDialogVisible = true">登录</el-button>
      </div>
    </span>
    <el-dialog
      :visible.sync="loginDialogVisible"
      width="429px"
      :append-to-body="true"
      :show-close="false">
      <login v-on:loginSuccess = "loginSuccess"></login>
    </el-dialog>
  </div>
</template>

<script>
  import ElDropdownItem from "../../../node_modules/element-ui/packages/dropdown/src/dropdown-item";
  import {mapGetters} from 'vuex'
  import Login from "./Login.vue"
  export default {
    components: {
      ElDropdownItem,
      Login
    },
    computed: {
      ...mapGetters({
        isLogin: 'isLogin',
        userInfo: 'user'
      }),
    },
    data () {
      return {
        value1: '',
        color: 'white',
        loginDialogVisible: false,
        showClose: false,
        headUrl: 'https://picsum.photos/200/200',
        isModal: false,
        username: '浅安',
        searchDialogVisible: false
      }
    },
    created(){
      var userId = JSON.parse(window.localStorage.getItem('userId'));
      if (userId == null || userId == '' || userId == undefined){
          this.username = '浅安';
      }else {
        var self = this;
        this.$http({
          method: 'get',
          url: '/User/findById/id/'+ userId
        }).then(function (res) {
          console.log(res)
          self.username = res.data.name
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    methods: {
      handleCommand (command) {
        var userId = JSON.parse(window.localStorage.getItem('userId'))
        if (command === 'a') {
          this.$router.push({name: 'User', params: {userId: userId, index: 0}})
        } else if (command === 'd') {
          this.$store.dispatch('USER_SIGNOUT');
          window.localStorage.removeItem('userId');
          this.$router.push({name: 'Home'})
        } else if (command === 'c') {
          this.isLogin = true
          this.$router.push({name: 'Main'});
          this.$cookie.delete('token');
          this.$cookie.delete('loginId');
        }
      },
      loginSuccess(){
        this.loginDialogVisible = false;
        var userId = JSON.parse(window.localStorage.getItem('userId'));
        var self = this;
        this.$http({
          method: 'get',
          url: '/User/findById/id/'+ userId
        }).then(function (res) {
          console.log(res)
          self.username = res.data.name
        }).catch(function (err) {
          console.log(err)
        })
        this.$message({
          message:'登录成功',
          type: 'success'
        })
      },
      toHome(){
        this.$router.push({name: 'Home'})
      }
    }
  }
</script>

<style>
  #main{
    padding: 0;
    margin-top: 60px;
  }

  #logo{
    margin-left: 10%;
    font-size: large;
  }

  /*#search{*/
  /*margin-right: 10px;*/
  /*width: 250px !important;*/
  /*border-radius: 20px !important;*/
  /*border: 1px solid black !important;*/
  /*}*/

  #login .el-input{
    /*width: 250px;*/
    /*height: 33px;*/
  }

  path{
    fill: #10cf7d;
  }

  #login .el-input__inner{
    /*width: 250px;*/
    /*height: 33px;*/
    font-size: 14px;
    /*border: 1px solid #e9e9e9;*/
    border-radius: 20px;
    background-color: #f7f8f9;
  }

  #login .el-input__icon{
    width: 15px;
    margin-right: 5px;
  }


  /*.el-input__suffix-inner{*/
  /*height: 33px;*/
  /*}*/

  #header{
    position: fixed;
    left:0;
    top: 0;
    width: 100%;
    display: flex;
    justify-content: space-between;
    /*flex-direction: row;*/
    /*justify-content: flex-start;*/
    align-items: center;
    background-color: white;
    /*padding: 0 100px 0 100px;*/
    height: 70px;
    box-shadow: 0 0 5px #d2d2d2;
    z-index: 100;
  }

  .header-button{
    /*color: #020202;*/
    font-size: 18px;
    margin-left: 10px;

  }

  .header-button:hover{
    color: #10cf7d;
  }

  #head-portrait{
    width: 30px;
    height: 30px;
    border-radius: 50%;
  }

  #search-input{
    width: 450px;
    height: 35px;
    outline: none;
    border: 0;
    background-color: #f2f2f2;
    border-radius: 20px;
    padding-left: 20px;
  }
  #search-button{
    display: inline-block;
    background-color: #10cf7d;
    color: white;
    border-radius: 15px;
    font-size: 13px;
    width: 45px;
    padding: 5px 10px 5px 10px;
    margin-left: -70px;
    cursor: pointer;
  }

  .el-dialog__body{
    padding: 0;
  }

  .el-dialog__header{
    display: none;
  }

  .flex-center{
    display: flex;
    align-items: center;
  }

  #username {
    margin-left: 5px;
  }

</style>
