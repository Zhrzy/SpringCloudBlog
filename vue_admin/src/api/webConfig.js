import request from '@/utils/request'

export function getWebConfig(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/webConfig/getWebConfig',
    method: 'get',
    params
  })
}

export function editWebConfig(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/webConfig/editWebConfig',
    method: 'post',
    data: params
  })
}
