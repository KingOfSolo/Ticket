<template>
  <div id="my-order">
    <div class="order-tab">
      <span class="order-tab-item" v-for="(item, index) in tabs" @click="tabClick(index)" :class="{tabActive: index == tabActiveNum}">{{item}}</span>
    </div>
    <order-display v-for="(item,index) in orderInfoList" :order-info="item" :key="item.id"
                   v-if="(currentPage - 1) * pageSize <= index && index < currentPage * pageSize"></order-display>
    <div style="text-align: right;margin-top: 80px">
      <el-pagination
        background
        layout="prev, pager, next, jumper"
        :page-size="pageSize"
        :total="totalSize"
        :current-page.sync="currentPage"
        @current-change="handleCurrentChange">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import OrderDisplay from "./OrderDisplay.vue"
  export default{
    components: {ElInput,OrderDisplay},
    computed: {
      totalSize: function () {
        return this.orderInfoList.length
      },
    },
    data () {
      return{
        labelPosition: 'left',
        tabs: ['全部订单', '等待支付', '等待配票', '等待收票', '交易取消','退订'],
        tabActiveNum: 0,
        orderInfoList: [],
        userId: '',
        pageSize: 5,
        currentPage: 1
      }
    },
    methods: {
      tabClick(index){
        this.tabActiveNum = index
        var self = this
        var url = ''
        console.log(this.tabActiveNum)
        if(index != 0){
          url = '/Order/state/'+this.userId+'/'+this.tabActiveNum
        }else{
          url = '/Order/userId/'+this.userId
        }
        this.$http({
          method: 'post',
          url: url
        }).then(function (res) {
          console.log(res.data)
          self.orderInfoList = res.data
        }).catch(function (err) {
          console.log(err)
        })
      },
      handleCurrentChange: function (val) {
        this.currentPage = val
      }
    },
    created(){
      this.userId = JSON.parse(window.localStorage.getItem("user")).id
    },
    mounted(){
      let self = this
      this.$http({
        method: 'post',
        url: '/Order/userId/'+this.userId,
      }).then(function (res) {
        console.log(res.data)
        self.orderInfoList = res.data
      }).catch(function (err) {
        console.log(err)
      })
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
