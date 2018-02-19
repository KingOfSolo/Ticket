<template>
  <div id="choose">
    <div class="choose-tab">
      <span class="choose-tab-item" v-for="(item, index) in tabs" @click="tabClick(index)" :class="{tabActive: index == tabActiveNum}">{{item}}</span>
    </div>
    <choose-container></choose-container>
  </div>
</template>

<script>
  import ChooseContainer from '../../components/choose/ChooseContainer.vue'
  export default{
    components: {
      ChooseContainer
    },
    data () {
      return{
        tabs: ['全部', '演唱会', '话剧歌剧', '体育赛事', '音乐会', '儿童亲子', '舞蹈芭蕾', '展览休闲', '曲艺杂谈'],
        tabActiveNum: 0
      }
    },
    methods:{
      tabClick: function (index) {
        this.tabActiveNum = index
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

  .choose-tab{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }

  .choose-tab-item{
    font-size: large;
    cursor: pointer;
    padding-bottom: 5px;
  }

  .choose-tab-item:hover{
    color: #10cf7d;
    border-bottom: 2px solid #10cf7d;
  }

  .tabActive{
    color: #10cf7d;
    border-bottom: 2px solid #10cf7d;
  }

</style>
