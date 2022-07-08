import request from '@/utils/request'

export function cropperPicture(params) {
  return request({
    url: process.env.VUE_APP_PICTURE_API + '/file/cropperPicture',
    method: 'POST',
    data: params
  })
}
