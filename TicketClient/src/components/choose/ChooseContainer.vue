<template>
  <div id="choose-container">
    <div style="text-align: left">
      <choose-show-display v-for="(item, index) in chooseShowInfoList" :key="item" :choose-show-info="item"
        v-if="(currentPage - 1) * pageSize <= index && index < currentPage * pageSize"></choose-show-display>
    </div>
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
  import ChooseShowDisplay from './ChooseShowDisplay.vue'
  export default{
    components:{
      ChooseShowDisplay
    },
    data () {
      return{
        chooseShowInfoList: [
          {
            posterUrl:'https://picsum.photos/300/300/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/300/301/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/300/302/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/301/301/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/302/301/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/303/303/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/199/306/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/199/305/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/198/366/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/310/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/320/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/330/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/331/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/332/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/333/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/334/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          },
          {
            posterUrl:'https://picsum.photos/197/335/?random',
            title:'【上海站】上海杂技团《欢乐马戏》',
            intro: '美是魅力，丑是乐，欢乐马戏全都有',
            time: '2018.3.31 19:30',
            place: '上海梅赛德斯奔驰文化中心',
            price: 322
          }
        ],
        totalSize: 17,
        pageSize: 10,
        currentPage: 1
      }
    },
    methods: {
      handleCurrentChange: function (val) {
        this.currentPage = val
      }
    },
  }
</script>

<style>
  #choose-container{
    margin-top: 50px;
    text-align: left;
    padding-bottom: 100px;
  }

  .noneDisplay{
    display: none;
  }
</style>
