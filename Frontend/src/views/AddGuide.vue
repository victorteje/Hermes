<script setup>
import Navbar from "../components/Navbar.vue";
import Button from "../components/Button.vue";
import GuideDataService from "../services/GuideDataService";
import { reactive } from "vue";

const guide = reactive({
  id: null,
  name: "",
  destination: "",
  details: "",
  email: "",
  photo: "",
});

function addNewGuide() {
  let data = {
    name: guide.name,
    destination: guide.destination,
    details: guide.details,
    email: guide.email,
    photo: guide.photo,
  };

  GuideDataService.create(data)
    .then((response) => {
      guide.id = response.data.id;
      console.log(response.data);
    })
    .catch((e) => {
      console.log(e);
    });
}
</script>

<template>
  <body>
    <Navbar />
    <v-form v-model="valid">
      <h3>Nuevo guía</h3>
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
              buttonText="Añadir"
              @click="addNewGuide"
              type="submit"
            ></Button
          ></RouterLink>
          <RouterLink to="/guides"
            ><Button buttonText="Cancelar"></Button
          ></RouterLink>
        </div>
      </v-container>
    </v-form>
  </body>
</template>

<style scoped>
body {
  background-color: lightblue;
  background-attachment: fixed;
  height: 100vh;
}

h3 {
  text-align: center;
  margin: 2vh 0;
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
</style>
