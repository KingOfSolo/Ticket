<template>
  <div class="big-show-display" v-on:mouseenter="bigShowEnter" v-on:mouseleave="bigShowLeave">
    <img :src="bigShowInfo.poster"/>
    <div class="big-show-display-top-mask mask" :class="{maskOpacity: bigShowIsHover}">
      <div>{{bigShowInfo.name}}</div>
    </div>
    <div class="big-show-display-bottom-mask mask" :class="{maskOpacity: bigShowIsHover}">
      <span style="font-size: large;font-weight: bolder;margin-right: 5px">{{price}}</span>元起
    </div>
  </div>
</template>

<script>
  export default{
    props: ['bigShowInfo'],
    computed:{
      price : function () {
        var prices = []
        for (var i = 0; i < this.bigShowInfo.showPrices.length; i++){
          prices[i] = this.bigShowInfo.showPrices[i].price
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
        bigShowIsHover: false
      }
    },
    methods: {
     bigShowEnter: function () {
       this.bigShowIsHover = true
     },
     bigShowLeave: function () {
       this.bigShowIsHover = false
     }
    }
  }
</script>

<style>
  .big-show-display{
    position: relative;
    margin-top: 30px;
    display: inline-block;
    width: 250px;
    height: 370px;
    cursor: pointer;
    overflow: hidden;
    border-radius: 10px;
  }

  .big-show-display img{
    width: 100%;
    height: 100%;
    border-radius: 10px;
    transition: transform 1s;
  }

  .big-show-display img:hover{
    transform:scale(1.2);
    -ms-transform:scale(1.2);
    -webkit-transform:scale(1.2);
    -o-transform:scale(1.2);
    -moz-transform:scale(1.2);
  }

  .mask{
    padding: 10px;
    position: absolute;
    left: 0;
    right: 0;
    line-height: 20px;
    opacity: 0;
    -webkit-transition: opacity 0.2s;
    -moz-transition: opacity 0.2s;
    transition: opacity 0.2s;
  }

  .big-show-display-top-mask{
    border-radius: 10px 10px 0 0;
    top: 0;
    background: linear-gradient(to top, transparent 0%, rgba(0,0,0,0.4) 100%);;
    color: #ffffff;
  }

  .big-show-display-bottom-mask{
    border-radius: 0 0 10px 10px;
    bottom: 0;
    background: linear-gradient(to bottom, transparent 0%, rgba(0,0,0,0.4) 100%);
    color: #EA2000;
    font-size: 12px;
  }

  .maskOpacity{
    opacity: 1;
  }
</style>
