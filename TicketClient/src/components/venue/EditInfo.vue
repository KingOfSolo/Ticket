<template>
  <div id="edit-info">
    <el-form label-width="100px" :label-position="labelPosition" style="text-align: left">
      <el-form-item label="场馆识别码">
        <span class="identification">{{venueInfo.identification}}</span>
      </el-form-item>
      <el-form-item label="场馆名称">
        <el-input v-model="venueInfo.name"></el-input>
      </el-form-item>
      <el-form-item label="详细地址">
        <el-input v-model="venueInfo.address"></el-input>
      </el-form-item>
      <el-form-item label="座位情况">
        <el-tag
          :key="index"
          v-for="(seat,index) in venueInfo.tagList"
          closable
          :disable-transitions="false"
          @close="handleClose(seat)">
          {{seat.seat_name}}
        </el-tag>
        <el-input
          class="input-new-tag"
          v-if="inputVisible"
          v-model="inputValue"
          ref="saveTagInput"
          size="small"
          @keyup.enter.native="handleInputConfirm"
          @blur="handleInputConfirm"
        >
        </el-input>
        <el-button v-else size="small" class="button-new-tag" @click="showInput">+添加</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 100px" @click="submit">提交申请</el-button>
        <el-button style="width: 100px" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default{
    components: {ElButton},
    props: ['venueInfo'],
    data () {
      return{
        labelPosition: 'left',
        inputVisible: false,
        inputValue: '',
      }
    },
    methods: {
      cancel: function () {
        this.$emit('info')
      },
      submit(){
        this.$message({
          message:'申请已经提交。等待Tickets经理审核',
          type: 'success'
        })
      },
      handleClose(tag) {
        this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
          this.dynamicTags.push(inputValue);
        }
        this.inputVisible = false;
        this.inputValue = '';
      }
    }
  }
</script>

<style>
  #edit-info{
    margin: 50px 100px 50px 40px;
  }

  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
</style>
