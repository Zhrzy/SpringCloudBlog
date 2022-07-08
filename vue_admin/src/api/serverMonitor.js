import request from '@/utils/request'
const baseUrl=process.env.VUE_APP_ADMIN_API;
const Prix=process.env.VUE_APP_ADMIN_API;
export function getServerInfo(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+ '/monitor/getServerInfo',
    method: 'get',
    params
  })
}
