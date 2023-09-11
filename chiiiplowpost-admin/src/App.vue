<template>
  <div id="app">
    <n-message-provider>
    <MessageApi />
  </n-message-provider>
    <router-view />
  </div>
</template>

<script>
import { NMessageProvider } from "naive-ui";
import MessageApi from "./components/MessageApi.vue";
export default {
  components: { MessageApi, NMessageProvider },
  name: "App",
  setup(props) {}
}
</script>
<style scoped>
html,
body {
  width: 100%;
  height: 100%;
  box-sizing: border-box;
  padding: 0px;
  margin: 0px;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  widows: 100%;
  height: 100%;
}
</style>
