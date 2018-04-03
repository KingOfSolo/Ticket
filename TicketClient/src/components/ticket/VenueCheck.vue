<template>
  <div id="venue-check">
    <el-table
      :data="venueList"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <!--<show-info :show-info="props.row"></show-info>-->
          <!--<el-form label-position="left" inline class="demo-table-expand">-->
          <!--<el-form-item label="商品名称">-->
          <!--<span>{{ props.row.name }}</span>-->
          <!--</el-form-item>-->
          <!--<el-form-item label="所属店铺">-->
          <!--<span>{{ props.row.shop }}</span>-->
          <!--</el-form-item>-->
          <!--<el-form-item label="商品 ID">-->
          <!--<span>{{ props.row.id }}</span>-->
          <!--</el-form-item>-->
          <!--<el-form-item label="店铺 ID">-->
          <!--<span>{{ props.row.shopId }}</span>-->
          <!--</el-form-item>-->
          <!--<el-form-item label="商品分类">-->
          <!--<span>{{ props.row.category }}</span>-->
          <!--</el-form-item>-->
          <!--<el-form-item label="店铺地址">-->
          <!--<span>{{ props.row.address }}</span>-->
          <!--</el-form-item>-->
          <!--<el-form-item label="商品描述">-->
          <!--<span>{{ props.row.desc }}</span>-->
          <!--</el-form-item>-->
          <!--</el-form>-->
        </template>
      </el-table-column>
      <el-table-column
        label="ID"
        prop="venue_id"
        width="80">
      </el-table-column>
      <el-table-column
        label="名称"
        prop="name"
        width="150">
      </el-table-column>
      <el-table-column
        label="地址"
        prop="address"
        width="200">
      </el-table-column>
      <el-table-column
        label="识别码"
        prop="identification"
        width="150">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">通过</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">不通过</el-button>
        </template>
      </el-table-column>
      <!--<el-table-column-->
        <!--label="类型"-->
        <!--width="100">-->
        <!--<template slot-scope="props">-->
          <!--<div>{{types[props.row.type]}}</div>-->
        <!--</template>-->
      <!--</el-table-column>-->
      <!--<el-table-column label="总收入（元）">-->
        <!--<template slot-scope="props">-->
          <!--<total-price :show-id="props.row.show_id"></total-price>-->
        <!--</template>-->
      <!--</el-table-column>-->
    </el-table>
  </div>
</template>

<script>
  export default{
    data () {
      return {
        venueList: []
      }
    },
    methods:{
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
    created(){
      var self = this
      this.$http({
        method: 'post',
        url: '/Manage/checkList/',
      }).then(function (res) {
        console.log(res.data)
        self.venueList = res.data
      }).catch(function (err) {
        console.log(err)
      })
    }
  }
</script>

<style>

</style>
