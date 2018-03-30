<template>
  <div id="order-confirm">
    <div class="address-container">
      <div class="address-container-form">
        <p>地址信息</p>
        <el-form label-width="80px" :label-position="labelPosition">
          <el-form-item label="取票人：" required>
            <el-input size="medium" style="width: 250px" v-model="addressData.name"></el-input>
          </el-form-item>
          <el-form-item label="手机：" required v-model="addressData.phone">
            <el-input size="medium" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="地址：" required>
            <el-input size="medium" style="width: 250px" v-model="addressData.address"></el-input>
          </el-form-item>
        </el-form>
        <div class="dottedLine"></div>
        <p>取票说明</p>
        <div>本次取票为邮寄方式，请保持手机通信联系</div>
        <div class="dottedLine"></div>
        <p>优惠信息</p>
        <div>会员等级<span class="level">Lv.{{user.level}}</span>，折扣为<span class="level">{{discount * 10}}</span>折</div>
      </div>
      <el-button type="primary" class="payment-button" @click="confirmOrder">小计：{{orderInfo.total - orderInfo.discount}}元 去支付</el-button>
    </div>
    <div class="info-container">
      <div class="show-info">
        <img :src="orderInfo.poster"/>
        <div>{{orderInfo.name}}</div>
      </div>
      <div class="dottedLine2"></div>
      <div class="labelSize"><span>票面:</span><span class="labelColor">{{orderInfo.price}}</span></div>
      <div class="labelSize"><span>地点:</span><span class="labelColor">{{orderInfo.address}}</span></div>
      <div class="labelSize"><span>时间:</span><span class="labelColor">{{orderInfo.start_time}}</span></div>
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
  import {mapGetters, mapState} from 'vuex'
  export default{
    components: {
      ElButton,
      ElInput,
      ElFormItem,
      ElForm},
    computed: {
      ...mapGetters({
//        orderInfo: 'order',
        user: 'user',
        discount: 'discount'
      }),
//      ...mapState({
//        orderInfo: state => state.order
//      })
    },
    created(){
//      console.log(JSON.parse(window.sessionStorage.getItem('order')))
    },
    mounted(){
        this.orderInfo = JSON.parse(window.sessionStorage.getItem('order'))
    },
    data () {
      return {
        labelPosition: 'left',
        addressData: {
          name: '',
          phone: '',
          address: ''
        },
        orderInfo: {
//          poster: 'https://picsum.photos/400/701/?random',
//          name: '【上海站】开心麻花爆笑舞台剧《乌龙山伯爵》',
//          start_time: '2018.2.10 19:30',
//          address: '上海梅赛德斯奔驰文化中心',
//          price: 280,
//          num: 2,
//          total: 560,
//          discount: 20
        }
      }
    },
    methods: {
      confirmOrder() {
        var self = this
        console.log(this.orderInfo)
        let order = {
          price: this.orderInfo.price,
          num: this.orderInfo.num,
          total: this.orderInfo.total,
          buyer: this.user.id,
          show: this.orderInfo.show_id,
          seat: this.orderInfo.seat,
          buyer_name: this.addressData.name,
          phone: this.addressData.phone,
          address: this.addressData.address,
          discount: this.orderInfo.discount
        }
//        self.$router.push({name: 'OrderPay', params: {number: "11589746132132"}})
        this.$http({
          method: 'post',
          url: '/Order/confirm',
          data: order
        }).then(function (res) {
          console.log(res.data)
          self.orderInfo.number = res.data.number
          self.orderInfo.date = res.data.date
          self.$store.dispatch('ORDER_INFO',self.orderInfo)
          self.$router.push({name: 'OrderPay', params: {number: res.data.number}})
        }).catch(function (err) {
          console.log(err)
        })
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
