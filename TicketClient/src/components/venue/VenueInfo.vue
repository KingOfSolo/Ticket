<template>
  <div id="venue-info">
    <el-form label-width="100px" :label-position="labelPosition" style="text-align: left">
      <el-form-item label="场馆识别码">
        <span class="identification">{{venueInfo.identification}}</span>
      </el-form-item>
      <el-form-item label="场馆名称">
        <span class="venue-info-label">{{venueInfo.name}}</span>
      </el-form-item>
      <el-form-item label="详细地址">
        <span class="venue-info-label">{{venueInfo.address}}</span>
      </el-form-item>
      <el-form-item label="座位情况">
        <el-tag
          :key="index"
          v-for="(seat,index) in venueInfo.seats">
          {{seat.seat_name}}
        </el-tag>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="editInfo">修改信息</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default{
    props: ['venueInfo'],
    data () {
      return{
        labelPosition: 'left',
      }
    },
    methods: {
      editInfo: function () {
        this.$emit('edit')
      }
    }
  }
</script>

<style>
  #venue-info{
    margin: 50px 100px 50px 40px;
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
</style>
