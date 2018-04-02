<template>
  <div id="venue">
    <div class="venue-container">
      <div class="venue-tab">
        <div class="venue-tab-item" v-for="(item,index) in venueTab" :key="index"
             :class="{venueTabActive: index == tabActiveNum}" @click="venueTabClick(index)">{{item}}</div>
      </div>
      <div class="venue-content">
        <venue-info v-if="tabActiveNum == 0" :venue-info="venueInfo"></venue-info>
        <release-plan  v-else-if="tabActiveNum == 1" :venue-info="venueInfo"></release-plan>
        <plan-manage v-else-if="tabActiveNum == 2" :venue-info="venueInfo"></plan-manage>
        <venue-data v-else-if="tabActiveNum == 3" :venue-info="venueInfo"></venue-data>
      </div>
    </div>
  </div>
</template>

<script>
  import VenueInfo from '../../components/venue/VenueInfo.vue'
  import EditInfo from  '../../components/venue/EditInfo.vue'
  import ReleasePlan from '../../components/venue/ReleasePlan.vue'
  import VenueData from '../../components/venue/VenueData.vue'
  import PlanManage from '../../components/venue/PlanManage.vue'
  export default{
    components: {
      VenueInfo,
      EditInfo,
      ReleasePlan,
      VenueData,
      PlanManage
    },
    data () {
      return{
        tabPosition: 'left',
        showInfo: true,
        venueTab: ['场馆信息','发布计划','演出管理','统计数据'],
        tabActiveNum: 0,
        venueInfo: {
//          identification: '2552000',
//          name: '上海梅赛德斯奔驰文化中心',
//          address: '上海市浦东世博大道1200号',
//          tagList: ['看台一', '看台二', '看台三', '内场一', '内场二', '内场三', '内场四'],
        }
      }
    },
    methods: {
      showEdit: function () {
        this.showInfo = false
      },
      showInformation: function () {
        this.showInfo = true
      },
      venueTabClick(index){
        this.tabActiveNum = index
      }
    },
    mounted (){
      var self = this
      this.$http({
        method: 'post',
        url: '/Venue/id/'+this.$route.params.venueId
      }).then(function (res) {
        console.log(res)
        self.venueInfo = res.data
      })
    }
  }
</script>

<style>
  #venue{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    vertical-align: top;
  }

  .venue-container{
    display: flex;
    justify-content: flex-start;
  }

  .venue-tab{
    display: inline-block;
    margin-right: 30px;
  }

  .venue-tab-item{
    padding: 20px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    /*border-radius: 5px;*/
    border: 1px solid #eeeeee;
    cursor: pointer;
    color: #909399;
  }

  .venue-tab-item:hover{
    color: #10cf7d;
  }

  .venueTabActive{
    color: #10cf7d;
  }

  .venue-content{
    display: inline-block;
    width: 800px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    border-radius: 5px;
    text-align: left;
    margin-bottom: 40px;
  }
</style>
