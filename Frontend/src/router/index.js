import { createRouter, createWebHistory } from "vue-router";
import LoginView from "../views/LoginView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "login",
      component: LoginView,
    },

    {
      path: "/home",
      name: "home",
      component: () => import("../views/HomeView.vue"),
    },

    {
      path: "/guides",
      name: "guides",
      component: () => import("../views/GuidesView.vue"),
    },

    {
      path: "/add-guide",
      name: "add-guide",
      component: () => import("../views/AddGuide.vue"),
    },

    {
      path: "/guides/:id",
      name: "edit-guide",
      component: () => import("../views/EditGuide.vue"),
    },
  ],
});

export default router;
