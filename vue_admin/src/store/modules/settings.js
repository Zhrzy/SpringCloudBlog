import defaultSettings from '@/settings'
import {getSysConfig} from '@/api/sysConfig'

const { showSettings, fixedHeader, sidebarLogo } = defaultSettings

const state = {
  showSettings: showSettings,
  fixedHeader: fixedHeader,
  sidebarLogo: sidebarLogo,
  iconType: '1'
}

const mutations = {
  // CHANGE_SETTING: (state, { key, value }) => {
  //   if (state.hasOwnProperty(key)) {
  //     state[key] = value
  //   }
  // }
  CHANGE_ICONTYPE:(state,icon)=>{
    state.iconType=icon
  },
  SET_ICONTYPE:(state,icon)=>{
    state.iconType=icon
  }
}

const actions = {
  changeSetting({ commit }, data) {
    commit('CHANGE_SETTING', data)
  },
  //设置icon类型
  changeIconType({ commit },data){
    commit('CHANGE_ICONTYPE',data)
  }
  //获取系统配置
  ,getIconType({commit}){
    return new Promise((resolve,reject)=>{
      getSysConfig().then(response => {
          const data =response.data
          commit('SET_ICONTYPE',data.iconType)
          resolve();
      }).catch(error => {
        reject(error)
      })
    })
  }

}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

