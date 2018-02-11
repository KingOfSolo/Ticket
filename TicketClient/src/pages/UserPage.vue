<template>
  <div id="user">
    <el-tabs :tab-position="tabPosition" type="border-card">
      <el-tab-pane label="账号管理" name="first">用户管理</el-tab-pane>
      <el-tab-pane label="我的订单" name="second">配置管理</el-tab-pane>
      <el-tab-pane label="地址管理" name="third">角色管理</el-tab-pane>
      <el-tab-pane label="统计数据" name="fourth">定时任务补偿</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default{
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
