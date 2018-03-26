<template>
  <div id="order-confirm">
    <div class="address-container">
      <div class="address-container-form">
        <p>地址信息</p>
        <el-form label-width="80px" :label-position="labelPosition">
          <el-form-item label="取票人：">
            <el-input size="medium" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="手机：">
            <el-input size="medium" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="地址：">
            <el-input size="medium" style="width: 250px"></el-input>
          </el-form-item>
        </el-form>
        <div class="dottedLine"></div>
        <p>取票说明</p>
        <div>本次取票为邮寄方式，请保持手机通信联系</div>
        <div class="dottedLine"></div>
        <p>优惠信息</p>
        <div>会员等级<span class="level">Lv.2</span>，折扣为<span class="level">8.5</span>折</div>
      </div>
      <el-button type="primary" class="payment-button">去支付</el-button>
    </div>
    <div class="info-container">
      <div class="show-info">
        <img :src="orderInfo.poster"/>
        <div>{{orderInfo.name}}</div>
      </div>
      <div class="dottedLine2"></div>
      <div class="labelSize"><span>票面:</span><span class="labelColor">{{orderInfo.price}}</span></div>
      <div class="labelSize"><span>地点:</span><span class="labelColor">{{orderInfo.address}}</span></div>
      <div class="labelSize"><span>时间:</span><span class="labelColor">{{orderInfo.date}}</span></div>
      <div class="labelSize"><span>数量:</span><span class="labelColor">{{orderInfo.num}}张</span></div>
      <div class="dottedLine2"></div>
      <div class="labelSize flexBetween"><span>代收票款：</span><span class="labelColor">{{orderInfo.total}}元</span></div>
      <div class="labelSize flexBetween"><span>优惠/抵用：</span><span class="labelColor">{{orderInfo.discount}}元</span></div>
      <div class="labelSize flexBetween"><span>订单总额：</span><span class="labelColor">{{orderInfo.total - orderInfo.discount}}元</span></div>
      <div class="dottedLine2"></div>
      <div class="labelSize flexBetween"><span>待付款：</span><span class="level">{{orderInfo.total - orderInfo.discount}}元</span></div>
    </div>
  </div>
</template>

<script>
  import ElForm from "../../../node_modules/element-ui/packages/form/src/form";
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default{
    components: {
      ElButton,
      ElInput,
      ElFormItem,
      ElForm},
    data () {
      return {
        labelPosition: 'left',
        orderInfo: {
          poster: 'https://picsum.photos/200/300',
          name: '【上海站】开心麻花爆笑舞台剧《莎士比亚别生气》 ',
          price: 180,
          num: 1,
          address: '上戏实验剧院--上海市华山路630号',
          date: '2018-03-28 19:30',
          discount: '10',
          total: 180
        }
      }
    }
  }
</script>

<style>
  #order-confirm{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    vertical-align: top;
  }

  .address-container{
    margin-top: 40px;
    display: inline-block;
    width: 560px;
    margin-right: 30px;
    text-align: left;
  }

  .address-container-form{
    padding: 20px 40px;
    border-radius: 5px;
    box-shadow: 0 0 12px 0 #f0f0f0;
  }

  .info-container{
    padding: 20px;
    margin-top: 40px;
    display: inline-block;
    width: 300px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    border-radius: 5px;
    border-top: 10px solid #10cf7d;
    text-align: left;
  }

  .dottedLine{
    border-top: 2px dashed #eeeeee;
    margin: 10px -40px 10px -40px;
  }

  .payment-button{
    margin-top: 20px;
    width: 560px;
  }

  .level{
    font-size: 20px;
    font-weight: bold;
    color: #EA2000;
  }

  .show-info{
    display: inline-block;
  }

  .show-info{
    display: flex;
    align-items: flex-start;
  }

  .show-info img{
    width: 100px;
    height: 130px;
    border-radius: 5px;
  }

  .show-info div{
    display: inline-block;
    width: 180px;
    font-size: 14px;
    text-align: left;
    margin-left: 10px;
  }

  .dottedLine2{
    border-top: 2px dashed #eeeeee;
    margin: 15px 0px 15px 0px;
  }

  .labelSize{
    font-size:13px;
    line-height: 20px;
  }

  .labelColor{
    color: #999999;
  }

  .flexBetween{
    display: flex;
    justify-content: space-between;
  }

</style>
