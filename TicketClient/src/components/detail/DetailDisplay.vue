<template>
  <div class="detail-display">
    <div class="detail-display-content">
      <img :src="showInfo.poster"/>
      <div class="detail-display-info">
        <div class="detail-display-title">{{showInfo.name}}</div>
        <div class="detail-display-time"><span style="margin-right: 10px">{{showInfo.start_time}}</span><span>{{showInfo.address}}</span></div>
        <div class="detail-display-price">
          <span style="margin-right: 20px">选择票价</span>
          <div class="detail-display-price-container" v-for="(item, index) in priceList" @click="priceClick(index)" :class="{priceActive: index == priceActiveNum}">{{item.price}}票面</div>
        </div>
        <div class="detail-display-number">
          <span style="margin-right: 20px">选择数量</span>
          <el-input-number v-model="num" @change="handleChange" :min="1" :max="max" label="描述文字"></el-input-number>
          <!--<span class="remain-number">剩余{{this.remainNum}}张</span>-->
        </div>
        <div class="detail-display-total">
          <span style="margin-right: 25px">合计价格</span>
          <span style="font-size: xx-large;color: #EA2000;">{{totalPrice}}</span>
          <span style="font-size: 14px;color: #EA2000">元</span>
        </div>
        <div class="detail-display-button">
          <div @click="buy">立即购票</div>
          <div>选座购票</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    props: ['showInfo'],
    computed: {
      priceList: function () {
//        var compare = function (property) {
//          return function(obj1,obj2){
//            var value1 = obj1[property];
//            var value2 = obj2[property];
//            return value1 - value2;
//          }
//        }
        return this.showInfo.showPrices.sort(this.compare("price"))
      }
    },
    data () {
      return {
        detailDisplayInfo: {
          poster: 'https://picsum.photos/400/701/?random',
          title: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》',
          time: '2018.2.10 19:30',
          place: '上海梅赛德斯奔驰文化中心',
          priceList: [280, 480, 680, 880, 980, 1280]
        },
        num: 1,
        max: 10,
        totalPrice: 0,
        priceActiveNum: 0,
        remainNum: 0
      }
    },
    methods: {
      handleChange: function (value) {
        this.num = value
        this.totalPrice = this.showInfo.showPrices[this.priceActiveNum].price * value
      },
      priceClick: function (index) {
        this.priceActiveNum = index
        this.totalPrice = this.showInfo.showPrices[index].price * this.num
        this.remainNum = this.showInfo.showPrices[index].remain_num
      },
      buy(){
        let orderInfo = this.showInfo
        orderInfo.num = this.num
        orderInfo.total = this.totalPrice
        orderInfo.seat = this.showInfo.showPrices[this.priceActiveNum].id
        orderInfo.price = this.showInfo.showPrices[this.priceActiveNum].price
        orderInfo.discount = Math.floor(this.totalPrice * (1 - this.$store.getters.discount))
        console.log(orderInfo)
//        this.$store.commit('ORDER_INFO',orderInfo)
        this.$store.dispatch('ORDER_INFO',orderInfo)
        this.$router.push({name: 'OrderConfirm'})
      },
      compare(property){
        return function(obj1,obj2){
          var value1 = obj1[property];
          var value2 = obj2[property];
          return value1 - value2;
        }
      }
    },
    mounted (){
      this.totalPrice = this.priceList[0].price
      this.remainNum = this.priceList[0].remain_num
    }
  }
</script>

<style>
  .detail-display{
    display: inline-block;
    position: relative;
    width: 1000px;
    text-align: left;
  }

  .detail-display-content{
    position: absolute;
    left: 30px;
    top: 30px;
    right: 0;
    box-shadow:0 0 12px #f0f0f0;
    border-radius: 10px;
  }

  .detail-display img{
    position: absolute;
    border-radius: 20px;
    margin: -40px 0 0 -40px;
    width: 260px;
    height: 340px;
    box-shadow: 0 0 12px 0 #f0f0f0;
  }

  .detail-display-info{
    display: inline-block;
    margin-left: 240px;
    padding: 20px;
    /*position: absolute;*/
    /*left: 250px;*/
    /*top: 20px;*/
    /*right: 20px;*/
    /*bottom:0px;*/
  }

  .detail-display-title{
    font-size: x-large;
    margin-bottom: 25px;
  }

  .detail-display-time{
    font-size: 14px;
    color: #777777;
    margin-bottom: 25px;
  }

  .detail-display-price, .detail-display-number{
    margin-bottom: 25px;
    font-size: 17px;
  }

  .detail-display-price-container{
    display: inline-block;
    padding: 5px 20px 5px 20px;
    border-radius: 20px;
    border: 2px solid #f2f2f2;
    cursor: pointer;
    margin: 0 10px 10px 0;
    font-size: medium;
  }

  .priceActive{
    border: 2px solid #EA2000;
    color: #EA2000;
  }

  .detail-display-button div{
    margin-top: 25px;
    margin-right: 20px;
    display: inline-block;
    padding: 8px 40px;
    background-color: #10cf7d;
    border-radius: 25px;
    color: white;
    font-size: 20px;
    cursor: pointer;
    box-shadow: 0 0 10px #10cf7d;
  }

  .detail-display-button div:hover{
    opacity: 0.8;
  }

  .remain-number{
    font-size: 14px;
    color: #EA2000;
    margin-left: 20px;
  }
</style>
