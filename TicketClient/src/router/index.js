import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/HomePage'
import Choose from '@/pages/ChoosePage'
import Detail from '@/pages/DetailPage'

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
    }
  ]
})
