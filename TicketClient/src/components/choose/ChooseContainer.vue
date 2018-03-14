<template>
  <div id="choose-container">
    <div style="text-align: left">
      <choose-show-display v-for="(item, index) in chooseShowInfoList" :key="index" :choose-show-info="item"
        v-if="(currentPage - 1) * pageSize <= index && index < currentPage * pageSize"></choose-show-display>
    </div>
    <div style="text-align: right;margin-top: 80px">
      <el-pagination
        background
        layout="prev, pager, next, jumper"
        :page-size="pageSize"
        :total="totalSize"
        :current-page.sync="currentPage"
        @current-change="handleCurrentChange">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import ChooseShowDisplay from './ChooseShowDisplay.vue'
  export default{
    components:{
      ChooseShowDisplay
    },
    computed: {
      totalSize: function () {
        return this.chooseShowInfoList.length
      },
    },
    props: ['chooseShowInfoList'],
    data () {
      return{
        pageSize: 10,
        currentPage: 1
      }
    },
    methods: {
      handleCurrentChange: function (val) {
        this.currentPage = val
      }
    },
  }
</script>

<style>
  #choose-container{
    margin-top: 50px;
    text-align: left;
    padding-bottom: 100px;
  }

  .noneDisplay{
    display: none;
  }
</style>
