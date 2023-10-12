<script setup>
import Button from "./Button.vue";
</script>

<template>
  <main>
    <h3>¡Bienvenid@ a Hermes!</h3>
    <RouterLink to="/guides"
      ><Button button-text="Buscar guía"></Button
    ></RouterLink>
  </main>
</template>

<style scoped>
main {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  height: 227px;
  background-image: url("../../images/hermes-god.webp");
  width: 100%;
  background-repeat: no-repeat;
  background-size: cover;
}

button {
  font-weight: bold;
}

h3 {
  font-size: 1.2rem;
  color: white;
  align-self: flex-end;
  margin-right: 4vw;
}
</style>
