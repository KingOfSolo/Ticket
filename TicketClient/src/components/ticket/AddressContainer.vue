<template>
  <div>
    <div>{{originalAddress}}</div>
    <div style="color:#10cf7d">修改为</div>
    <div>{{modifyAddress}}</div>
  </div>
</template>

<script>
  export default{
    props: ['venueId'],
    data(){
      return{
        originalAddress: '',
        modifyAddress: ''
      }
    },
    created(){
      var self = this

      this.$http({
        method: 'post',
        url: '/Venue/id/'+this.venueId,
      }).then(function (res) {
        self.originalAddress = res.data.address
      }).catch(function (err) {
        console.log(err)
      })

      this.$http({
        method: 'post',
        url: '/Venue/modifyInfo/'+this.venueId,
      }).then(function (res) {
        self.modifyAddress = res.data.address
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style>

</style>
