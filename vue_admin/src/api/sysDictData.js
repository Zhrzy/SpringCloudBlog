import request from '@/utils/request'

export function getSysDictDataList(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/dictData/getList',
    method: 'post',
    data: params
  })
}

export function getListByDictType(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/dictData/getListByDictType',
    method: 'post',
    params
  })
}

export function getListByDictTypeList(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/dictData/getListByDictTypeList',
    method: 'post',
    data: params
  })
}

export function addSysDictData(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/dictData/add',
    method: 'post',
    data: params
  })
}

export function editSysDictData(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/dictData/edit',
    method: 'post',
    data: params
  })
}

export function deleteBatchSysDictData(params) {
  return request({
    url: process.env.VUE_APP_ADMIN_API+'/dictData/deleteBatch',
    method: 'post',
    data: params
  })
}
