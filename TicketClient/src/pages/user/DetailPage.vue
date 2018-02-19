<template>
  <div id="detail">
    <detail-display></detail-display>
  </div>
</template>

<script>
  import DetailDisplay from '../../components/detail/DetailDisplay.vue'
  import HomeHeader from '../../components/home/Header.vue'
  export default{
    components: {
      HomeHeader,
      DetailDisplay
    },
    data () {
      return {
      }
    }
  }
</script>

<style>
  #detail{
    padding: 60px 10% 0 10%;
    text-align: center;
  }
</style>
