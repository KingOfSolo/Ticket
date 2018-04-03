<template>
  <div id="plan-manage">
    <el-table
      :data="showList"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <show-info :show-info="props.row"></show-info>
        </template>
      </el-table-column>
      <el-table-column
        label="ID"
        prop="show_id"
        width="80">
      </el-table-column>
      <el-table-column
        label="名称"
        prop="name"
        width="250">
      </el-table-column>
      <el-table-column
        label="开始时间"
        prop="start_time"
        width="150">
      </el-table-column>
      <el-table-column
        label="类型"
        width="100">
        <template slot-scope="props">
          <div>{{types[props.row.type]}}</div>
        </template>
      </el-table-column>
      <el-table-column label="总收入（元）">
        <template slot-scope="props">
          <total-price :show-id="props.row.show_id"></total-price>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import TotalPrice from './TotalPrice.vue'
  import ShowInfo from './ShowInfo.vue'
  export default{
    components:{
      TotalPrice,
      ShowInfo
    },
    props: ['venueInfo'],
    data(){
      return{
        showList: [],
        types: ['全部', '演唱会', '话剧歌剧', '体育赛事', '音乐会', '儿童亲子', '舞蹈芭蕾', '展览休闲', '曲艺杂谈'],
      }
    },
    created(){
      var self = this
      this.$http({
        method: 'post',
        url: '/Venue/showList/'+this.venueInfo.venue_id,
      }).then(function (res) {
        console.log(res.data)
        self.showList = res.data
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style>

</style>

