<template>
  <div class="total-price">
    {{totalPrice}}
  </div>
</template>

<script>
  export default{
    props: ['showId'],
    data(){
      return{
        totalPrice: 0
      }
    },
    created(){
      var self = this
      this.$http({
        method: 'post',
        url: '/Show/totalPrice/'+this.showId,
      }).then(function (res) {
        console.log(res.data)
        self.totalPrice = res.data
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>
