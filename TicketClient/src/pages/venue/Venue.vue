<template>
  <div id="venue">
    <el-tabs :tab-position="tabPosition" type="border-card" value="first" style="width: 850px;display: inline-block;margin-bottom: 100px">
      <el-tab-pane name="first">
        <span slot="label"><i class="el-icon-edit">场馆信息</i></span>
        <venue-info v-on:edit="showEdit" v-if="showInfo" :venue-info="venueInfo"></venue-info>
        <edit-info v-on:info="showInformation" v-else :venue-info="venueInfo"></edit-info>
      </el-tab-pane>
      <el-tab-pane name="second">
        <span slot="label"><i class="el-icon-tickets"></i>发布计划</span>
        <release-plan :venueInfo="venueInfo"></release-plan>
      </el-tab-pane>
      <el-tab-pane name="third">
        <span slot="label"><i class="el-icon-date"></i>统计数据</span>
        <venue-data></venue-data>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import VenueInfo from '../../components/venue/VenueInfo.vue'
  import EditInfo from  '../../components/venue/EditInfo.vue'
  import ReleasePlan from '../../components/venue/ReleasePlan.vue'
  import VenueData from '../../components/venue/VenueData.vue'
  export default{
    components: {
      VenueInfo,
      EditInfo,
      ReleasePlan,
      VenueData
    },
    data () {
      return{
        tabPosition: 'left',
        showInfo: true,
        venueInfo: {
          identification: '2552000',
          name: '上海梅赛德斯奔驰文化中心',
          address: '上海市浦东世博大道1200号',
          tagList: ['看台一', '看台二', '看台三', '内场一', '内场二', '内场三', '内场四'],
        }
      }
    },
    methods: {
      showEdit: function () {
        this.showInfo = false
      },
      showInformation: function () {
        this.showInfo = true
      }
    }
  }
</script>

<style>

</style>
