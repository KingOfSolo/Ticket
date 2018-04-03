<template>
  <div class="seat-info">
    <el-table :data="seatInfo" border style="width: 241px">
      <el-table-column
        prop="seat_name"
        label="座位类型"
        width="120">
      </el-table-column>
      <el-table-column
        prop="number"
        label="座位数量"
        width="120">
      </el-table-column>
      </el-table>
  </div>
</template>

<script>
  export default{
    props: ['seatInfo'],
    data(){
      return{
      }
    },
  }
</script>

<style>
  .seat-info{
    text-align: center;
  }
</style>
