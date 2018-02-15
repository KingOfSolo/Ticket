<template>
  <div id="user">
    <el-tabs :tab-position="tabPosition" type="border-card">
      <el-tab-pane name="first">
        <span slot="label"><i class="el-icon-edit">账号管理</i></span>
        <account-manage></account-manage>
      </el-tab-pane>
      <el-tab-pane label="我的订单" name="second">
        <span slot="label"><i class="el-icon-tickets"></i>我的订单</span>
        配置管理
      </el-tab-pane>
      <el-tab-pane label="地址管理" name="third">
        <span slot="label"><i class="el-icon-location-outline"></i>地址管理</span>
        角色管理
      </el-tab-pane>
      <el-tab-pane name="fourth">
        <span slot="label"><i class="el-icon-date"></i>统计数据</span>
        统计数据</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import AccountManage from '../components/user/AccountManage.vue'
  export default{
    components: {
      AccountManage
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
