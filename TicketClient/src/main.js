// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Vuex from 'vuex'
import router from './router'
import ElementUI from 'element-ui'
import iView from 'iview'
import 'element-ui/lib/theme-chalk/index.css'
import './theme.css'
import axiosService from '../axiosService'
import store from './store/index'
import 'jquery'
import 'jquery-countdown'

Vue.config.productionTip = false
Vue.prototype.$http = axiosService


Vue.use(ElementUI)
Vue.use(iView)
Vue.use(Vuex)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
