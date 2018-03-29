<template>
  <div id="order-display">
    <div style="color: #EA2000;font-size: small">交易取消</div>
    <div class="order-info-number">
      <div>订单号：{{orderInfo.number}}</div>
      <div>{{orderInfo.date}}</div>
    </div>
    <div id="order-info-container">
      <div class="order-info">
        <img :src="orderInfo.poster"/>
        <div class="order-info-content">
          <div class="order-info-name">{{orderInfo.name}}</div>
          <div><span class="order-info-label">票面：</span><span class="order-info-detail">{{orderInfo.price}}</span></div>
          <div><span class="order-info-label">数量：</span><span class="order-info-detail">{{orderInfo.num}}张</span></div>
          <div><span class="order-info-label">时间：</span><span class="order-info-detail">{{orderInfo.start_time}}</span></div>
          <div><span class="order-info-label">场馆：</span><span class="order-info-detail">{{orderInfo.address}}</span></div>
          <div><span class="order-info-label">座位：</span><span class="order-info-detail">{{orderInfo.seat_name}}</span></div>
          <div><span class="order-info-label">订单金额：</span><span class="order-info-price">{{orderInfo.total}}元</span></div>
        </div>
      </div>
      <el-button v-show="orderInfo.state == 0" type="primary" style="align-self: center">去支付</el-button>
    </div>
  </div>
</template>

<script>
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default{
    components: {ElButton},
    props: ['orderInfo'],
    data (){
      return {
      }
    }
  }
</script>

<style>
  #order-display{
    margin-top: 20px;
  }

  .order-info{
    display: flex;
    align-items: flex-start;
  }

  .order-info img{
    width: 110px;
    height: 150px;
    border-radius: 10px;
  }

  .order-info-content{
    text-align: left;
    margin-left: 10px;
  }

  .order-info-name{
    margin-bottom: 10px;
    font-size: medium;
    color: #505050;
    font-weight: bold;
  }

  .order-info-label{
    color: #747576;
    font-size: small;
    line-height: 20px;
    margin-left: 5px;
  }

  .order-info-detail{
    font-size: small;
  }

  .order-info-price{
    font-size: medium;
    color: #EA2000;
    font-weight: bold;
  }

  .order-info-number{
    display: flex;
    justify-content: space-between;
    font-size: small;
    padding-bottom: 10px;
  }

  #order-info-container{
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    padding: 10px 0;
    border-top: 1px dotted #cccccc;
    border-bottom: 1px dotted #cccccc;
  }
</style>
