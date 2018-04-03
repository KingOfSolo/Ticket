<template>
  <div id="release-plan">
    <el-form label-width="100px" :label-position="labelPosition" style="text-align: left">
      <el-form-item label="演出名称" required>
        <el-input v-model="showInfo.name"></el-input>
      </el-form-item>
      <el-form-item label="演出时间" required>
        <el-date-picker
          v-model="showInfo.start_time"
          value-format="yyyy-MM-dd HH:mm "
          type="datetime"
          placeholder="选择开始日期时间">
        </el-date-picker>
        <span class="line"></span>
        <el-date-picker
          v-model="showInfo.end_time"
          value-format="yyyy-MM-dd HH:mm"
          type="datetime"
          placeholder="选择结束日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="演出价位" required >
        <div class="price-container">
          <div v-for="(seat, index) in venueInfo.seats" :key="index" class="price-input">
            <el-tag>{{seat.seat_name}}</el-tag>
            <el-input v-model="showInfo.showPrices[index].price" size="medium" placeholder="元" class="price-input-item"></el-input>
          </div>
        </div>

      </el-form-item>
      <el-form-item label="演出类型" required>
        <el-select v-model="showInfo.type" placeholder="请选择">
          <el-option
            v-for="item in typeList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="演出海报" required>
        <!--<el-upload-->
          <!--action="http://localhost:8075/TicketServer/Venue/uploadPoster"-->
          <!--list-type="picture-card"-->
          <!--:on-preview="handlePictureCardPreview"-->
          <!--:on-remove="handleRemove"-->
          <!--:on-success="handleSuccess">-->
          <!--<i class="el-icon-plus"></i>-->
        <!--</el-upload>-->
        <!--<el-dialog :visible.sync="dialogVisible">-->
          <!--<img width="100%" :src="showInfo.poster" alt="">-->
        <!--</el-dialog>-->
        <el-input v-model="showInfo.poster" placeholder="请输入海报url"></el-input>
      </el-form-item>
      <el-form-item label="演出简介">
        <el-input
          type="textarea"
          :rows="4"
          v-model="showInfo.introduce">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="release">确认发布</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  export default{
    components: {
      ElInput,
      ElButton,
      ElFormItem},
    props: ['venueInfo'],
    data () {
      return{
        labelPosition: 'left',
        showInfo:{
          venue_id: '',
          address: '',
          name: '',
          start_time: '',
          end_time: '',
          showPrices: [
            {price: ''},{price: ''},{price: ''},{price: ''},{price: ''},{price: ''},
            {price: ''},{price: ''},{price: ''},{price: ''},{price: ''},{price: ''}
          ],
          type: '',
          poster:'',
          introduce: ''
        },
        typeList: [
          {value:1, label:'演唱会'},
          {value:2, label: '话剧歌剧'},
          {value:3, label:'体育赛事'},
          {value:4, label:'音乐会'},
          {value:5, label:'儿童亲子'},
          {value:6, label:'舞蹈芭蕾'},
          {value:7, label:'展览休闲'},
          {value:8, label:'曲艺杂谈'}
          ],
        dialogVisible: false,
        priceLength: 0
      }
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        console.log(file.url)
        this.showInfo.poster = file.url;
        this.dialogVisible = true;
      },
      handleSuccess(response, file, fileList){
        this.showInfo.poster = response
        console
      },
      release(){
        var self = this
        this.priceLength = this.venueInfo.seats.length
        this.showInfo.venue_id = this.venueInfo.venue_id
        this.showInfo.address = this.venueInfo.name
        let array = []
        for(let i = 0; i < this.venueInfo.seats.length; i++){
          array.push({
            seat_name: this.venueInfo.seats[i].seat_name,
            price: this.showInfo.showPrices[i].price,
            total_num: this.venueInfo.seats[i].number,
            remain_num: this.venueInfo.seats[i].number
          })
        }
        this.showInfo.showPrices = array
        console.log(this.showInfo)
        this.$http({
          method: 'post',
          url: '/Venue/releaseShow',
          data: this.showInfo
        }).then(function (res) {
          self.$message({
            message:'活动发布成功',
            type: 'success'
          })
        })

      }
    },
//    beforeCreated(){
//      for(let i = 0; i < this.venueInfo.seats.length; i++){
//        this.showInfo.showPrices.push({
//          name: this.venueInfo.seats[i].seat_name,
//          price: '',
//          total_num: this.venueInfo.seats[i].number,
//          remain_num: this.venueInfo.seats[i].number
//        })
//      }
//    },
    mounted(){
//      for(let i = 0; i < this.venueInfo.seats.length; i++){
//          this.showInfo.showPrices.push({
//            seat_name: this.venueInfo.seats[i].seat_name,
//            price: '',
//            total_num: this.venueInfo.seats[i].number,
//            remain_num: this.venueInfo.seats[i].number
//          })
//      }
    }
  }
</script>

<style>
  #release-plan{
    margin: 50px 100px 50px 40px;
  }

  .line{
    display: inline-block;
    width: 10px;
    border-top: 1px solid #ccc ;
  }

  .price-input{
    padding-top: 10px;
    display: inline-block;
  }

  .price-input:nth-of-type(even){
    margin-left: 40px;
  }

  .price-input .el-input{
    margin-left: 10px;
    display: inline-block;
    width: 100px;
  }
</style>
