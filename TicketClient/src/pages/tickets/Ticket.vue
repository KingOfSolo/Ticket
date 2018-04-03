<template>
  <div id="ticket">
    <div class="ticket-container">
      <div class="ticket-tab">
        <div class="ticket-tab-item" v-for="(item,index) in ticketTab" :key="index"
             :class="{ticketTabActive: index == tabActiveNum}" @click="ticketTabClick(index)">{{item}}</div>
      </div>
      <div class="ticket-content">
        <venue-check v-if="tabActiveNum == 0"></venue-check>
        <payment v-else-if="tabActiveNum == 1"></payment>
        <ticket-data v-else-if="tabActiveNum == 2"></ticket-data>
        <!--<release-plan  v-else-if="tabActiveNum == 1" :ticket-info="ticketInfo"></release-plan>-->
        <!--<plan-manage v-else-if="tabActiveNum == 2" :ticket-info="ticketInfo"></plan-manage>-->
        <!--<ticket-data v-else-if="tabActiveNum == 3" :ticket-info="ticketInfo"></ticket-data>-->
      </div>
    </div>
  </div>
</template>

<script>
  import VenueCheck from '../../components/ticket/VenueCheck.vue'
  import Payment from '../../components/ticket/Payment.vue'
  import TicketData from '../../components/ticket/TicketData.vue'
  export default{
    components:{
      VenueCheck,
      Payment,
      TicketData
    },
    data () {
      return {
        ticketTab: ['申请审核','支付结算','统计数据'],
        tabActiveNum: 0,
      }
    },
    methods: {
      ticketTabClick(index){
        this.tabActiveNum = index
      }
    },
  }
</script>

<style>
  #ticket{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    vertical-align: top;
  }

  .ticket-container{
    display: flex;
    justify-content: flex-start;
  }

  .ticket-tab{
    display: inline-block;
    margin-right: 30px;
  }

  .ticket-tab-item{
    padding: 20px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    /*border-radius: 5px;*/
    border: 1px solid #eeeeee;
    cursor: pointer;
    color: #909399;
  }

  .ticket-tab-item:hover{
    color: #10cf7d;
  }

  .ticketTabActive{
    color: #10cf7d;
  }

  .ticket-content{
    display: inline-block;
    width: 800px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    border-radius: 5px;
    text-align: left;
    margin-bottom: 40px;
  }
</style>
