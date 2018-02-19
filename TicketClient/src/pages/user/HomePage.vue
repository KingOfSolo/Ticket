<template>
  <div id="home">

    <!--轮播图-->
    <carousel></carousel>

    <!--热门推荐-->
    <hot-show></hot-show>

    <!--演唱会-->
    <concert></concert>

    <!--体育赛事-->
    <sport></sport>

    <!--话剧歌剧-->
    <opera></opera>
  </div>
</template>

<script>
  import HomeHeader from '../../components/home/Header.vue'
  import Carousel from '../../components/home/Carousel.vue'
  import HotShow from '../../components/home/HotShow.vue'
  import Concert from '../../components/home/Concert.vue'
  import Sport from '../../components/home/Sport.vue'
  import Opera from '../../components/home/Opera.vue'
  export default {
    components: {
      HomeHeader,
      Carousel,
      HotShow,
      Concert,
      Sport,
      Opera
    },
    data () {
      return {
      }
    }
  }
</script>

<style>
  #home{
    padding: 30px 10% 0 10%;
  }
</style>
