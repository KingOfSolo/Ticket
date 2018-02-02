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
  </div>
</template>

<script>
  import Carousel from '../components/home/Carousel.vue'
  import HotShow from '../components/home/HotShow.vue'
  import Concert from '../components/home/Concert.vue'
  import Sport from '../components/home/Sport.vue'
  export default {
    components: {
      Carousel,
      HotShow,
      Concert,
      Sport
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
