<template>
  <div class="hot-show-display" @click="toShowDetail">
    <img :src="hotShowInfo.posterUrl"/>
    <div class="hot-show-display-title">{{ hotShowInfo.title }}</div>
    <div class="hot-show-display-price">
      <span style="font-size: large;font-weight: bolder;margin-right: 5px">{{ hotShowInfo.price }}</span>元起
    </div>
  </div>
</template>

<script>
  export default {
//    props: ['posterUrl', 'title', 'price'],
    props: ['hotShowInfo'],
    data () {
      return {
//        hotShowInfo: {
//          posterUrl: 'https://picsum.photos/400/600/?random',
//          title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》爆笑舞台剧',
//          price: 101
//        }
      }
    },
    methods: {
      toShowDetail: function () {
        this.$router.push({name: 'Detail', params: {id: '0001'}})
      }
    }
  }
</script>

<style>
  .hot-show-display{
    margin: 30px;
    display: inline-block;
    cursor: pointer;
    width: 180px;
  }

  .hot-show-display img{
    width: 100%;
    height: 220px;
    border-radius: 10px;
  }

  .hot-show-display-title{
    width: 100%;
    text-align: left;
    margin-top: 10px;
    margin-bottom: 5px;
    line-height: 22px;
    font-size: 15px;
    color: #494949;
    font-weight: 500;
    word-break:break-all;
    display:-webkit-box;
    -webkit-line-clamp:2;
    -webkit-box-orient:vertical;
    overflow:hidden;
  }

  .hot-show-display-price{
    color: #EA2000;
    font-size: 12px;
  }
</style>
