import request from '@/utils/request'

//登录认证
export function login(params) {
    return request({
      
      url: process.env.VUE_APP_ADMIN_API+'/admin/login',
      method: 'post',
      params
    })
  }

export function getInfo(token) {
    return request({
      url: process.env.VUE_APP_ADMIN_API+'/admin/getInfo',
      method: 'post',
      params: { token }
    })
}

export function getRouter() {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/getRouter',
    method: 'post'   
  })
}

export function logout() {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/logout',
    method: 'post'   
  })
}