'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

   VUE_BLOG_WEB: '"http://localhost:9527"',
   PICTURE_API: '"http://localhost:8080/picture"',
	 WEB_API: '"http://localhost:8080/web"',
   SEARCH_API: '"http://localhost:8080/search"',

  // VUE_BLOG_WEB: '"http://81.70.251.*:9527"',
  // PICTURE_API: '"http://81.70.251.*:8080/picture"',
	// WEB_API: '"http://81.70.251.*:8080/web"',
  // SEARCH_API: '"http://81.70.251.*:8080/search"',

})
