<script>
import { RouterLink, RouterView } from "vue-router";
import Button from "../components/Button.vue";

export default {
  data: () => ({
    tab: null,
  }),
  components: { Button },
};
</script>

<template>
  <body>
    <main>
      <img id="main-logo" src="../../images/main-logo.png" alt="Hermes logo" />
      <p id="slogan">
        Tu guía turístico ideal, a un toque de distancia: Hermes es tu pasaporte
        a un viaje inolvidable.
      </p>
      <v-card id="form-section">
        <v-tabs
          v-model="tab"
          bg-color="amber-darken-2"
          color="white"
          fixed-tabs
        >
          <v-tab value="login">Login</v-tab>
          <v-tab value="register">Registro</v-tab>
        </v-tabs>

        <v-card-text>
          <v-window v-model="tab">
            <v-window-item value="login">
              <form class="login-form">
                <div class="input-container">
                  <v-text-field
                    class="login-input"
                    label="Email"
                    variant="underlined"
                    type="email"
                  ></v-text-field>
                  <v-text-field
                    class="login-input"
                    label="Contraseña"
                    variant="underlined"
                    type="password"
                  ></v-text-field>
                </div>
                <div class="button-container">
                  <RouterLink to="/home"
                    ><Button
                      buttonText="Entrar"
                      class="btn form-button"
                    ></Button
                  ></RouterLink>
                </div>
              </form>
            </v-window-item>

            <v-window-item value="register">
              <form class="register-form">
                <div class="input-container">
                  <v-text-field
                    class="login-input"
                    label="Email"
                    variant="underlined"
                    type="email"
                  ></v-text-field>
                  <v-text-field
                    class="login-input"
                    label="Contraseña"
                    variant="underlined"
                    type="password"
                  ></v-text-field>
                  <v-text-field
                    class="login-input"
                    label="Confirmar contraseña"
                    variant="underlined"
                    type="password"
                  ></v-text-field>
                </div>
                <div class="button-container">
                  <Button buttonText="Registrarse" class="form-button"></Button>
                </div>
              </form>
            </v-window-item>
          </v-window>
        </v-card-text>
      </v-card>

      <p id="forgot-password">¿Olvidaste tu contraseña?</p>
      <button class="btn"></button>
    </main>
  </body>
  <RouterView />
</template>

<style scoped>
body {
  width: 100vw;
  height: 100vh;
  background-image: url("../../images/roman-road.png");
}

main {
  background-color: rgba(0, 0, 0, 0.2);
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

@media only screen and (max-width: 600px) {
  body {
    background-image: url("../../images/roman-road-mobile.png");
  }
}

#main-logo {
  margin-top: 3vh;
}

#slogan {
  color: white;
  text-align: center;
  max-width: 80%;
}

#form-section {
  background-color: rgba(0, 0, 0, 0.5);
  backdrop-filter: blur(2px);
  width: 80%;
  border-radius: 8px;
  height: 336px;
}

.login-form {
  display: flex;
  flex-direction: column;
  margin-top: 2vh;
  gap: 24px;
}

.login-form :first-child {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.register-form {
  margin-top: -.5vh;
}

.tab-container {
  border-radius: 8px 8px 0 0;
}

.login-input {
  color: white;
  padding: 0 5vw;
}

.button-container {
  display: flex;
  justify-content: center;
}

.form-button {
  background-color: white;
  color: black;
  margin-bottom: 2vh;
}

button {
  font-weight: bold;
}

#forgot-password {
  color: white;
  margin-bottom: 2vh;
  font-size: 90%;
  text-align: center;
}
</style>
