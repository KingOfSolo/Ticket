<template>
  <div class="opera">
    <div class="opera-head">
      <div class="opera-head-title">话剧歌剧</div>
      <div class="opera-head-more">查看更多></div>
    </div>
    <div class="opera-container">
      <big-show-display :big-show-info="operaBigShow"></big-show-display>
      <div style="display: inline-block; text-align: left;width: 940px;vertical-align: top;margin-left: 5px">
        <small-show-display v-for="item in operaSmallShow" :key="item" :small-show-display="item"></small-show-display>
      </div>
    </div>
  </div>
</template>

<script>
  import BigShowDisplay from './BigShowDisplay.vue'
  import SmallShowDisplay from './SmallShowDisplay.vue'
  export default{
    components: {
      BigShowDisplay,
      SmallShowDisplay
    },
    data () {
      return {
        operaBigShow: {
          posterUrl: 'https://picsum.photos/400/610/?random',
          title: '【上海站】世界经典原版音乐剧《猫》CATS',
          price: 998
        },
        operaSmallShow: [
          {
            posterUrl: 'https://picsum.photos/201/299/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/202/298/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/199/297/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/198/296/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/197/295/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/400/294/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
        ]
      }
    }
  }
</script>

<style>
  .opera{
    margin-top: 30px;
  }

  .opera-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .opera-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .opera-head-more{
    cursor: pointer;
  }

  .opera-head-more:hover{
    color: #10cf7d;
  }

  .opera-container{
    text-align: left;
  }
</style>
