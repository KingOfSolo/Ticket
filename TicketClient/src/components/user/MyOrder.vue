<template>
  <div id="my-order">
    <div class="order-tab">
      <span class="order-tab-item" v-for="(item, index) in tabs" @click="tabClick(index)" :class="{tabActive: index == tabActiveNum}">{{item}}</span>
    </div>
    <order-display v-for="(item,index) in orderInfoList" :order-info="item" :key="index"></order-display>
  </div>
</template>

<script>
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import OrderDisplay from "./OrderDisplay.vue"
  export default{
    components: {ElInput,OrderDisplay},
    data () {
      return{
        labelPosition: 'left',
        tabs: ['全部订单', '等待支付', '等待配票', '配票中', '等待收票', '已结束'],
        tabActiveNum: 0,
        orderInfoList: [
          {
            poster: 'https://picsum.photos/200/303',
            name: '【南京站】周杰伦地表最强演唱会',
            number: '165646987613132',
            address: '南京奥体中心',
            price: 180,
            num: 2,
            start_time: '2018-3-29 19:30',
            date: '2018-3-29 22:59',
            total: 320,
            state: 0,
            seat_name: '看台一'
          },
          {
            poster: 'https://picsum.photos/200/305',
            name: '【南京站】周杰伦地表最强演唱会',
            number: '165646987613132',
            address: '南京奥体中心',
            price: 180,
            num: 2,
            start_time: '2018-3-29 19:30',
            date: '2018-3-29 22:59',
            total: 320,
            state: 0,
            seat_name: '看台一'
          },
          {
            poster: 'https://picsum.photos/200/304',
            name: '【南京站】周杰伦地表最强演唱会',
            number: '165646987613132',
            address: '南京奥体中心',
            price: 180,
            num: 2,
            start_time: '2018-3-29 19:30',
            date: '2018-3-29 22:59',
            total: 320,
            state: 0,
            seat_name: '看台一'
          }
        ]
      }
    },
    methods: {
      tabClick(index){
        this.tabActiveNum = index
      }
    }
  }
</script>

<style>
  #my-order{
    padding: 20px 40px;
    text-align: left;
  }

  .order-tab{
    margin-bottom: 40px;
  }

  .order-tab-item{
    font-size: large;
    cursor: pointer;
    padding-bottom: 5px;
    margin-left: 50px;
  }

  .order-tab-item:hover{
    color: #10cf7d;
    border-bottom: 2px solid #10cf7d;
  }

  .tabActive{
    color: #10cf7d;
    border-bottom: 2px solid #10cf7d;
  }
</style>
