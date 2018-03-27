/**
 * Created by xiaoJun on 2018/3/27.
 */
export const ORDER_INFO = 'ORDER_INFO' //订单信息
export const ORDER_CONFIRM = 'ORDER_CONFIRM' //订单确认

export default {
  state: {
    order: JSON.parse(window.localStorage.getItem("order")),
  },
  getters:{
    order: state => state.order
  },
  mutations: {
    [ORDER_INFO](state, info){
      window.localStorage.setItem("order",JSON.stringify(info))
    },
  },
  actions: {
    [ORDER_INFO]({commit}, info){
      console.log(info)
      commit(ORDER_INFO,info)
    }
  }
}
