import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Layout from '../layout/Layout.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: '',
      component: Layout,
      redirect: '/user',
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/user',
          name: 'user',
          meta: {
            requireAuth: true
          },
          component: () => import('../views/PostUserManager.vue')
        },
        {
          path: '/post',
          name: 'post',
          meta: {
            requireAuth: true
          },
          component: () => import('../views/PostManager.vue')
        },
        {
          path: '/comment',
          name: 'comment',
          meta: {
            requireAuth: true
          },
          component: () => import('../views/PostComment.vue')
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      meta: {
        requireAuth: false
      },
      component: Login
    },

  ]
})
router.beforeEach((to, from, next) => {
  if (to.matched.length != 0) {
    if (to.meta.requireAuth) { // 判断该路由是否需要登录权限
        if ((window.localStorage.getItem("admin"))!==null) { // 通过vuex state获取当前的user是否存在
            next();
        } else {
            next({
                path: '/login',
                query: { redirect: to.fullPath } // 将跳转的路由path作为参数，登录成功后跳转到该路由
            })
        }
    } else {
        if ((window.localStorage.getItem("admin"))!==null) { // 判断是否登录
            if (to.path != "/" && to.path != "/login") { //判断是否要跳到登录界面
                next();
            } else {
                /**
                 * 防刷新，如果登录，修改路由跳转到登录页面，修改路由为登录后的首页 
                 */
                next({
                    path: '/user'
                })
            }
        } else {
            next();
        }
    }
} else {
    next({
        path: '/login',
        query: { redirect: to.fullPath } // 将跳转的路由path作为参数，登录成功后跳转到该路由
    })
}
})

export default router
