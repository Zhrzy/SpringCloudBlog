# 章鱼博客

<p align=center>
  <a href="http://www.zhangyublog.cn">
    <img src="http://106.14.136.83:9090/blog/1656209324181.png" alt="章鱼博客" style="width:200px;height:200px">
  </a>
</p>
<p align=center>
   章鱼博客，一个基于微服务架构的前后端分离博客系统
</p>
<p align="center">
<a target="_blank" href="https://github.com/Zhrzy/SpringCloudBlog">
    	<img src="https://img.shields.io/hexpm/l/plug.svg" ></img>
		<img src="https://img.shields.io/badge/JDK-1.8+-green.svg" ></img>
        <img src="https://img.shields.io/badge/nodejs-14.x-green" ></img>
        <img src="https://img.shields.io/badge/springboot-2.2.2.RELEASE-green" ></img>
        <img src="https://img.shields.io/badge/SpringCloud-Hoxton.RELEASE-brightgreen" ></img>
        <img src="https://img.shields.io/badge/vue-2.5.17-green" ></img>
        <img src="https://img.shields.io/badge/swagger-3.0.0-brightgreen" ></img>
        <img src="https://img.shields.io/badge/mybatis--plus-3.1.2-green" ></img>
        <img src="https://gitee.com/moxi159753/mogu_blog_v2/badge/star.svg?theme=dark" ></img>
        <img src="https://gitee.com/moxi159753/mogu_blog_v2/badge/fork.svg?theme=dark" ></img>
</a></p>


## 前言

## 运行配置

章鱼博客使用了一些监控的 **SpringCloud** 组件，但是并不一定都需要部署，必须启动的服务包含

`nacos`，`nginx`，`rabbitmq`，`mysql`， `redis`，`blog-admin`，`blog-gateway`，`blog-mse`，`blog-picture`， `blog-web`,  `blog-searc`,  `blog-oauth `

## 站点

> 【项目地址】：http://zhangyublog.cn/
>
> 【项目管理端】：http://81.70.251.237:9527/

## 项目特点

- 实现前后端分离，通过 **Json** 进行数据交互，前端再也不用关注后端技术
- 页面交互使用 **Vue2.x**，极大的提高了开发效率。
- 引入**RabbitMQ** 和**Kafka**消息队列，用于邮件发送、更新 **Redis** 和 **ES**
- 引入**ElasticSearch** 作为全文检索服务，并支持可插拔配置
- 引入Minio对象存储，同时支持本地文件存储
- 引入 **RBAC** 权限管理设计，灵活的权限控制，按钮级别的细粒度权限控制，支持网关统一鉴权
- 采用**自定义参数校验注解**，轻松实现后端参数校验
- 采用 **AOP** + 自定义注解 + **Redis** 实现限制IP接口访问次数
- 采用 **Nacos** 作为服务发现和配置中心，轻松完成项目的配置的维护
- 采用 **Sentinel** 流量控制框架，通过配置再也不怕网站被爆破
- 支持**Markdown** 编辑器
- 采用 **ElasticStack**【**ElasticSearch** + **Beats** + **Kibana** + **Logstash**】搭建章鱼博客日志收集
- 采用 **Docker Compose** 完成容器编排，**Portainer** 实现容器可视化，支持一键部署线上环境

## 项目地址

- Github地址：https://github.com/Zhrzy/SpringCloudBlog

## 项目目录

