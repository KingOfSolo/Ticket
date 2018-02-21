import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/pages/user/Main'
import Home from '@/pages/user/HomePage'
import Choose from '@/pages/user/ChoosePage'
import Detail from '@/pages/user/DetailPage'
import User from '@/pages/user/UserPage'

import Login from '@/pages/venue/SignIn'
import SignUp from '@/pages/venue/SignUp'
import Venue from '@/pages/venue/Venue'

import TicketLogin from '@/pages/tickets/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main,
      children: [
        {
          path: '/Home',
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
