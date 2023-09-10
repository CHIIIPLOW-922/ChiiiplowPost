import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import naive from 'naive-ui';
const app = createApp(App)

app.config.globalProperties.$axios = axios
app.use(router)
app.use(naive)
app.mount('#app')