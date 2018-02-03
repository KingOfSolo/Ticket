<template>
  <div class="choose-show-display">
    <div class="choose-show-content">
      <img :src="chooseShowInfo.posterUrl">
      <div class="choose-show-detail">
        <div class="choose-show-title">{{chooseShowInfo.title}}</div>
        <div class="choose-show-intro">{{chooseShowInfo.intro}}</div>
        <div class="choose-show-tag">
          <el-tag type="danger" size="medium">售票中</el-tag>
        </div>
        <div class="choose-show-time">{{chooseShowInfo.time}}</div>
        <div style="display: flex;flex-direction: row;justify-content: space-between;align-items: flex-end">
          <span class="choose-show-place">{{chooseShowInfo.place}}</span>
          <span class="choose-show-price">
            <span style="font-size: large;font-weight: bolder;margin-right: 5px">{{chooseShowInfo.price}}</span>元起
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    props: ['chooseShowInfo'],
    data () {
      return{
//        chooseShowInfo: {
//          posterUrl:'https://picsum.photos/400/601/?random',
//          title:'【上海站】上海杂技团《欢乐马戏》',
//          intro: '美是魅力，丑是乐，欢乐马戏全都有',
//          time: '2018.3.31 19:30',
//          place: '上海梅赛德斯奔驰文化中心',
//          price: 322
//        }
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
    height: 250px;
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
