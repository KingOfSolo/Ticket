<template>
  <div id="user">
    <div class="tab-container">
      <div class="user-tab">
        <div class="user-tab-item" v-for="(item,index) in userTab" :key="index"
             :class="{userTabActive: index == tabActiveNum}" @click="userTabClick(index)">{{item}}</div>
      </div>
      <div class="user-content">
        <account-manage v-if="tabActiveNum == 0" :user-info="userInfo"></account-manage>
        <my-order v-else-if="tabActiveNum == 1"></my-order>
        <personal-data v-else-if="tabActiveNum == 2"></personal-data>
      </div>
    </div>
  </div>
</template>

<script>
  import AccountManage from '../../components/user/AccountManage.vue'
  import MyOrder from '../../components/user/MyOrder.vue'
  import ReceiveAddress from '../../components/user/ReceiveAddress.vue'
  import PersonalData from '../../components/user/PersonalData.vue'
  export default{
    components: {
      AccountManage,
      MyOrder,
      ReceiveAddress,
      PersonalData
    },
    data () {
      return {
        userTab: ['账号管理','我的订单','统计数据'],
        tabActiveNum: 0,
        userInfo: {}
      }
    },
    methods:{
      userTabClick(index){
        this.tabActiveNum = index
      }
    },
    created(){
      var self = this
      this.$http({
        method: 'get',
        url: '/User/findById/id/'+this.$route.params.userId
      }).then(function (res) {
        console.log(res)
        self.userInfo = res.data
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style>
  #user{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    vertical-align: top;
  }

  .tab-container{
    display: flex;
    justify-content: flex-start;
  }

  .user-tab{
    margin-top: 40px;
    display: inline-block;
    margin-right: 30px;
  }

  .user-tab-item{
    padding: 20px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    /*border-radius: 5px;*/
    border: 1px solid #eeeeee;
    cursor: pointer;
    color: #909399;
  }

  .user-tab-item:hover{
    color: #10cf7d;
  }

  .userTabActive{
    color: #10cf7d;
  }

  .user-content{
    display: inline-block;
    width: 800px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    margin-top: 40px;
    border-radius: 5px;
    text-align: left;
    margin-bottom: 40px;
  }
</style>
