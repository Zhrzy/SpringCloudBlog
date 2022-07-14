<template>
  <div class="app-container">
    <!-- 查询和其他操作 -->
    <div class="filter-container" style="margin: 1px 0 1px 0;">
      <p>ELK日志监控中心</p>
    </div>
    <iframe src="http://123.60.208.195:5601/app/kibana#/dashboard/463d74f0-fbc3-11ec-913e-8b7a7ccd7073?embed=true&_g=(refreshInterval%3A(pause%3A!t%2Cvalue%3A0)%2Ctime%3A(from%3Anow-7d%2Cto%3Anow))" 
             height="700px" width="100%"></iframe> 
  </div>
</template>


<script>


  export default {
    data() {
      return {
        elasticSearchServiceUrl:  'http://123.60.208.195:5601/app/kibana#/dashboard/463d74f0-fbc3-11ec-913e-8b7a7ccd7073?embed=true&_g=(refreshInterval%3A(pause%3A!t%2Cvalue%3A0)%2Ctime%3A(from%3Anow-7d%2Cto%3Anow))'
      };
    },

    created() {
        
    }    
  };
</script>
