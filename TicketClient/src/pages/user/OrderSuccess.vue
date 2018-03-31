<template>
  <div id="order-success">
    <div class="order-success-container">
      <div style="display: flex;align-items: center">
        <img src="../../assets/success.svg"/>
        <h2 style="margin-left: 20px">订单支付成功!</h2>
      </div>
      <div>
        <h2 style="margin-left: 70px">您可以在个人中心我的订单查看订单信息~~~</h2>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    data(){
      return{
      }
    }
  }
</script>

<style>
  #order-success{
    display: inline-block;
    width: 700px;
    box-shadow: 0 0 12px 0 #f0f0f0;
    padding: 20px;
    margin-top: 40px;
    border-radius: 5px;
    text-align: left;
  }

    /*.order-success-container{*/
      /*display: flex;*/
      /*align-items: center;*/
    /*}*/

  .order-success h2{
    display: inline-block;
  }

</style>
