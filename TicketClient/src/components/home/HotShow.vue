<template>
  <div id="hot-show">
    <div class="hot-show-head">
      <span class="hot-show-head-title">近期热门</span>
      <span class="hot-show-head-more">查看更多></span>
    </div>
    <div class="hot-show-container" style="text-align: left">
        <hot-show-display v-for="(item,index) in hotShowInfoList" :key="index" :hot-show-info="item"></hot-show-display>
    </div>
  </div>
</template>

<script>
  import HotShowDisplay from './HotShowDisplay.vue'
  export default {
    components: {
      HotShowDisplay
    },
    data () {
      return {
          hotShowInfoList: [
            {
              posterUrl: 'https://picsum.photos/200/300/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/302/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/303/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/304/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/299/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/298/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/297/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/296/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/295/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            },
            {
              posterUrl: 'https://picsum.photos/200/294/?random',
              title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
              price: 101
            }
          ]
      }
    }
  }
</script>

<style>
  /*@import "../../style/masonry.css";*/

  #hot-show{
    margin-top: 30px;
  }

  .hot-show-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .hot-show-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .hot-show-head-more{
    cursor: pointer;
  }

  .hot-show-head-more:hover{
    color: #10cf7d;
  }
</style>
