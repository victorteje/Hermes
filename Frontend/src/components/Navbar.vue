<script>
import { RouterLink, RouterView } from "vue-router";

export default {
  data: () => ({
    items: [{ title: "Lorem ipsum" }, { title: "Cerrar sesión" }],
  }),
};
</script>

<template>
  <v-toolbar color="#FF9B00" height="56">
    <RouterLink to="/home"
      ><img src="../../images/logo-navbar.png" class="nav-logo"
    /></RouterLink>
    <v-spacer></v-spacer>
    <v-menu>
      <template v-slot:activator="{ props }">
        <v-btn
          color="white"
          v-bind="props"
          class="user-menu material-symbols-outlined"
        >
          <img src="../../images/hermes-user.svg" alt="Menú de usuario" />
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in items" :key="index" :value="index">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-toolbar>
  <RouterView />
</template>

<style scoped>
.nav-logo {
  margin-left: 5vw;
  margin-top: 1vh;
}
</style>
