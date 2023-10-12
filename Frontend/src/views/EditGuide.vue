<script setup>
import Navbar from "../components/Navbar.vue";
import Button from "../components/Button.vue";
import GuideDataService from "../services/GuideDataService";
import { ref, onBeforeMount } from "vue";
import { useRoute } from "vue-router";

const guide = ref();
const route = useRoute();

function getGuideByid(id) {
  GuideDataService.get(id).then((response) => {
    guide.value = response.data;
  });
}

function updateGuide() {
  GuideDataService.update(guide.value.id, guide.value);
}

function deleteGuide() {
  GuideDataService.delete(guide.value.id);
}

onBeforeMount(() => {
  getGuideByid(route.params.id);
});
</script>

<template>
  <Navbar />
  <div v-if="guide">
    <v-form v-model="valid">
      <h3>Editar / borrar guía</h3>
      <v-container>
        <v-row class="edit-fields">
          <v-col cols="12" md="4">
            <v-text-field
              bg-color="white"
              v-model="guide.name"
              :rules="nameRules"
              :counter="10"
              label="Nombre"
              required
              hide-details
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-select
              bg-color="white"
              v-model="guide.destination"
              :rules="nameRules"
              :counter="10"
              label="Destino"
              hide-details
              required
              :items="[
                'Bilbao',
                'Gijón',
                'Madrid',
                'Santiago de Compostela',
                'Segovia',
                'Valencia',
              ]"
            ></v-select>
          </v-col>

          <v-col cols="12" md="4">
            <v-textarea
              bg-color="white"
              v-model="guide.details"
              :rules="nameRules"
              label="Detalles"
              hide-details
              required
            ></v-textarea>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field
              bg-color="white"
              v-model="guide.email"
              :rules="emailRules"
              label="E-mail"
              hide-details
              required
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field
              bg-color="white"
              v-model="guide.photo"
              :rules="nameRules"
              label="URL foto"
              hide-details
              required
            ></v-text-field>
          </v-col>
        </v-row>
        <div class="button-section">
          <RouterLink to="/guides"
            ><Button
              buttonText="Actualizar"
              @click="updateGuide"
              type="submit"
              class="update-btn"
            ></Button
          ></RouterLink>
          <RouterLink to="/guides"
            ><Button
              buttonText="Borrar"
              @click="deleteGuide"
              type="submit"
              class="delete-btn"
            ></Button
          ></RouterLink>
          <RouterLink to="/guides"
            ><Button buttonText="Cancelar"></Button
          ></RouterLink>
        </div>
      </v-container>
    </v-form>
  </div>
</template>

<style scoped>
h3 {
  text-align: center;
  margin-top: 2vh;
  color: white;
}

form {
  width: 90%;
  margin: 5vh auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  background-color: rgba(0, 0, 0, 0.4);
  backdrop-filter: blur(1px);
  border-radius: 8px;
}

.edit-fields {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 8px;
}

.button-section {
  margin-top: 8vh;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 8vw;
}

.update-btn {
  background-color: green;
}

.delete-btn {
  background-color: red;
}
</style>
