<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  import ElDropdownItem from "../node_modules/element-ui/packages/dropdown/src/dropdown-item";
  export default {
  components: {
    ElDropdownItem
  },
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
        this.$router.push({name: 'User', params: {userId: '0001'}})
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
