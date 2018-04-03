<template>
  <div class="pay-price">
    {{price}}
  </div>
</template>

<script>
  export default{
    props:['venueInfo'],
    data(){
      return{
        price: 0
      }
    },
    created(){
      var self = this
      this.$http({
        method: 'post',
        url: '/Manage/payment/'+this.venueInfo.venue_id,
      }).then(function (res) {
        console.log(res.data)
        self.price = res.data
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>
