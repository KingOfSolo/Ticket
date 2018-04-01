<template>
  <div id="personal-data">
    <h3>消费累计金额：<span style="color: #EA2000">{{total}}元</span></h3>
    <h3>消费金额分布：</h3>
    <div id="type-container" style="height: 350px;"></div>
    <h3>总订单数：<span style="color: #EA2000">{{orderNumber}}单</span></h3>
    <h3>订单状态分布：</h3>
    <div id="state-container" style="height: 350px;"></div>
  </div>
</template>

<script>
  import {pieChart} from '../../charts/PieChart'
  import {testChart} from '../../charts/test'
  import echarts from 'echarts'
  export default{
    data () {
      return{
        chart: null,
        opinion: ['学习氛围差', '学习氛围一般', '学习氛围很好'],
        opinionData: [
          {value:26, name:'学习氛围差'},
          {value:31, name:'学习氛围一般'},
          {value:8, name:'学习氛围很好'}
        ],
        userId: '',
        total: 0,
        orderNumber: 0,
        typeData: [],
        stateData: [],
        name: ['全部', '演唱会', '话剧歌剧', '体育赛事', '音乐会', '儿童亲子', '舞蹈芭蕾', '展览休闲', '曲艺杂谈'],
        state: ['全部','待支付','等待配票','待收票','交易取消','退订']
      }
    },
    created(){
      this.userId = JSON.parse(window.localStorage.getItem("user")).id
    },
    methods:{
      drawPie (id) {
        this.chart = echarts.init(document.getElementById(id))
        this.chart.setOption({
          title: {
            text: '寝室学习氛围情况调查',
            left: 'center',
            top: 10,
            textStyle: {
              fontSize: 24,
              fontFamily: 'Helvetica',
              fontWeight: 400
            }
          },
          tooltip: {
            trigger: 'item',
            formatte: "{b}: {c} ({d}%)"
          },
          toolbox: {
            feature: {
              saveAsImage: {},
              dataView: {}
            },
            right: 15,
            top: 10
          },
          legend: {
            orient: 'vertical',
            left: 5,
            top: 10,
            data: this.opinion,
          },
          series: [
            {
              name: '寝室学习氛围',
              type: 'pie',
              radius: ['50%', '70%'],
              center: ['50%', '60%'],
              avoidLabelOverlap: false,
              label: {
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '24',
                    fontWeight: 'bold'
                  }
                }
              },
              labelLine: {
                normal: {
                  show: false
                }
              },
              data: this.opinionData,
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffset: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        })
      },
      draw(id,self,name,data,title){
        let chart = echarts.init(document.getElementById(id))
        pieChart(chart, title, name, data)
      }
    },
    mounted(){
      var self = this
      this.$http({
        method: 'post',
        url: '/Order/consumption/'+this.userId,
      }).then(function (res) {
        console.log(res.data)
        self.total = res.data
      }).catch(function (err) {
        console.log(err)
      })

      this.$http({
        method: 'post',
        url: '/Order/orderNumber/'+this.userId,
      }).then(function (res) {
        console.log(res.data)
        self.orderNumber = res.data
      }).catch(function (err) {
        console.log(err)
      })

      this.$http({
        method: 'post',
        url: '/Order/type/'+this.userId,
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
        self.draw('type-container',self, name,data,'消费金额分布')
      }).catch(function (err) {
        console.log(err)
      })

      this.$http({
        method: 'post',
        url: '/Order/orderType/'+this.userId,
      }).then(function (res) {
        console.log(res.data)
        let name = []
        let data = []
        for(let i = 0; i < res.data.length; i++){
          if (res.data[i] != 0){
            name.push(self.state[i])
            data.push(res.data[i])
          }
        }
        self.draw('state-container',self, name,data,'订单状态分布')
      }).catch(function (err) {
        console.log(err)
      })

//      this.drawPie('bedroom1')
//      this.$nextTick(function() {
//
//      })
    }
  }
</script>

<style>

</style>
