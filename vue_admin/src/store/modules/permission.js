import { asyncRoutes, constantRoutes } from '@/router'
//判断权限获取路由
/**
 * 
 * Use meta.role to determine if the current user has permission
 * @param roles
 * @param route
 */
// function hasPermission(roles, route) {
//   if (route.meta && route.meta.roles) {
//     return roles.some(role => route.meta.roles.includes(role))
//   } else {
//     return true
//   }
// }

function hasPath(list,route){
  for( var i=0;i<list.length;i++){
    if(route.path == list[i]+'' || route.path == list[i].substr(list[i].lastIndexOf('/')+1,list[i].length-list[i].lastIndexOf('/')-1)+'')
    {     
      return true
    }
  }
  return false
}

/**
 * Filter asynchronous routing tables by recursion
 * @param routes asyncRoutes
 * @param roles
 */
export function filterAsyncRoutes(routes, list) {
  const res = []
  routes.forEach(route=>{
    const tmp = { ...route }
    if(hasPath(list,tmp)){
      if(tmp.children){
        tmp.children=filterAsyncRoutes(tmp.children,list);
      } 
     res.push(tmp)
    }
  })
  return res 

//可用
  // const res = []
  // //
  // routes.forEach(route => {
  //   const tmp = { ...route }
  //   if (hasPermission(roles, tmp)) {
  //     if (tmp.children) {
  //       tmp.children = filterAsyncRoutes(tmp.children, roles)
  //     }
  //     res.push(tmp)
  //   }
  // })
  // //
  // return res
}

const state = {
  routes: [],
  addRoutes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.addRoutes = routes
    state.routes = constantRoutes.concat(routes)
  }
}

const actions = {
  generateRoutes({ commit }, roles) {
    return new Promise(resolve => {
      let accessedRoutes
      accessedRoutes = filterAsyncRoutes(asyncRoutes, roles)
      // if (roles.includes('admin')) {    
      //   accessedRoutes = asyncRoutes || []
      // } else {      
      // accessedRoutes = filterAsyncRoutes(asyncRoutes, roles)
      // }
      commit('SET_ROUTES', accessedRoutes)
      resolve(accessedRoutes)
    })
  },
  //获取vuex存储的store相关的数据，将其url遍历为一个数组
  getRouterPathArray({ commit },router){
    const routerPath = []
    return new Promise(resolve =>{    
     commit('SET_ROUTES', '1')
      if(router.length == 0){     
        resolve(routerPath)
      }
      router.forEach(r=>{
        routerPath.push(r.url)
      })
      resolve(routerPath)
    })
  } 
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
