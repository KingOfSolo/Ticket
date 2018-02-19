<template>
  <div id="user">
    <el-tabs :tab-position="tabPosition" type="border-card" value="first">
      <el-tab-pane name="first">
        <span slot="label"><i class="el-icon-edit">账号管理</i></span>
        <account-manage></account-manage>
      </el-tab-pane>
      <el-tab-pane name="second">
        <span slot="label"><i class="el-icon-tickets"></i>我的订单</span>
        <my-order></my-order>
      </el-tab-pane>
      <el-tab-pane name="third">
        <span slot="label"><i class="el-icon-location-outline"></i>地址管理</span>
        <receive-address></receive-address>
      </el-tab-pane>
      <el-tab-pane name="fourth">
        <span slot="label"><i class="el-icon-date"></i>统计数据</span>
        <personal-data></personal-data>
      </el-tab-pane>
    </el-tabs>
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
        tabPosition: 'left'
      }
    }
  }
</script>

<style>
  #user{
    padding: 40px 15% 0 15%;
  }
</style>
