import { login, logout, getInfo, getRouter } from '@/api/oauth'
import { getToken, setToken, removeToken } from '@/utils/auth'

import { resetRouter } from '@/router'
//本module用户用户状态管理 vuex实现

//状态定义
const getDefaultState = () => {
    return {
      token: getToken(),
      name: '',
      avatar: '',
      roles: [],
      router:'',
    }
}
const state =getDefaultState();
//定义状态修改mutations
const mutations={
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  },
  SET_ROUTER:(state,router) =>{
    state.router = router
  }
}

//定义actions 可以是异步操作
const actions ={
    Login({ commit }, user) {
         const username = user.username.trim()  
         const password = user.password.trim() 
         return new Promise((resolve, reject) => {
           var params = new URLSearchParams()
             params.append('username', username)
             params.append('password', password)
           login(params).then(response => {
             const { data } = response 
             commit('SET_TOKEN', data.access_token) //调用mutation设置token，存入store
             setToken(data.access_token)  //cookie设置token
             resolve()
           }).catch(error => {
             reject(error)
           })
         })
    },
    //获取用户可访问的路由（菜单）
  getRouter({ commit }){
    return new Promise((resolve, reject)=>{
      getRouter().then(response => {
        const { data } = response      
        console.log(response)
        commit('SET_ROUTER',data.routers)
        resolve()
      }).catch(error=>{
        reject(error)
      })
    })
  },

  // get user info
  getInfo({ commit, state }) {
     return new Promise((resolve, reject) => {
     getInfo(state.token).then(response => {
        const { data } = response
        if (!data) {
          reject('Verification failed, please Login again.')
        }       
        const { name, avatar, roles} = data
        commit('SET_ROLES',roles)
        commit('SET_NAME', name)
        commit('SET_AVATAR', avatar)
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {     
        commit('SET_TOKEN','')        
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken() // must remove  token  first
      commit('RESET_STATE')
      resolve()
    })
  }

}


export default {
    namespaced: true,//使用命名空间
    state,
    mutations,
    actions
}