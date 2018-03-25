/**
 * Created by xiaoJun on 2018/3/25.
 */
export const USER_SIGNIN = 'USER_SIGNIN' //登录成功
export const USER_SIGNOUT = 'USER_SIGNOUT' //退出登录


export default {
  state: {
    userId: sessionStorage.getItem('user') || null
  },
  mutations: {
    [USER_SIGNIN](state, user) {
      sessionStorage.setItem('user', user)
    },
    [USER_SIGNOUT](state) {
      sessionStorage.removeItem('user')
    }
  },
  actions: {
    [USER_SIGNIN]({commit}, user) {
      commit(USER_SIGNIN, user)
    },
    [USER_SIGNOUT]({commit}) {
      commit(USER_SIGNOUT)
    }
  }
}

