import request from '@/utils/request'

export function getBlogList(params) {
    return request({
      url:  process.env.VUE_APP_ADMIN_API+'/blog/getBlogList',
      method: 'post',
      data:params
    })
}

// other

/**
 * 获取管理员列表
 * @param params
 */
 export function getAdminList(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/getList',
    method: 'post',
    data: params
  })
}

export function addAdmin(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/add',
    method: 'post',
    data: params
  })
}

export function editAdmin(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/edit',
    method: 'post',
    data: params
  })
}

export function deleteAdmin(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/delete',
    method: 'post',
    data: params
  })
}

export function restPwdAdmin(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/restPwd',
    method: 'post',
    data: params
  })
}

/**
 * 获取在线的管理员列表
 * @param params
 */
export function getOnlineAdminList(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/getOnlineAdminList',
    method: 'post',
    data: params
  })
}

/**
 * 强退用户
 * @param params
 */
export function forceLogout(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/admin/forceLogout',
    method: 'post',
    data: params
  })
}