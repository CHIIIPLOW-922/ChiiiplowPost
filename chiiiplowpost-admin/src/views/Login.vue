<template>
  <div class="particles-container">
    <Particles
      id="tsparticles"
      class="particles"
      :particlesInit="particlesInit"
      :particlesLoaded="particlesLoaded"
      :options="particlesOptions"
    />
    <div class="login-form"></div>
  </div>
</template>

<script>
import { defineComponent, ref } from "vue";
import { particlesOptions,particlesLoaded,particlesInit } from "../config/particles-config";

export default defineComponent({
    setup() {
        return{
            particlesOptions: particlesOptions,
            particlesLoaded: particlesLoaded,
            particlesInit: particlesInit
        }
    }
});

</script>

<style scoped>
.particles-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
}

.particles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>
