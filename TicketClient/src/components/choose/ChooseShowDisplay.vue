<template>
  <div class="choose-show-display" @click="toDetailPage">
    <div class="choose-show-content">
      <img :src="chooseShowInfo.poster">
      <div class="choose-show-detail">
        <div class="choose-show-title">{{chooseShowInfo.name}}</div>
        <div class="choose-show-intro">{{chooseShowInfo.introduce}}</div>
        <div class="choose-show-tag">
          <el-tag type="danger" size="medium">售票中</el-tag>
        </div>
        <div class="choose-show-time">{{chooseShowInfo.start_time}}</div>
        <div style="display: flex;flex-direction: row;justify-content: space-between;align-items: flex-end">
          <span class="choose-show-place">{{chooseShowInfo.address}}</span>
          <span class="choose-show-price">
            <span style="font-size: large;font-weight: bolder;margin-right: 5px">{{price}}</span>元起
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    props: ['chooseShowInfo'],
    computed: {
      price: function () {
        var prices = []
        for (var i = 0; i < this.chooseShowInfo.showPrices.length; i++){
          prices[i] = this.chooseShowInfo.showPrices[i].price
        }
        var compare = function (x, y) {
          if (x < y) {
            return -1;
          } else if (x > y) {
            return 1;
          } else {
            return 0;
          }
        }
        prices.sort(compare)
        return prices[0]
      }
    },
    data () {
      return{
      }
    },
    methods: {
      toDetailPage: function () {
        this.$router.push({name: 'Detail',params: {id: this.chooseShowInfo.show_id}})
      }
    }
  }
</script>

<style>
  .choose-show-display{
    margin: 25px;
    position: relative;
    display: inline-block;
    width: 45%;
    height: 260px;
    cursor: pointer;
  }

  .choose-show-display img{
    z-index: 10;
    border-radius: 10px;
    width: 160px;
    height: 220px;
    margin: -30px 0 0 -30px;
    box-shadow: 0 0 12px 0 #f0f0f0;
  }

  .choose-show-content{
    position: absolute;
    left: 30px;
    top: 30px;
    right: 0;
    bottom: 0;
    box-shadow:0 0 5px #f0f0f0;
    transition: all 0.5s;
    border-radius: 10px;
  }

  .choose-show-content:hover{
    margin-top: -15px;
    margin-bottom: 15px;
    box-shadow:0 0 12px #f0f0f0;
  }

  .choose-show-detail{
    position: absolute;
    left: 150px;
    top: 15px;
    bottom: 15px;
    right: 15px;
  }

  .choose-show-title{
    color: #494949;
    margin-bottom: 30px;
  }

  .choose-show-intro{
    color: #aaaaaa;
    font-size: 12px;
    margin-bottom: 25px;
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }

  .choose-show-tag{
    margin-bottom: 20px;
  }

  .choose-show-time, .choose-show-place{
    font-size: 12px;
    color: #494949;
    line-height: 20px;
  }

  .choose-show-price{
    color: #EA2000;
    font-size: 12px;
  }
</style>
