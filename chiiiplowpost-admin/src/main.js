import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import naive from 'naive-ui'
import axios from 'axios'
import VueParticles from 'vue-particles'
const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(naive)
app.use(router)
app.use(VueParticles)

app.mount('#app')
