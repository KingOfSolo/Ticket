<template>
  <div class="opera">
    <div class="opera-head">
      <div class="opera-head-title">话剧歌剧</div>
      <div class="opera-head-more" @click="toChoosePage">查看更多></div>
    </div>
    <div class="opera-container">
      <big-show-display :big-show-info="operaBigShow"></big-show-display>
      <div style="display: inline-block; text-align: left;width: 940px;vertical-align: top;margin-left: 5px">
        <small-show-display v-for="(item,index) in operaSmallShow" :key="index" :small-show-display="item"></small-show-display>
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
        operaBigShow: {},
        operaSmallShow: []
      }
    },
    methods: {
      toChoosePage: function () {
        this.$router.push({name: 'Choose',params: {type: 2}})
      }
    },
    mounted (){
      var self = this
      this.$http({
        method: 'post',
        dataType: 'JSONP',
        url: '/Show/type/2'
      }).then(function (res) {
        console.log(res)
        self.operaBigShow = res.data[0]
        self.operaSmallShow = res.data.slice(1,7)
      })
    }
  }
</script>

<style>
  .opera{
    margin-top: 30px;
    margin-bottom: 50px;
  }

  .opera-head{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
  }

  .opera-head-title{
    font-size: x-large;
    font-weight: bold;
  }

  .opera-head-more{
    cursor: pointer;
  }

  .opera-head-more:hover{
    color: #10cf7d;
  }

  .opera-container{
    text-align: left;
  }
</style>
