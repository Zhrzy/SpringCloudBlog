import request from '@/utils/request'

export function getSysConfig() {
    return request({
      url: process.env.VUE_APP_ADMIN_API+'/sysConfig/getSystemConfig',
      method: 'get'
    })
}

export function editSysConfig(params) {
    return request({
      url: process.env.VUE_APP_ADMIN_API+'/sysConfig/editSystemConfig',
      method: 'post',
      data:params
    })
}