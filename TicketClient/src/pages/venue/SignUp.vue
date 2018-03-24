<template>
  <div id="venue-sign-up">
    <div style="width: 600px;display: inline-block">
      <div style="display: flex;flex-direction: row;align-items: center;justify-content: space-between;margin-bottom: 50px">
        <span class="back" @click="backToLogin">返回登录</span>
        <span style="font-size: 25px;font-weight: bold">场馆注册申请</span>
        <span></span>
      </div>
      <el-form label-width="120px" :model="form" :label-position="labelPosition" style="text-align: left">
        <el-form-item label="邮箱" required>
          <el-input v-model="form.email"></el-input>
        </el-form-item>
        <el-form-item label="密码" required>
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="场馆名称" required>
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="详细地址" required>
          <el-input v-model="form.address"></el-input>
        </el-form-item>
        <el-form-item label="座位名称" required>
          <el-tag
            :key="index"
            v-for="(seat,index) in form.seats"
            closable
            :disable-transitions="false"
            @close="handleClose(seat)">
            {{seat.seat_name}}
          </el-tag>
          <el-input
            class="input-new-tag"
            v-if="inputVisible"
            v-model="inputName"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleInputConfirm"
            @blur="handleInputConfirm">
          </el-input>
          <el-button v-else size="small" class="button-new-tag" @click="showInput">+添加</el-button>
        </el-form-item>
        <el-form-item label="对应座位数量" required="">
          <el-input v-for="(seat,index) in form.seats" :key="index" v-model="form.seats[index].number" size="small" class="input-new-tag"></el-input>
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
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  export default{
    components: {
      ElFormItem,
      ElInput},
    data () {
      return {
        form: {
          email: '',
          password: '',
          name: '',
          address: '',
          seats: [
            {
              seat_name: '看台一',
              number: 100
            }
          ]
        },
        labelPosition: 'left',
        dynamicTags: ['看台一'],
        inputVisible: false,
        inputName: '',
      }
    },
    methods: {
      backToLogin(){
        this.$router.push({name: 'Login'})
      },
      submit(){
        console.log(this.form)
        var self = this
        this.$http({
          method: 'post',
          url: '/Venue/register',
          data: this.form
        }).then(function (res) {
          self.$message({
            message:'申请已经提交，等待Tickets经理审核，审核通过后会有邮件通知',
            type: 'success'
          })
        }).catch(function (err) {
          console.log(err.request)
        })
      },
      handleClose(seat) {
        this.form.seats.splice(this.form.seats.indexOf(seat), 1);
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
//          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      handleInputConfirm() {
        let inputName = {
          'seat_name': this.inputName,
          'number': 0
        };
        if (inputName) {
          this.form.seats.push(inputName);
        }
        this.inputVisible = false;
        this.inputName = '';
      }
    },
    mounted (){

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
