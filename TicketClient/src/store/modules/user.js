/**
 * Created by xiaoJun on 2018/3/25.
 */
export const USER_SIGNIN = 'USER_SIGNIN' //登录成功
export const USER_SIGNOUT = 'USER_SIGNOUT' //退出登录
export const USER_MODIFY = 'USER_MODIFY' //更改信息


export default {
  state: {
    user: JSON.parse(window.localStorage.getItem('user')),
    isLogin: JSON.parse(window.localStorage.getItem('isLogin')) || {isLogin: false}
  },
  getters: {
    user: state => state.user,
    isLogin: state => state.isLogin.isLogin,
    discount: state => {
      let level = state.user.level
      let discount = 1
      switch (level){
        case 1:
          discount = 0.95;break;
        case 2:
          discount = 0.9; break;
        case 3:
          discount = 0.85;break;
        case 4:
          discount = 0.8;break;
        case 5:
          discount = 0.75;break;
        case 6:
          discount = 0.7; break;
        case 7:
          discount = 0.65;break;
        case 8:
          discount = 0.6; break;
        default:
          discount = 0.6;break;
      }
      return discount;
    }
  },
  mutations: {
    [USER_SIGNIN](state, user) {
      window.localStorage.setItem('user', JSON.stringify(user))
      state.isLogin.isLogin = true
      window.localStorage.setItem('isLogin', JSON.stringify(state.isLogin))
    },
    [USER_SIGNOUT](state) {
      window.localStorage.removeItem('user')
      state.isLogin.isLogin = false
      window.localStorage.removeItem(('isLogin',JSON.stringify(state.isLogin)))
    },
    [USER_MODIFY](state, user) {
      window.localStorage.setItem('user', JSON.stringify(user))
    }
  },
  actions: {
    [USER_SIGNIN]({commit}, user) {
      commit(USER_SIGNIN, user)
    },
    [USER_SIGNOUT]({commit}) {
      commit(USER_SIGNOUT)
    },
    [USER_MODIFY]({commit}, user) {
      commit(USER_MODIFY, user)
    }
  }
}

