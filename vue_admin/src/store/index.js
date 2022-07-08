import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import app from './modules/app'
import settings from './modules/settings'
import permission from './modules/permission' //导入permission
import getters from './getters'
import tagsView from './modules/tagsView'
import networkDisk from "./modules/networkDisk";
//import createPersistedState from "vuex-persistedstate" //vuex持久化插件
Vue.use(Vuex)
const store = new Vuex.Store({
    modules:{
        app,
        user,
        settings,
        permission,
        tagsView,
        networkDisk
    },
    getters
    //vuex缓存插件
    // plugins: [createPersistedState({
    //     paths:['user','permission']
    // })]
})

export default store