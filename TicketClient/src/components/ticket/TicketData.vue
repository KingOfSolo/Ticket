<template>
  <div class="ticket-data">
    <h3>总场馆数：<span style="color: #EA2000">{{venueNumber}}</span></h3>
    <h3>总演出数：<span style="color: #EA2000">{{showNumber}}</span></h3>
    <h3>演出类型分布：</h3>
    <div id="ticket-type-container" style="height: 350px;"></div>
    <h3>总用户数：<span style="color: #EA2000">{{userNumber}}</span></h3>
    <h3>总收入：<span style="color: #EA2000">{{incomeNumber}}元</span></h3>
    <div id="income-type-container" style="height: 350px;"></div>
  </div>
</template>

<script>
  import echarts from 'echarts'
  import {pieChart} from '../../charts/PieChart'
  export default{
    data () {
      return {
        name: ['全部', '演唱会', '话剧歌剧', '体育赛事', '音乐会', '儿童亲子', '舞蹈芭蕾', '展览休闲', '曲艺杂谈'],
        state: ['全部', '待支付', '等待配票', '待收票', '交易取消', '退订'],
        venueNumber: 0,
        showNumber: 0,
        userNumber: 0,
        incomeNumber: 0
      }
    },
    methods:{
      ticketDraw(id,self,name,data,title){
        let chart = echarts.init(document.getElementById(id))
        pieChart(chart, title, name, data)
      },
      venueNum(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/venueNumber',
        }).then(function (res) {
          self.venueNumber = res.data
        }).catch(function (err) {
          console.log(err)
        })
      },
      showNum(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/showNumber',
        }).then(function (res) {
          self.showNumber = res.data
        }).catch(function (err) {
          console.log(err)
        })

        this.$http({
          method: 'post',
          url: '/Manage/showType',
        }).then(function (res) {
          console.log(res.data)
          let name = []
          let data = []
          for(let i = 0; i < res.data.length; i++){
            if (res.data[i] != 0){
              name.push(self.name[i])
              data.push(res.data[i])
            }
          }
          self.ticketDraw('ticket-type-container',self, name,data,'演出类型分布')
        }).catch(function (err) {
          console.log(err)
        })
      },
      userNum(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/userNumber',
        }).then(function (res) {
          self.userNumber = res.data
        }).catch(function (err) {
          console.log(err)
        })
      },
      incomeNum(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Manage/income',
        }).then(function (res) {
          self.incomeNumber = res.data
        }).catch(function (err) {
          console.log(err)
        })

        this.$http({
          method: 'post',
          url: '/Manage/incomeType',
        }).then(function (res) {
          console.log(res.data)
          let name = []
          let data = []
          for(let i = 0; i < res.data.length; i++){
            if (res.data[i] != 0){
              name.push(self.name[i])
              data.push(res.data[i])
            }
          }
          self.ticketDraw('income-type-container',self, name,data,'演出类型分布')
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    created(){
      this.venueNum()
      this.showNum()
      this.userNum()
      this.incomeNum()
    }
  }
</script>
