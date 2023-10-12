<script setup></script>

<template>
  <footer>
    <v-carousel cycle hide-delimiters height="384px">
      <v-carousel-item src="../../images/santiago.jpg" cover>
        <div>
          <p>Santiago de Compostela</p>
        </div>
      </v-carousel-item>

      <v-carousel-item src="../../images/gijon.jpg" cover>
        <p>Gijón</p>
      </v-carousel-item>

      <v-carousel-item src="../../images/segovia.png" cover>
        <p>Segovia</p>
      </v-carousel-item>
    </v-carousel>
  </footer>
</template>

<style scoped>
footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}

p {
  color: white;
  text-align: center;
  font-size: x-large;
  background-color: rgb(0, 0, 0, 0.5);
}
</style>
