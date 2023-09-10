import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import naive from 'naive-ui'
import axios from 'axios'
import Particles from 'particles.vue3'
const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(naive)
app.use(router)
app.use(Particles)

app.mount('#app')
