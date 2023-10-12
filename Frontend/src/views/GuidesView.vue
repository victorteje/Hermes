<script setup>
import Navbar from "../components/Navbar.vue";
import GuideCard from "../components/GuideCard.vue";
import GuideDataService from "../services/GuideDataService";
import { ref, onBeforeMount } from "vue";
import Button from "../components/Button.vue";

const guides = ref();

function getGuides() {
  GuideDataService.getAll()
    .then((response) => {
      guides.value = response.data;
      console.log(response.data);
    })
    .catch((e) => {
      console.log(e);
    });
}

function getGuideByDestination() {
  const destination = document.getElementById("search-destination").value;
  GuideDataService.getByDestination(destination).then((response) => {
    guides.value = response.data;
    console.log(destination);
  });
}

onBeforeMount(() => {
  getGuides();
});
</script>

<template>
  <Navbar />

  <v-form class="search-form">
    <div class="search-options">
      <v-select
        bg-color="white"
        id="search-destination"
        class="search-field"
        label="Destino"
        :items="[
          'Bilbao',
          'Gijón',
          'Madrid',
          'Santiago de Compostela',
          'Segovia',
          'Valencia',
        ]"
      ></v-select>

      <!-- 
            <v-select
            bg-color="white"
            class="search-field"
            label="Categoría"
            :items="['Aventura', 'Cultura', 'Gastronomía', 'Senderismo', 'Otros']"
            >
            /v-select> -->
    </div>
    <div class="button-section">
      <RouterLink to="/guides"
        ><Button
          buttonText="Buscar"
          type="submit"
          @click="getGuideByDestination"
        ></Button>
      </RouterLink>
      <RouterLink to="/add-guide"
        ><Button buttonText="Nuevo guía"></Button
      ></RouterLink>
    </div>
  </v-form>

  <ul>
    <li v-for="(guide, index) in guides" :key="index">
      <GuideCard :guide="guide" />
    </li>
  </ul>
</template>

<style scoped>
.search-form {
  margin: 24px auto;
  width: 90%;
}

.search-options {
  display: flex;
  gap: 24px;
  margin: 0 3vw;
}

.search-field {
  margin: auto;
  backdrop-filter: blur(0.5px);
}

.button-section {
  display: flex;
  flex-direction: column;
  margin: auto;
  width: 128px;
  gap: 24px;
}

button {
  background-color: var(--primary-color);
  color: white;
  backdrop-filter: blur(1px);
}

@media only screen and (min-width: 800px) {
  ul {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 2vh;
    width: 88vh;
    margin: auto;
  }
}

li {
  list-style-type: none;
}
</style>
