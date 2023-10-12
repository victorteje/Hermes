<script setup>
defineProps({
  buttonText: {
    type: String,
  },
});
</script>

<template>
  <v-btn width="128px">
    <p>{{ buttonText }}</p>
  </v-btn>
</template>

<style scoped>
button {
  background-color: #ff8f00;
  color: white;
}
</style>
