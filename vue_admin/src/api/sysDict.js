import request from '@/utils/request'

export function getDict(params) {
    return request({
      url: process.env.VUE_APP_ADMIN_API+'/dictData/getDictByTypes',
      method: 'post',
      data: params
    })
}