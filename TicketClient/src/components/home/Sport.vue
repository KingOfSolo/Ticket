<template>
  <div class="sport">
    <div class="sport-head">
      <div class="sport-head-title">体育赛事</div>
      <div class="sport-head-more" @click="toChoosePage">查看更多></div>
    </div>
    <div class="sport-container">
      <big-show-display :big-show-info="sportBigShow"></big-show-display>
      <div style="display: inline-block; text-align: left;width: 940px;vertical-align: top;margin-left: 5px">
        <small-show-display v-for="(item, index) in sportSmallShow" :key="index" :small-show-display="item"></small-show-display>
      </div>

    </div>
  </div>
</template>

<script>
  import BigShowDisplay from './BigShowDisplay.vue'
  import SmallShowDisplay from './SmallShowDisplay.vue'
  export default{
    components: {
      BigShowDisplay,
      SmallShowDisplay
    },
    data () {
      return {
        sportBigShow: {},
        sportSmallShow: []
      }
    },
    methods:{
      toChoosePage: function () {
        this.$router.push({name: 'Choose',params: {type: 3}})
      }
    },
    mounted (){
      var self = this
      this.$http({
        method: 'post',
        dataType: 'JSONP',
        url: '/Show/type/3'
      }).then(function (res) {
        console.log(res)
        self.sportBigShow = res.data[0]
        self.sportSmallShow = res.data.slice(1,7)
      })
    }
  }
</script>

<style>
  .sport{
    margin-top: 70px;
  }

  .sport-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .sport-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .sport-head-more{
    cursor: pointer;
  }

  .sport-head-more:hover{
    color: #10cf7d;
  }

  .sport-container{
    text-align: left;
  }
</style>
