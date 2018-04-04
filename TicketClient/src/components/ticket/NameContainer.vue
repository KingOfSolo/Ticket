<template>
  <div>
    <div>{{originalName}}</div>
    <div style="color:#10cf7d">修改为</div>
    <div>{{modifyName}}</div>
  </div>
</template>

<script>
  export default{
    props: ['venueId'],
    data(){
      return{
        originalName: '',
        modifyName: ''
      }
    },
    created(){
      var self = this

      this.$http({
        method: 'post',
        url: '/Venue/id/'+this.venueId,
      }).then(function (res) {
        self.originalName = res.data.name
      }).catch(function (err) {
        console.log(err)
      })

      this.$http({
        method: 'post',
        url: '/Venue/modifyInfo/'+this.venueId,
      }).then(function (res) {
        self.modifyName = res.data.name
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style>

</style>
