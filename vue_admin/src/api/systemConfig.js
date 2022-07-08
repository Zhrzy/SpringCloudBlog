import request from '@/utils/request'

export function getSystemConfig(params) {
  return request({
    url:  process.env.VUE_APP_ADMIN_API+'/sysConfig/getSystemConfig',
    method: 'get',
    params
  })
}

export function cleanRedisByKey(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/sysConfig/cleanRedisByKey',
    method: 'post',
    data: params
  })
}

export function editSystemConfig(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/sysConfig/editSystemConfig',
    method: 'post',
    data: params
  })
}
