<template>
  <div>
    <home-header></home-header>
    <router-view></router-view>
  </div>
</template>

<script>
  import HomeHeader from '../../components/home/Header.vue'
  export default{
    components:{
      HomeHeader
    },
    data () {
      return {

      }
    },
    mounted () {
      this.$router.push({name: 'Home'})
    }
  }
</script>

<style>

</style>
