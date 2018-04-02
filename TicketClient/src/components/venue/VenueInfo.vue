<template>
  <div id="venue-info">
    <el-form label-width="100px" v-if="showEdit" :label-position="labelPosition" style="text-align: left">
      <el-form-item label="场馆识别码">
        <span class="identification">{{venueInfo.identification}}</span>
      </el-form-item>
      <el-form-item label="邮箱">
        <span class="venue-info-label">{{venueInfo.email}}</span>
      </el-form-item>
      <el-form-item label="场馆名称">
        <span class="venue-info-label">{{venueInfo.name}}</span>
      </el-form-item>
      <el-form-item label="详细地址">
        <span class="venue-info-label">{{venueInfo.address}}</span>
      </el-form-item>
      <el-form-item label="座位情况">
        <el-table
          :data="venueInfo.seats"
          border
          style="width: 242px">
          <el-table-column
            prop="seat_name"
            label="座位名称"
            width="120">
          </el-table-column>
          <el-table-column
            prop="number"
            label="座位数量"
            width="120">
          </el-table-column>
        </el-table>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="editInfo">修改信息</el-button>
      </el-form-item>
    </el-form>

    <el-form label-width="100px" v-else :label-position="labelPosition" style="text-align: left">
      <el-form-item label="场馆识别码">
        <span class="identification">{{venueInfo.identification}}</span>
      </el-form-item>
      <el-form-item label="邮箱">
        <span class="venue-info-label">{{venueInfo.email}}</span>
      </el-form-item>
      <el-form-item label="场馆名称">
        <el-input v-model="venueEditInfo.name"></el-input>
      </el-form-item>
      <el-form-item label="详细地址">
        <el-input v-model="venueEditInfo.address"></el-input>
      </el-form-item>
      <el-form-item label="座位情况">
        <el-table
          :data="venueEditInfo.seats"
          border
          style="width: 241px">
          <el-table-column
            prop="seat_name"
            label="座位名称"
            width="120">
          </el-table-column>
          <el-table-column
            prop="number"
            label="座位数量"
            width="120">
          </el-table-column>
        </el-table>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 100px" @click="submit">提交申请</el-button>
        <el-button style="width: 100px" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item";
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button";
  export default{
    components: {
      ElButton,
      ElInput,
      ElFormItem},
    props: ['venueInfo'],
    data () {
      return{
        labelPosition: 'left',
        showEdit: true,
        inputVisible: false,
        inputValue: '',
        venueEditInfo: {
          name: '呵呵1',
          address: '撒旦法三 ',
          seats: []
        }
      }
    },
    methods: {
      editInfo: function () {
        this.showEdit = false
      },
      cancel(){
        this.showEdit = true
      },
      submit(){

      },
    },
    created(){
      this.venueEditInfo = this.venueInfo
    }
  }
</script>

<style>
  #venue-info{
    margin: 20px 100px 50px 40px;
  }

  .el-tag{
    margin-left: 10px;
  }

  .identification{
    font-size: large;
    color: #EA2000;
    font-weight: bold;
    text-align: left;
  }

  .venue-info-label{
    font-size: large;
    text-align: left;
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
