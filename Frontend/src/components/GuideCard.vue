<script setup>
import { reactive } from "vue";
import Button from "./Button.vue";

const reveal = reactive({ value: false });
const rating = reactive({ level: Math.floor(Math.random() * 5) + 1 });

const props = defineProps({
  guide: Object,
});
</script>

<template>
  <v-card class="guide-card" max-width="336px" margin="auto">
    <div class="avatar d-flex flex-no-wrap justify-space-around align-center">
      <v-avatar size="80">
        <v-img :src="guide.photo"></v-img>
      </v-avatar>
      <div class="guide-info">
        <v-card-title class="text-h5">{{ guide.name }}</v-card-title>
        <v-card-subtitle>{{ guide.destination }}</v-card-subtitle>
        <v-card-actions>
          <Button
            class="details-btn"
            @click="reveal.value = true"
            buttonText="Ver detalles"
          ></Button>
        </v-card-actions>
        <v-rating
          v-model="rating.level"
          bg-color="orange-lighten-1"
          color="amber-darken-2"
          size="small"
        >
        </v-rating>
      </div>
    </div>
    <v-expand-transition class="expanded">
      <v-card v-if="reveal.value" class="v-card--reveal">
        <v-card-text>
          <p>{{ guide.details }}</p>
        </v-card-text>
        <v-card-actions>
          <RouterLink :to="'mailto:' + guide.email" target="_blank" class="contact-guide"
          ><Button buttonText="Contactar"></Button
            ></RouterLink>
          </v-card-actions>
          <v-card-actions class="options">
            <Button
            class="options-btn"
            @click="reveal.value = false"
            buttonText="Cerrar"
            ></Button>
            <RouterLink :to="'/guides/' + guide.id"
            ><Button class="options-btn" buttonText="Editar"></Button>
          </RouterLink>
        </v-card-actions>
      </v-card>
    </v-expand-transition>
  </v-card>
</template>

<style scoped>
.guide-card {
  margin: 2vh auto;
}

@media only screen and (min-width: 600px) {
  .avatar {
    margin-left: 1vw;
  }
}

.guide-info {
  width: 216px;
}

p {
  text-align: center;
}

.contact-guide {
  margin: auto;
}

.options {
  display: flex;
  justify-content: space-around;
}

.details-btn {
  background-color: #2d5d83;
}

.options-btn {
  background: none;
  color: black;
  background-color: white;
}

.expanded {
  background-color: var(--secondary-color);
  color: white;
  border-radius: 0;
}

</style>
