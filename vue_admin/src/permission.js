//导航守卫
import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-title'


NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['/login'] // no redirect whitelist

router.beforeEach(async(to, from, next) => {
  // start progress bar
  NProgress.start()

  // set page title
  document.title = getPageTitle(to.meta.title)

  // determine whether the user has logged in
  const hasToken = getToken()
  if (hasToken) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({ path: '/' })
      NProgress.done()
      next()
    } else {
      const hasGetUserInfo =store.getters.name
      if (hasGetUserInfo) {        
        next()
      } else {
        try {
          // 获取用户信息
          await store.dispatch('user/getInfo')       
          await store.dispatch('user/getRouter')
          await store.dispatch('settings/getIconType')
          const routerPath = await store.dispatch('permission/getRouterPathArray',store.getters.router)          
          //var route = ['/test','/test/test1','/tpage','/tpage/tpage1','/tpage/tpage2']
          const accessRoutes = await store.dispatch('permission/generateRoutes', routerPath)
          localStorage.setItem("rou",accessRoutes)
          router.addRoutes(accessRoutes)
          next({ ...to, replace: true })
        } catch (error) {
          // remove token and go to login page to re-login
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* 无token*/
    if (whiteList.indexOf(to.path) !== -1) {    
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      //其他页面需要权限才能进入，如果to.path不在白名单在就重定向到登录页
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
})
