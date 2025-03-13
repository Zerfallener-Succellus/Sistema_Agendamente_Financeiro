import { createApp } from 'vue';
import App from './app.vue';
import './assets/global.css'
import router from './assets/router/index'; 

const app = createApp(App);
app.use(router); 
app.mount('#app');
