import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

// 定义路由
export const constantRoutes=[
    {
        path: '/login',
        component: () => import('@/view/login/index'),
        hidden: true
    },
    {
        path: '/',
        component: Layout,
        redirect: '/dashboard',
        children: [{
            path: 'dashboard',
            name: 'Dashboard',
            component: () => import('@/view/dashboard/index'),
            meta: { title: '首页', icon: 'dashboardmain',elementICon:'el-icon-s-flag' }
          }]    
    }
    // ,
    // {
    //     path: '*',
    //     component: () => import('@/view/404'),
    //     hidden: true
    // }
]

export const asyncRoutes = [   
    {
      path: '/system',
      component: Layout,
      name:'系统设置',
      redirect:'/system/systemConfig',
      meta: { title: '系统管理', icon: 'email' ,elementICon:'el-icon-setting'},
      children: [
        {
          path: 'systemConfig',
          name: 'systemConfig',
          component: () => import('@/view/system/systemConfig'),
          meta: { title: '系统管理', icon: 'email',elementICon:'el-icon-setting' }
        }, {
          path: 'aboutMe',
          name: '关于我',
          component: () => import('@/view/system/aboutMe'),
          meta: { title: '关于我', icon: 'aboutMe', elementICon:'el-icon-news'}
        },
        {
          path: 'blogLink',
          name: '友情链接',
          component: () => import('@/view/system/blogLink'),
          meta: { title: '友情链接', icon: 'blogLink' , elementICon:'el-icon-link' }
        },
        {
          path: 'sysDictType',
          name: '字典管理',
          component: () => import('@/view/system/SysDictType'),
          meta: { title: '字典管理', icon: 'web',elementICon:'el-icon-s-goods'}
        },
        {
          path: 'SysDictData',
          name: '字典数据',

          component: () => import('@/view/system/SysDictData'),
          meta: { title: '字典数据', icon: 'web', elementICon:'el-icon-moon' }
        },
        {
          path: 'webConfig',
          name: '网站配置',
          component: () => import('@/view/system/webConfig'),
          meta: { title: '网站配置', icon: 'web',elementICon:'el-icon-s-tools' }
        },
        // {
        //   path: 'systemConfig',
        //   name: '系统配置',
        //   component: () => import('@/view/system/systemConfig'),
        //   meta: { title: '系统配置', icon: 'web' }
        // },
        {
          path: 'sysParams',
          name: '参数配置',
          component: () => import('@/view/system/sysParams'),
          meta: { title: '参数配置', icon: 'web',elementICon:'el-icon-s-order'  }
        }
      ]
    },
    {
      path: '/blog',
      component: Layout,
      name:'博客管理',
      redirect:'/blog/blog',
      meta: { title: '博客管理', icon: 'email' ,elementICon:'el-icon-edit'},
      children: [
        {
          path: 'blog',
          name: 'blog',
          component: () => import('@/view/blog/blog'),
          meta: { title: '博客管理', icon: 'email',elementICon:'el-icon-document' }
        },{
          path: 'blogTag',
          name: '标签管理',
          component: () => import('@/view/blog/blogTag'),
          meta: { title: '标签管理', icon: 'email',elementICon:'el-icon-folder-opened'}
        },
        {
          path: 'blogSort',
          name: '分类管理',
          component: () => import('@/view/blog/blogSort'),
          meta: { title: '分类管理',icon: 'email',elementICon:'el-icon-folder'}
        },
        {
          path: 'blogRecommend',
          name: '推荐管理',
          component: () => import('@/view/blog/blogRecommend'),
          meta: { title: '推荐管理', icon: 'email',elementICon:'el-icon-magic-stick' }
        },
        {
          path: 'collect',
          name: '收藏管理',
          component: () => import('@/view/blog/collect'),
          meta: { title: '收藏管理', icon: 'email',elementICon:'el-icon-s-opportunity' }
        },
        {
          path: 'subject',
          name: '专题管理',
          component: () => import('@/view/blog/subject'),
          meta: { title: '专题管理', icon: 'table',elementICon:'el-icon-reading' }
        },
        {
          path: 'subjectItem',
          name: '专题元素管理',
          component: () => import('@/view/blog/subjectItem'),
          meta: { title: '专题元素管理', icon: 'table',elementICon:'el-icon-notebook-2' }
        }
      ]
    },
    {
      path: '/authority',
      component: Layout,
      redirect: '/authority/admin',
      name: '权限管理',
      meta: { title: '权限管理', icon: 'authority' ,elementICon:'el-icon-s-check'  },
      children: [
        {
          path: 'admin',
          name: '管理员管理',
          component: () => import('@/view/authority/admin'),
          meta: { title: '管理员管理', icon: 'user' ,elementICon:'el-icon-s-custom'  }
         },
        {
          path: 'role',
          name: '角色管理',
          component: () => import('@/view/authority/role'),
          meta: { title: '角色管理', icon: 'peoples' ,elementICon:'el-icon-position'  }
        },
        {
          path: 'categoryMenu',
          name: '菜单管理',
          component: () => import('@/view/authority/categoryMenu'),
          meta: { title: '菜单管理', icon: 'authority' ,elementICon:'el-icon-notebook-2' }
        }
        // {
        //   path: 'button',
        //   name: '接口管理',
        //   component: () => import('@/view/authority/api'),
        //   meta: { title: '接口管理', icon: 'authority' }
        // }
      ]
    },
    {
      path: '/user',
      component: Layout,
      redirect: '/user/user',
      name: '用户管理',
      meta: { title: '用户管理', icon: 'user1',elementICon:'el-icon-user-solid' },
      children: [
        {
          path: 'user',
          name: '用户管理',
          component: () => import('@/view/user/user'),
          meta: { title: '用户管理', icon: 'table',elementICon:'el-icon-s-custom' }
        },
        {
          path: 'visitor',
          name: '游客管理',
          component: () => import('@/view/user/visitor'),
          meta: { title: '游客管理', icon: 'table',elementICon:'el-icon-s-flag' }
        }
      ]
    },
    {
      path: '/picture',
      component: Layout,
      redirect: '/picture/pictureSort',
      name: '图片管理',
      meta: { title: '图片管理', icon: 'example',elementICon:'el-icon-picture' },
      children: [
        {
          path: 'pictureSort',
          name: '图片类别管理',
          component: () => import('@/view/picture/pictureSort'),
          meta: { title: '图片类别管理1', icon: 'picture',elementICon:'el-icon-picture-outline' }
        },
        {
          path: 'picture',
          name: '图片管理',
   
          component: () => import('@/view/picture/picture'),
          meta: { title: '图片管理', icon: 'picture',elementICon:'el-icon-picture-outline-round' }
        }
      ]
    },
    {
      path: '/log',
      component: Layout,
      redirect: '/log/log',
      name: '操作日志',
      meta: { title: '操作日志', icon: 'log' ,elementICon:'el-icon-s-claim'},
      children: [
        {
          path: 'log',
          name: '操作日志',
          component: () => import('@/view/log/log'),
          meta: { title: '操作日志', icon: 'log' ,elementICon:'el-icon-s-claim'}
        },
        {
          path: 'exceptionLog',
          name: '异常日志',
          component: () => import('@/view/log/exceptionLog'),
          meta: { title: '异常日志', icon: 'exception' ,elementICon:'el-icon-lightning'}
        },
        {
          path: 'webVisit',
          name: '用户日志',
          component: () => import('@/view/log/webVisit'),
          meta: { title: '用户日志', icon: 'user1',elementICon:'el-icon-sunrise' }
        }
      ]
    },
    {
      path: '/message',
      component: Layout,
      redirect: '/message/comment',
      name: '消息管理',
      meta: { title: '消息管理', icon: 'message1',elementICon:'el-icon-message-solid' },
      children: [
        {
          path: 'comment',
          name: '评论管理',
          component: () => import('@/view/message/comment'),
          meta: { title: '评论管理', icon: 'table' ,elementICon:'el-icon-message-solid'}
        },
        {
          path: 'feedback',
          name: '反馈管理',
          component: () => import('@/view/message/feedback'),
          meta: { title: '反馈管理', icon: 'table',elementICon:'el-icon-s-comment' }
        }
      ]
    },
    {
      path: '/web',
      component: Layout,
      redirect: '/web/webNavbar',
      name: '门户管理',
      meta: { title: '门户管理', icon: 'user1',elementICon:'el-icon-s-home' },
      children: [
        {
          path: 'webNavbar',
          name: '导航栏管理',
          component: () => import('@/view/web/webNavbar'),
          meta: { title: '导航栏管理', icon: 'table',elementICon:'el-icon-s-flag' }
        }
      ]
    },
    {
      path: '/resource',
      component: Layout,
      redirect: '/resource/resourceSort',
      name: '资源管理',
      meta: { title: '资源管理', icon: 'resource',elementICon:'el-icon-attract' },
      children: [
        {
          path: 'file',
          name: '网盘管理',
          component: () => import('@/view/resource/file/File'),
          meta: { title: '网盘管理', icon: 'table' ,elementICon:'el-icon-present'}
        },
        {
          path: 'resourceSort',
          name: '分类管理',
          component: () => import('@/view/resource/resourceSort'),
          meta: { title: '分类管理', icon: 'table',elementICon:'el-icon-soccer' }
        },
        {
          path: 'studyVideo',
          name: '视频管理',
          component: () => import('@/view/resource/studyVideo'),
          meta: { title: '视频管理', icon: 'table',elementICon:'el-icon-video-camera-solid' }
        }
      ]
    },

    


  ]

const createRouter = () => new Router({
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
  })

const router = createRouter()

export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
  }
export default router