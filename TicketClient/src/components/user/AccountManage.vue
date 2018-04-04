<template>
  <div id="account-manage" >
    <el-form v-if="isShow" label-width="90px" :labelPosition="labelPosition" :model="form" ref="form">
      <el-form-item label="会员等级">
        <div class="level">Lv.{{userInfo.level}}</div>
      </el-form-item>
      <el-form-item label="会员积分">
        <div>{{userInfo.accumulation}}</div>
      </el-form-item>
      <el-form-item label="账户余额">
        <div>{{userInfo.balance}}元</div>
      </el-form-item>
      <el-form-item label="昵称">
        <div>{{userInfo.name}}</div>
      </el-form-item>
      <el-form-item label="密码">
        <div>*******</div>
      </el-form-item>
      <el-form-item label="邮箱">
        <div>{{userInfo.email}}</div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="isShow = false">修改</el-button>
        <el-button type="danger" @click="frozenDialogVisible = true">冻结会员</el-button>
      </el-form-item>
    </el-form>
    <el-form v-else label-width="90px" :labelPosition="labelPosition">
      <el-form-item label="会员等级">
        <div class="level">Lv.{{userInfo.level}}</div>
      </el-form-item>
      <el-form-item label="会员积分">
        <div>{{userInfo.accumulation}}</div>
      </el-form-item>
      <el-form-item label="账户余额">
        <div>{{userInfo.balance}}元</div>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="editInfo.name"></el-input>
      </el-form-item>
      <el-form-item label="当前密码">
        <el-input type="password" v-model="editInfo.currentPassword"></el-input>
      </el-form-item>
      <el-form-item label="修改密码">
        <el-input type="password" v-model="editInfo.changePassword"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="editInfo.email"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="change">确认修改</el-button>
        <el-button @click="isShow = true">取消</el-button>
      </el-form-item>
    </el-form>
    <el-dialog
      title="提示"
      :visible.sync="frozenDialogVisible"
      width="30%">
      <span style="font-weight: bolder;font-size: 18px">确定要冻结会员吗？冻结之后不可恢复！</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="frozenCancel">取 消</el-button>
    <el-button type="primary" @click="frozenConfirm">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import ElForm from "../../../node_modules/element-ui/packages/form/src/form";
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import ElProgress from "../../../node_modules/element-ui/packages/progress/src/progress";
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  import {mapGetters} from 'vuex'
  export default{
    props: ['userInfo'],
    computed :{
//      ...mapGetters({
//        userInfo: 'user'
//      })
    },
    components: {
      ElButton,
      ElProgress,
      ElInput,
      ElFormItem,
      ElForm},
    data () {
      return{
        labelPosition: 'left',
        percentage: 50,
        isShow: true,
        frozenDialogVisible: false,
        form: {
          resource: ''
        },
        editInfo:{
          name: '',
          currentPassword: '',
          changePassword: '',
          email: ''
        }
      }
    },
    methods: {
      change(){
        if (this.editInfo.currentPassword != this.userInfo.password){
          this.$message({
            message:'当前密码不正确',
            type: 'warning'
          })
        }else{
          let self = this
          let formData = this.userInfo
          formData.name = this.editInfo.name
          formData.password = this.editInfo.changePassword
          formData.email = this.editInfo.email
          this.$http({
            method: 'post',
            url: '/User/modify',
            data: formData
          }).then(function (res) {
            console.log(res)
            self.$store.dispatch('USER_MODIFY',res.data)
            self.isShow = true
            self.$message({
              message:'用户信息修改成功',
              type: 'success'
            })
          }).catch(function (err) {
            alert(err)
          })
        }
      },
      frozenCancel(){
        this.frozenDialogVisible = false
      },
      frozenConfirm(){
        this.frozenDialogVisible = false
        this.$store.dispatch('USER_SIGNOUT')
        this.$router.push({name: 'Home'})
        window.localStorage.removeItem('userId')
        this.$http({
          method: 'post',
          url: '/User/frozen/'+this.userInfo.id,
        }).then(function (res) {
        }).catch(function (err) {
          console(err)
        })
      }
    },
    beforeMounted(){
      this.editInfo.name = this.userInfo.name
      this.editInfo.email = this.userInfo.email
    }
  }
</script>

<style>
  #account-manage{
    padding: 20px 300px 20px 40px;
    text-align: left;
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

  .level{
    font-size: 20px;
    font-weight: bold;
    color: #EA2000;
  }
</style>
