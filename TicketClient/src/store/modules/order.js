/**
 * Created by xiaoJun on 2018/3/27.
 */
export const ORDER_INFO = 'ORDER_INFO' //订单信息

export default {
  state: {
    order: JSON.parse(window.sessionStorage.getItem("order")),
  },
  getters:{
    order: state => state.order
  },
  mutations: {
    [ORDER_INFO](state, info){
      window.sessionStorage.setItem("order",JSON.stringify(info))
    },
  },
  actions: {
    [ORDER_INFO]({commit}, info){
      commit(ORDER_INFO,info)
    }
  }
}
