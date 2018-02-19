<template>
  <div id="receive-address">
    <el-form label-width="90px" :labelPosition="labelPosition" :model="form" ref="form">
      <el-form-item label="取票人">
        <el-input placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input placeholder="联系方式"></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input placeholder="详细地址"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default{
    data () {
      return{
        labelPosition: 'left',
        form: {

        }
      }
    }
  }
</script>

<style>
  #receive-address{
    padding: 20px 300px 20px 40px;
  }
</style>
