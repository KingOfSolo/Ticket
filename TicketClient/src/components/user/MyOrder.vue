<template>
  <div id="my-order">

  </div>
</template>

<script>
  import ElInput from "../../../node_modules/element-ui/packages/input/src/input";
  export default{
    components: {ElInput},
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
  #my-order{
    padding: 20px 300px 20px 40px;
  }
</style>
