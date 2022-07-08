const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  roles: state => state.user.roles,
  permission_routes: state => state.permission.routes,//权限判断出的路由
  router: state => state.user.router, //后台获取的router（目录）
  iconType:state=>state.settings.iconType,
  routes:state=>state.permission.routes,
  visitedViews: state => state.tagsView.visitedViews,
  operaColumnExpand: (state) =>
  state.networkDisk.operaColumnExpand !== null
    ? Number(state.networkDisk.operaColumnExpand)
    : document.body.clientWidth > 1280
    ? 1
    : 0,
isFolder: (state) => Number(state.networkDisk.isFolder),
selectedColumnList: (state) =>
  state.networkDisk.selectedColumnList
    ? state.networkDisk.selectedColumnList.split(",")
    : ["extendName", "fileSize", "createTime"], //  列显隐
imageModel: (state) => Number(state.networkDisk.imageModel) //  图片类型页面是否展示为网格模式，0不是，1是
}
export default getters
