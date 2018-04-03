<template>
  <div id="venue-data">
    <h3>累计收益：<span style="color: #EA2000">{{total}}元</span></h3>
    <h3>收益分布：</h3>
    <div id="venue-type-container" style="height: 350px;"></div>
    <h3>演出场次：<span style="color: #EA2000">{{planNumber}}场</span></h3>
    <h3>演出类型分布：</h3>
    <div id="venue-plan-container" style="height: 350px;"></div>
    <h3>总订单数：<span style="color: #EA2000">{{number}}单</span></h3>
    <h3>订单状态分布：</h3>
    <div id="venue-state-container" style="height: 350px;"></div>
  </div>
</template>

<script>
  import echarts from 'echarts'
  import {pieChart} from '../../charts/PieChart'
  export default{
    props:['venueInfo'],
    data () {
      return{
        total: 0,
        number: 0,
        planNumber: 0,
        name: ['全部', '演唱会', '话剧歌剧', '体育赛事', '音乐会', '儿童亲子', '舞蹈芭蕾', '展览休闲', '曲艺杂谈'],
        state: ['全部','待支付','等待配票','待收票','交易取消','退订']
      }
    },
    methods:{
      venueDraw(id,self,name,data,title){
        let chart = echarts.init(document.getElementById(id))
        pieChart(chart, title, name, data)
      },
      income(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Venue/income/'+this.venueInfo.venue_id,
        }).then(function (res) {
          self.total = res.data
        }).catch(function (err) {
          console.log(err)
        })

        this.$http({
          method: 'post',
          url: '/Venue/type/'+this.venueInfo.venue_id,
        }).then(function (res) {
          let name = []
          let data = []
          for(let i = 0; i < res.data.length; i++){
            if (res.data[i] != 0){
              name.push(self.name[i])
              data.push(res.data[i])
            }
          }
          self.venueDraw('venue-type-container',self, name,data,'收益分布')
        }).catch(function (err) {
          console.log(err)
        })
      },
      order(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Venue/orderNumber/'+this.venueInfo.venue_id,
        }).then(function (res) {
          self.number = res.data
        }).catch(function (err) {
          console.log(err)
        })

        this.$http({
          method: 'post',
          url: '/Venue/orderType/'+this.venueInfo.venue_id,
        }).then(function (res) {
          let name = []
          let data = []
          for(let i = 0; i < res.data.length; i++){
            if (res.data[i] != 0){
              name.push(self.state[i])
              data.push(res.data[i])
            }
          }
          self.venueDraw('venue-state-container',self, name,data,'演出类型分布')
        }).catch(function (err) {
          console.log(err)
        })
      },
      plan(){
        var self = this
        this.$http({
          method: 'post',
          url: '/Venue/planType/'+this.venueInfo.venue_id,
        }).then(function (res) {
          let name = []
          let data = []
          for(let i = 0; i < res.data.length; i++){
            if (res.data[i] != 0){
              name.push(self.name[i])
              data.push(res.data[i])
            }
          }
          self.venueDraw('venue-plan-container',self, name,data,'演出类型分布')
        }).catch(function (err) {
          console.log(err)
        })

        this.$http({
          method: 'post',
          url: '/Venue/planNumber/'+this.venueInfo.venue_id,
        }).then(function (res) {
          console.log(res.data)
          self.planNumber = res.data
        }).catch(function (err) {
          console.log(err)
        })
      }
    },
    mounted(){
      this.income()
      this.order()
      this.plan()



    }
  }
</script>

<style>

</style>
