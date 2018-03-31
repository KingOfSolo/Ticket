import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/pages/user/Main'
import Home from '@/pages/user/HomePage'
import Choose from '@/pages/user/ChoosePage'
import Detail from '@/pages/user/DetailPage'
import User from '@/pages/user/UserPage'
import OrderConfirm from '@/pages/user/OrderConfirm'
import OrderPay from '@/pages/user/OrderPay'
import OrderSuccess from '@/pages/user/OrderSuccess'

import Login from '@/pages/venue/SignIn'
import SignUp from '@/pages/venue/SignUp'
import Venue from '@/pages/venue/Venue'

import TicketLogin from '@/pages/tickets/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Main',
      name: 'Main',
      component: Main,
      children: [
        {
          path: '/Home',
          name: 'Home',
          component: Home
        },
        {
          path: '/Choose/:type',
          name:'Choose',
          component:Choose
        },
        {
          path: '/Detail/:id',
          name: 'Detail',
          component:Detail
        },
        {
          path: '/OrderConfirm',
          name: 'OrderConfirm',
          component:OrderConfirm
        },
        {
          path: '/OrderPay/:number',
          name: 'OrderPay',
          component: OrderPay
        },
        {
          path: '/OrderSuccess/:id',
          name: 'OrderSuccess',
          component:OrderSuccess
        },
        {
          path: '/User/:userId',
          name: 'User',
          component:User
        }
      ]
    },
    {
      path: '/Login',
      name: 'Login',
      component:Login
    },
    {
      path: '/SignUp',
      name: 'SignUp',
      component:SignUp
    },
    {
      path: '/Venue/:venueId',
      name: "Venue",
      component:Venue
    },
    {
      path: '/TicketLogin',
      name: 'TicketLogin',
      component:TicketLogin
    }
  ]
})
