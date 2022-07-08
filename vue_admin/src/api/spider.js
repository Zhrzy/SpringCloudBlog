import request from '@/utils/request'

export function pictureSpider(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/spider/spiderPicture',
    method: 'post',
    data: params
  })
}

