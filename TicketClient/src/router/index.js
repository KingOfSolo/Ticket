import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/user/HomePage'
import Choose from '@/pages/user/ChoosePage'
import Detail from '@/pages/user/DetailPage'
import User from '@/pages/user/UserPage'

import Login from '@/pages/venue/SignIn'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Choose',
      name:'Choose',
      component:Choose
    },
    {
      path: '/Detail/:id',
      name: 'Detail',
      component:Detail
    },
    {
      path: '/User/:userId',
      name: 'User',
      component:User
    },
    {
      path: '/Login',
      name: 'Login',
      component:Login
    }
  ]
})
