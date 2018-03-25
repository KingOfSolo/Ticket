/**
 * Created by xiaoJun on 2018/3/25.
 */
import Vue from 'vue'
import user from './modules/user'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    user
  }
})
