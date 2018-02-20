<template>
  <div id="venue-sign-up">
    <div style="width: 600px;display: inline-block">
      <div style="display: flex;flex-direction: row;align-items: center;justify-content: space-between;margin-bottom: 50px">
        <span class="back" @click="backToLogin">返回登录</span>
        <span style="font-size: 25px;font-weight: bold">场馆注册申请</span>
        <span></span>
      </div>
      <el-form label-width="100px" :label-position="labelPosition" style="text-align: left">
        <el-form-item label="场馆识别码">
          <span class="identification">2552000</span>
        </el-form-item>
        <el-form-item label="密码" required>
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="场馆名称" required>
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="详细地址" required>
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="座位情况" required>
          <el-tag
            :key="tag"
            v-for="tag in dynamicTags"
            closable
            :disable-transitions="false"
            @close="handleClose(tag)">
            {{tag}}
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
          <button class="venue-sign-button" @click="submit">提交申请</button>
          <!--<el-button type="primary">提交申请</el-button>-->
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default{
    data () {
      return {
        labelPosition: 'left',
        dynamicTags: ['看台一'],
        inputVisible: false,
        inputValue: ''
      }
    },
    methods: {
      backToLogin(){
        this.$router.push({name: 'Login'})
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
  #venue-sign-up{
    padding: 10px;
  }

  .identification{
    font-size: large;
    color: #EA2000;
    font-weight: bold;
    text-align: left;
  }

  .el-tag + .el-tag {
    margin-left: 10px;
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

  .back{
    font-size: 14px;
    color: #999999;
    cursor: pointer;
  }

  .back{
    text-decoration: underline;
  }

  .venue-sign-button{
    width: 100%;
    line-height: 37px;
    vertical-align: middle;
    border: 1px solid #10cf7d;
    background-color: transparent;
    border-radius: 4px;
    color: #10cf7d;
    cursor: pointer;
    padding: 0 10px;
    outline: none;
    letter-spacing: 10px;
    transition: all 0.3s;
  }

  .venue-sign-button:hover{
    background-color: #10cf7d;
    color: white;
  }
</style>
