import { createRouter, createWebHistory } from 'vue-router'
import backLogin from '../back/login/backLogin.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'backLogin',
      component: backLogin
    }
  ]
})

export default router
