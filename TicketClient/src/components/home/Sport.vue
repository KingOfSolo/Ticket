<template>
  <div class="sport">
    <div class="sport-head">
      <div class="sport-head-title">体育赛事</div>
      <div class="sport-head-more">查看更多></div>
    </div>
    <div class="sport-container">
      <big-show-display :big-show-info="sportBigShow"></big-show-display>
      <div style="display: inline-block; text-align: left;width: 940px;vertical-align: top">
        <small-show-display v-for="item in sportSmallShow" :key="item" :small-show-display="item"></small-show-display>
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
        sportBigShow: {
          posterUrl: 'https://picsum.photos/400/602/?random',
          title: '【上海站】世界经典原版音乐剧《猫》CATS',
          price: 998
        },
        sportSmallShow: [
          {
            posterUrl: 'https://picsum.photos/201/301/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/202/302/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/199/303/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/198/304/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/197/305/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/196/306/?random',
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
  .sport{
    margin-top: 70px;
  }

  .sport-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .sport-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .sport-head-more{
    cursor: pointer;
  }

  .sport-head-more:hover{
    color: #10cf7d;
  }

  .sport-container{
    text-align: left;
  }
</style>
