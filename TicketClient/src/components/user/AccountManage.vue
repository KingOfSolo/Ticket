<template>
  <div id="account-manage" >
    <el-form label-width="90px" :labelPosition="labelPosition" :model="form" ref="form">
      <el-form-item label="会员等级">
        <div style="text-align: left">Lv.7</div>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input></el-input>
      </el-form-item>
    </el-form>

    <!--<div id="account-form">-->
      <!--<div class="account-form-item">-->
        <!--<div class="account-form-label">会员等级</div>-->
        <!--<div style="text-align: left">Lv.7</div>-->
      <!--</div>-->
      <!--<div class="account-form-item">-->
        <!--<div class="account-form-label">昵称</div>-->
        <!--<el-input></el-input>-->
      <!--</div>-->
    <!--</div>-->
  </div>
</template>

<script>
  import ElForm from "../../../node_modules/element-ui/packages/form/src/form";
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import ElProgress from "../../../node_modules/element-ui/packages/progress/src/progress";
  export default{
    components: {
      ElProgress,
      ElInput,
      ElFormItem,
      ElForm},
    data () {
      return{
        labelPosition: 'left',
        percentage: 50,
        form: {
          resource: ''
        }
      }
    }
  }
</script>

<style>
  #account-manage{
    padding: 20px 300px 20px 40px;
  }

  #account-form{
    text-align: left;
  }

  .account-form-item{
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 10px;
  }

  .account-form-label{
    display: inline-block;
    width: 100px;
  }
</style>
