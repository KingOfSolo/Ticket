<template>
  <div class="concert">
    <div class="concert-head">
      <div class="concert-head-title">演唱会</div>
      <div class="concert-head-more" @click="toChoosePage">查看更多></div>
    </div>
    <div class="concert-container">
      <big-show-display :big-show-info="concertBigShow"></big-show-display>
      <div style="display: inline-block; text-align: left;width: 940px;vertical-align: top;margin-left: 5px">
        <small-show-display v-for="item in concertSmallShow" :key="item" :small-show-display="item"></small-show-display>
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
        concertBigShow: {
          posterUrl: 'https://picsum.photos/400/601/?random',
          title: '【上海站】世界经典原版音乐剧《猫》CATS',
          price: 998
        },
        concertSmallShow: [
          {
            posterUrl: 'https://picsum.photos/201/300/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/202/300/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/199/300/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/198/300/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/197/300/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
          {
            posterUrl: 'https://picsum.photos/400/600/?random',
            title: '【上海站】世界经典原版音乐剧《猫》CATS',
            time: '2018.03.08 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 998
          },
        ]
      }
    },
    methods: {
      toChoosePage: function () {
        this.$router.push({name: 'Choose'})
      }
    }
  }
</script>

<style>
  .concert{
    margin-top: 30px;
  }

  .concert-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .concert-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .concert-head-more{
    cursor: pointer;
  }

  .concert-head-more:hover{
    color: #10cf7d;
  }

  .concert-container{
    text-align: left;
  }
</style>
