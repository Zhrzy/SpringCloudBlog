import Vue from 'vue'
import ElementUI from 'element-ui';//引入element-ui
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import locale from 'element-ui/lib/locale/lang/en'
import router from './router' //路由
import store from './store'   //vuex状态管理器
import prototype from './utils/prototype'
import '@/style/index.scss'   // global css全局样式
import '@/permission' // permission control
import '@/icons' // icon

import xss from 'xss'
// 定义全局XSS解决方法
Object.defineProperty(Vue.prototype, '$xss', {
  value: xss
})
Vue.use(ElementUI, { locale })
Vue.use(prototype)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
