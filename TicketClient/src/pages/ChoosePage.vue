<template>
  <div id="choose">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="演唱会" name="a">演唱会</el-tab-pane>
      <el-tab-pane label="话剧歌剧" name="b">话剧歌剧</el-tab-pane>
      <el-tab-pane label="体育赛事" name="c">体育赛事</el-tab-pane>
      <el-tab-pane label="音乐会" name="d">音乐会</el-tab-pane>
      <el-tab-pane label="儿童亲子" name="e">儿童亲子</el-tab-pane>
      <el-tab-pane label="舞蹈芭蕾" name="f">舞蹈芭蕾</el-tab-pane>
      <el-tab-pane label="展览休闲" name="g">展览休闲</el-tab-pane>
      <el-tab-pane label="曲艺杂谈" name="h">曲艺杂谈</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default{
    data () {
      return{

      }
    }
  }
</script>

<style>
  #choose{
    padding: 30px 10% 0 10%;
  }

  #choose .el-tabs__item{
    font-size: 20px;
    padding: 0 30px 0 40px;
  }

</style>
