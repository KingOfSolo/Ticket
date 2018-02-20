<template>
  <div id="release-plan">
    <el-form label-width="100px" :label-position="labelPosition" style="text-align: left">
      <el-form-item label="演出名称" required>
        <el-input v-model="showInfo.name"></el-input>
      </el-form-item>
      <el-form-item label="演出时间" required>
        <el-date-picker
          v-model="showInfo.startDate"
          type="datetime"
          placeholder="选择开始日期时间">
        </el-date-picker>
        <span class="line"></span>
        <el-date-picker
          v-model="showInfo.endDate"
          type="datetime"
          placeholder="选择结束日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="演出价位" required >
        <div class="price-container">
          <div v-for="(tag, index) in venueInfo.tagList" :key="index" class="price-input">
            <el-tag>{{tag}}</el-tag>
            <el-input v-model="showInfo.priceList[index]" size="medium" placeholder="元"></el-input>
          </div>
        </div>

      </el-form-item>
      <el-form-item label="演出类型" required>
        <el-select v-model="showInfo.type" placeholder="请选择">
          <el-option
            v-for="item in typeList"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="演出海报" required>
        <el-upload
          action="https://jsonplaceholder.typicode.com/posts/"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove">
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="showInfo.posterUrl" alt="">
        </el-dialog>
      </el-form-item>
      <el-form-item label="演出简介">
        <el-input
          type="textarea"
          :rows="4"
          v-model="showInfo.intro">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">确认发布</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default{
    components: {
      ElButton,
      ElFormItem},
    props: ['venueInfo'],
    data () {
      return{
        labelPosition: 'left',
        showInfo:{
          name: '',
          startDate: '',
          endDate: '',
          priceList: [],
          type: '',
          posterUrl:'',
          intro: ''
        },
        typeList: ['演唱会', '话剧歌剧', '体育赛事', '音乐会', '儿童亲子', '舞蹈芭蕾', '展览休闲', '曲艺杂谈'],
        dialogVisible: false
      }
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.showInfo.posterUrl = file.url;
        this.dialogVisible = true;
      }
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
