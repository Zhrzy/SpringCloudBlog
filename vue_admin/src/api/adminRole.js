import request from '@/utils/request'
const baseUrl=process.env.VUE_APP_ADMIN_API;
const Prix=process.env.VUE_APP_ADMIN_API;
export function getAdminRoleList(params) {
  return request({
    url:  process.env.VUE_APP_ADMIN_API+'/adminRole/getList',
    method: 'get',
    params
  })
}

export function addAdminRole(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/adminRole/add',
    method: 'post',
    data: params
  })
}

export function editAdminRole(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/adminRole/edit',
    method: 'post',
    data: params
  })
}

export function deleteAdminRole(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/adminRole/delete',
    method: 'post',
    params
  })
}
