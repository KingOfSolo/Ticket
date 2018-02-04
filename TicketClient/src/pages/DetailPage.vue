<template>
  <div id="detail">
    <detail-display></detail-display>
  </div>
</template>

<script>
  import DetailDisplay from '../components/detail/DetailDisplay.vue'
  export default{
    components: {
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
