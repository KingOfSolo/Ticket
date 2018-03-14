<template>
  <div class="concert">
    <div class="concert-head">
      <div class="concert-head-title">演唱会</div>
      <div class="concert-head-more" @click="toChoosePage">查看更多></div>
    </div>
    <div class="concert-container">
      <big-show-display :big-show-info="concertBigShow"></big-show-display>
      <div style="display: inline-block; text-align: left;width: 940px;vertical-align: top;margin-left: 5px">
        <small-show-display v-for="(item,index) in concertSmallShow" :key="index" :small-show-display="item"></small-show-display>
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
        concertBigShow: {},
        concertSmallShow: []
      }
    },
    methods: {
      toChoosePage: function () {
        this.$router.push({name: 'Choose',params: {type: 1}})
      }
    },
    mounted () {
      var self = this
      this.$http({
        method: 'post',
        dataType: 'JSONP',
        url: '/Show/type/1'
      }).then(function (res) {
        console.log(res)
        self.concertBigShow = res.data[0]
        self.concertSmallShow = res.data.slice(1,7)
      })
    }
  }
</script>

<style>
  .concert{
    margin-top: 30px;
  }

  .concert-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .concert-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .concert-head-more{
    cursor: pointer;
  }

  .concert-head-more:hover{
    color: #10cf7d;
  }

  .concert-container{
    text-align: left;
  }
</style>
