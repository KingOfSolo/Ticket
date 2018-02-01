<template>
  <el-carousel :interval="4000" type="card" height="350px">
    <el-carousel-item v-for="item in carouselImageList" :key="item">
      <img :src="item"/>
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  data () {
    return {
      carouselImageList: ['https://picsum.photos/750/400/?random', 'https://picsum.photos/750/401/?random', 'https://picsum.photos/750/402/?random',
        'https://picsum.photos/750/399/?random', 'https://picsum.photos/750/398/?random', 'https://picsum.photos/750/397/?random']
    }
  }
}
</script>

<style>

</style>
