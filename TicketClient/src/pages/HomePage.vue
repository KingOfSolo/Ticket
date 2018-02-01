<template>
  <div id="home">
    <carousel></carousel>
    <hot-show></hot-show>
  </div>
</template>

<script>
  import Carousel from '../components/home/Carousel.vue'
  import HotShow from '../components/home/HotShow.vue'
  export default {
    components: {
      Carousel,
      HotShow
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
