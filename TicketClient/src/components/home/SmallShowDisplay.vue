<template>
  <div class="small-show-display">
    <img :src="smallShowDisplay.posterUrl"/>
    <div class="small-show-display-content">
      <div class="small-show-display-title">{{smallShowDisplay.title}}</div>
      <div class="small-show-display-time">{{smallShowDisplay.time}}</div>
      <div class="small-show-display-place">{{smallShowDisplay.place}}</div>
      <div class="small-show-display-price">
        <span style="font-size: large;font-weight: bolder;margin-right: 5px">{{smallShowDisplay.price}}</span>元起
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    props: ['smallShowDisplay'],
    data () {
      return {
        smallShowDisplay: {
          posterUrl: 'https://picsum.photos/200/300/?random',
          title: '【上海站】世界经典原版音乐剧《猫》CATS',
          time: '2018.03.08 19:30',
          place: '上海梅赛德斯奔驰文化中心',
          price: 391
        }
      }
    }
  }
</script>

<style>
  .small-show-display{
    cursor: pointer;
    margin-top: 30px;
    padding-left:20px;
    height: 170px;
    width: 31%;
    display: inline-block;
  }

  .small-show-display img{
    height: 100%;
    width: 46%;
    border-radius: 10px;
  }

  .small-show-display-content{
    display: inline-block;
    padding-left: 10px;
    width: 45%;
    vertical-align: top;
  }

  .small-show-display-title{
    line-height: 20px;
    word-break:break-all;
    display:-webkit-box;
    -webkit-line-clamp:2;
    -webkit-box-orient:vertical;
    overflow:hidden;
    font-size: 14px;
    margin-bottom: 30px;
    color: #494949;
  }

  .small-show-display-time, .small-show-display-place{
    line-height: 20px;
    overflow: hidden;
    text-overflow: ellipsis;
    -o-text-overflow: ellipsis;
    -webkit-text-overflow: ellipsis;
    -moz-text-overflow: ellipsis;
    white-space: nowrap;
    font-size: 14px;
    color: #777777;
  }

  .small-show-display-price{
    margin-top: 30px;
    color: #EA2000;
    font-size: 12px;
  }
</style>
