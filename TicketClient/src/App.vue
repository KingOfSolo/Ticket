<template>
  <div id="app">
    <div id="header">
      <el-button type="text" id="logo">掠影</el-button>
      <div id="login">
        <div id="search-container" style="width: 100%">
          <input id="search-input" placeholder="搜索演出、场馆"/>
          <div id="search-button">
            <i class="el-icon-search"></i>
            <!--<img src="./assets/search.svg">-->
            搜索
          </div>
        </div>
        <div v-if="isLogin">
          <el-button type="text" class="header-button" @click="isLogin = false">登录</el-button>
        </div>
        <div v-else>
          <el-dropdown style="margin-left: 10px" @command="handleCommand">
          <span class="el-dropdown-link">
            <img id="head-portrait" :src="headUrl"/>
          </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="a">我的订单</el-dropdown-item>
              <el-dropdown-item command="b">优惠券</el-dropdown-item>
              <el-dropdown-item command="c">地址管理</el-dropdown-item>
              <el-dropdown-item command="d">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
    <router-view/>
  </div>
</template>

<script>
  import ElDropdownItem from "../node_modules/element-ui/packages/dropdown/src/dropdown-item";
export default {
  components: {ElDropdownItem},
  data () {
    return {
      value1: '',
      color: 'white',
      isLogin: true,
      loginDialogVisible: false,
      showClose: false,
      headUrl: 'https://picsum.photos/200/200'
    }
  },
  methods: {
    handleCommand (command) {
      if (command === 'a') {
        this.$router.push({name: 'UserSetting', params: {userId: '0001'}})
      } else if (command === 'd') {
        var loginId = this.$cookie.get('loginId') + ''
        this.$router.push({name: 'UserCenter', params: {userId: loginId}})
      } else if (command === 'c') {
        this.isLogin = true
        this.$router.push({name: 'Main'})
        this.$cookie.delete('token')
        this.$cookie.delete('loginId')
      }
    },
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 70px;
}
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
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  background-color: white;
  /*padding: 0 100px 0 100px;*/
  height: 70px;
  box-shadow: 0 0 5px #d2d2d2;
  z-index: 100;
}

#login{
  display: flex;
  justify-content: flex-end;
  align-items: center;
  flex-grow: 1;
  margin-right: 10%;
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

#search-container{
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  margin-right: 300px;
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


</style>
