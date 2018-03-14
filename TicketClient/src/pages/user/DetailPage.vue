<template>
  <div id="detail">
    <detail-display :show-info="showInfo"></detail-display>
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
        showInfo: {}
      }
    },
    mounted (){
      var self = this
      this.$http({
        method: 'post',
        dataType: 'JSONP',
        url: '/Show/id/'+this.$route.params.id
      }).then(function (res) {
        console.log(res)
        self.showInfo = res.data
      })
    }
  }
</script>

<style>
  #detail{
    padding: 60px 10% 0 10%;
    text-align: center;
  }
</style>
