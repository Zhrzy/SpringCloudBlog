import axios from 'axios'
import router from '@/router/index'
import {getCookie} from "@/utils/cookieUtils";
// 创建axios实例
const service = axios.create({
  baseURL: '', // api 的 base_url
  timeout: 20000 // 请求超时时间 10秒
})

service.defaults.headers.common['Authorization'] = getCookie("token")

// request拦截器
service.interceptors.request.use(
  config => {
    if (getCookie("token") != undefined) {
      config.headers['Authorization']  = getCookie("token") // 让每个请求携带自定义token 请根据实际情况自行修改
    }
    return config
  },
  error => {
    // Do something with request error
    console.log(error) // for debug
    Promise.reject(error)
  }
)


// response 拦截器
service.interceptors.response.use(
  response => {
    // return response.data
    // const res = response.data
    // if (res.code === 'success' || res.code === 'error') {
    //   return res
    // } else if (res.code === 401 || res.code === 400) {
    //   console.log('返回错误内容', res)
    //   router.push('404')
    //   return res
    // } else if (res.code === 500) {
    //   router.push('500')
    //   return Promise.reject('error')
    // } else if (res.code === 502) {
    //   router.push('502')
    //   return Promise.reject('error')
    // } else {
    //   // return Promise.reject('error')
    // }
    const res = response.data
    if (res.code === 'success' ) {
      return response.data
    }
    else if(res.code === '1004'){
      MessageBox.confirm(
        'token已过期，可以取消继续留在该页面，或者重新登录',
        '确定登出',
        {
          confirmButtonText: '重新登录',
          cancelButtonText: '取消',
          type: 'warning'
        }
      ).then(() => {
          store.dispatch('FedLogOut').then(() => {
            location.reload() // 为了重新实例化vue-router对象 避免bug
          })
        })
    }
    else{
      Message({
          message: res.message || 'Error',
          type: 'error',
          duration: 5 * 1000
         })
    }
  },
  error => {
    // 出现网络超时
    // router.push('500')
    // return Promise.reject(error)
    console.log('err' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
