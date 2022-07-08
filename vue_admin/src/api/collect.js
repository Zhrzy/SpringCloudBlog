import request from '@/utils/request'

export function getList(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/collect/getList',
    method: 'get',
    params
  })
}
