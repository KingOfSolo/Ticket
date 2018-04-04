<template>
  <el-carousel :interval="4000" type="card" height="350px">
    <el-carousel-item v-for="(item,index) in carouselImageList" :key="index">
      <img style="width: 600px;height: 330px;" :src="item.poster" @click="toDetailPage(index)"/>
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
    },
    methods:{
      toDetailPage(index){
        this.$router.push({name: 'Detail', params: {id: this.carouselImageList[index].show_id}})
      }
    },
    mounted(){
      var self = this
      this.$http({
        method: 'get',
        url: '/Show/carousel'
      }).then(function (res) {
        console.log(res)
        self.carouselImageList = res.data
      })
    }
  }
</script>

<style>

</style>
