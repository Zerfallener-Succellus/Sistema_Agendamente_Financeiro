import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from '../views/login_page.vue';
import RegisterPage from '../views/register_page.vue';
import UserProfile from '../components/userProfile.vue';

const routes = [
  { path: '/login', component: LoginPage },
  { path: '/register', component: RegisterPage },
  { path: '/profile', component: UserProfile, meta: { requiresAuth: true } },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !localStorage.getItem('auth-token')) {
    next('/login');
  } else {
    next();
  }
});

export default router;
