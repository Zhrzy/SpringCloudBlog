<template>
  <div class="dashboard-container">
    <h1>这是首页</h1>
    <div class="dashboard-text">token: {{ token }}</div>
    <div class="dashboard-text">name: {{ name }}</div>
    <div class="dashboard-text">roles: {{ roles }}</div>
    <div class="dashboard-text">iconType: {{ iconType }}</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
       'name'
      ,'token'
      ,'roles'
      ,'iconType'
    ])
  }
}
</script>