- blog_admin: 提供admin端API接口服务；
- blog_web：提供web端API接口服务；
- blog_picture： 图片服务，用于图片上传和下载；
- blog_mse：消息服务，用于更新ElasticSearch、邮件发送
- blog_gateway：网关服务
- blog_search：搜索服务，ElasticSearch和Solr作为全文检索工具，[支持可插拔配置](http://www.moguit.cn/info/119)，默认使用SQL搜索
- blog_commons：公共模块，主要用于存放Entity实体类、Feign远程调用接口、以及公共config配置
- blog_utils: 是常用工具类；
- blog_service: 是存放 VO、Service，Dao层的
- blog_entry: 是一些Base基类
- vue_admin：VUE的后台管理页面
- vue_web：VUE的门户网站

## 技术选型

### 系统架构图



> 章鱼博客系统架构图

### 后端技术

|      技术      |           说明           |                                         官网                                         |
| :------------: | :-----------------------: | :----------------------------------------------------------------------------------: |
|   SpringBoot   |          MVC框架          |    [ https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)    |
|  SpringCloud  |        微服务框架        |                       https://spring.io/projects/spring-cloud/                       |
| SpringSecurity |      认证和授权框架      |                      https://spring.io/projects/spring-security                      |
|  MyBatis-Plus  |          ORM框架          |                               https://mp.baomidou.com/                               |
|   Swagger-UI   |       文档生产工具       | [ https://github.com/swagger-api/swagger-ui](https://github.com/swagger-api/swagger-ui) |
|     Kibana     |     分析和可视化平台     |                           https://www.elastic.co/cn/kibana                           |
| Elasticsearch |         搜索引擎         |  [ https://github.com/elastic/elasticsearch](https://github.com/elastic/elasticsearch)  |
|     Beats     |     轻量型数据采集器     |                           https://www.elastic.co/cn/beats/                           |
|    Logstash    | 用于接收Beats的数据并处理 |                          https://www.elastic.co/cn/logstash                          |
|      Solr      |         搜索引擎         |                            http://lucene.apache.org/solr/                            |
|    RabbitMQ    |         消息队列         |                 [ https://www.rabbitmq.com/](https://www.rabbitmq.com/)                 |
|     Redis     |        分布式缓存        |                                  https://redis.io/                                  |
|     Docker     |        容器化部署        |                   [ https://www.docker.com](https://www.docker.com/)                   |
|     Druid     |       数据库连接池       |          [ https://github.com/alibaba/druid](https://github.com/alibaba/druid)          |
|      JWT      |        JWT登录支持        |                             https://github.com/jwtk/jjwt                             |
|     SLF4J     |         日志框架         |                                http://www.slf4j.org/                                |
|     Lombok     |     简化对象封装工具     |    [ https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok)    |
|     Nginx     |  HTTP和反向代理web服务器  |                                  http://nginx.org/                                  |
|     Hutool     |      Java工具包类库      |                              https://hutool.cn/docs/#/                              |
| Flexmark-java |     Markdown转换Html     |                        https://github.com/vsch/flexmark-java                        |
|   Ip2region   |     离线IP地址定位库     |                      https://github.com/lionsoul2014/ip2region                      |
|     Minio     |     本地对象存储服务     |                                   https://min.io/                                   |
| Docker Compose |      Docker容器编排      |                           https://docs.docker.com/compose/                           |
|   Portainer   |     Docker可视化管理     |                        https://github.com/portainer/portainer                        |

### 前端技术

|         技术         |                  说明                  |                              官网                              |
| :-------------------: | :-------------------------------------: | :------------------------------------------------------------: |
|        Vue.js        |                前端框架                |                       https://vuejs.org/                       |
|      Vue-router      |                路由框架                |                   https://router.vuejs.org/                   |
|         Vuex         |            全局状态管理框架            |                    https://vuex.vuejs.org/                    |
|        Element        |               前端ui框架               |      [ https://element.eleme.io](https://element.eleme.io/)      |
|         Axios         |              前端HTTP框架              | [ https://github.com/axios/axios](https://github.com/axios/axios) |
|        Echarts        |                图表框架                |                       www.echartsjs.com                       |
|        Vditor        |             Markdown编辑器             |              https://github.com/Vanessa219/vditor              |
|      vue-cropper      |              图片裁剪组件              |            https://github.com/xyxiao001/vue-cropper            |
| vue-image-crop-upload |           vue图片剪裁上传组件           |       https://github.com/dai-siki/vue-image-crop-upload       |
|   vue-emoji-comment   |          Vue Emoji表情评论组件          |        https://github.com/pppercyWang/vue-emoji-comment        |
|      SortableJS      |       功能强大的JavaScript 拖拽库       |                   http://www.sortablejs.com/                   |
|   vue-side-catalog   |               目录导航栏               |         https://github.com/yaowei9363/vue-side-catalog         |
|       showdown       | 用Javascript编写的Markdown 到Html转换器 |             https://github.com/showdownjs/showdown             |
|       turndown       | 用JavaScript编写的HTML到Markdown转换器 |            https://github.com/domchristie/turndown            |

## 环境搭建

### 开发工具

|     工具     |       说明       |                                 官网                                 |
| :----------: | :---------------: | :------------------------------------------------------------------: |
|     IDEA     |    Java开发IDE    |               https://www.jetbrains.com/idea/download               |
|   WebStorm   |    前端开发IDE    |                 https://www.jetbrains.com/webstorm/                 |
| RedisDesktop |  Redis可视化工具  | [ https://redisdesktop.com/download](https://redisdesktop.com/download) |
| SwitchHosts |   本地Host管理   |                 https://oldj.github.io/SwitchHosts/                 |
|   X-shell   | Linux远程连接工具 |                   https://xshell.en.softonic.com/                   |
|    X-ftp    | Linux文件传输工具 |             https://www.netsarang.com/zh/all-downloads/             |
|    SQLyog    |  数据库连接工具  |                   https://sqlyog.en.softonic.com/                   |
|              |                  |                                                                      |

### 开发环境

|     工具     | 版本号 |                                           下载                                           |
| :-----------: | :----: | :--------------------------------------------------------------------------------------: |
|      JDK      |  1.8  |   https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html   |
|     Maven     | 3.3.0+ |                                 http://maven.apache.org/                                 |
| Elasticsearch | 6.3.0 |                             https://www.elastic.co/downloads                             |
|     Solr     |  7.0  |                              http://lucene.apache.org/solr/                              |
|     MySQL     |  5.6  |                                  https://www.mysql.com/                                  |
|    Erlang    |  20.3  |                                 https://www.erlang.org/                                 |
|   RabbitMQ   | 3.7.4 |                          http://www.rabbitmq.com/download.html                          |
|     Nginx     |  1.10  |                            http://nginx.org/en/download.html                            |
|     Redis     | 3.3.0 |                                https://redis.io/download                                |
|    Zipkin    | 2.12.5 | https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec |
|     Nacos     | 1.3.2 |                        https://github.com/alibaba/nacos/releases                        |
|   Sentinel   | 1.7.2 |                       https://github.com/alibaba/Sentinel/releases                       |

## 致谢

**章鱼博客**参考了很多**开源项目**的**解决方案**

- 感谢**杨青小姐姐**的博客模板：[http://www.yangqq.com/](http://www.yangqq.com/)
- 感谢**PanJiaChen**的Vue后台管理模板：[vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)
- Vue项目搭建参考这篇博客：[https://segmentfault.com/a/1190000009506097](https://segmentfault.com/a/1190000009506097)
- 感谢**苞米豆**提供的 **Mybatis-plus**框架：[http://mp.baomidou.com/](http://mp.baomidou.com/)
- 感谢 **bihell** 的 **Dice** 博客项目：[https://github.com/bihell/Dice](https://github.com/bihell/Dice)
- 感谢 **pppercyWang** 提供的Emoji表情评论组件：[vue-emoji-comment](https://github.com/pppercyWang/vue-emoji-comment)
- 感谢 **若依** 提供的 **RuoYi** 项目：[https://gitee.com/y_project/RuoYi](https://gitee.com/y_project/RuoYi)
- 感谢 **yaowei9363** 提供的 **Vue侧目录组件**： [vue-side-catalog](https://github.com/yaowei9363/vue-side-catalog)
- 感谢 **奇文社区** 提供的 **奇文网盘** 项目：https://gitee.com/qiwen-cloud/qiwen-file
- 感谢 **weilanwl** 提供的 **ColorUI**：https://github.com/weilanwl/ColorUI
