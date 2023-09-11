<template>
  <div class="particles-container">
    <Particles
      id="tsparticles"
      class="particles"
      :particlesInit="particlesInit"
      :particlesLoaded="particlesLoaded"
      :options="particlesOptions"
    />
    <!-- loginform  -->
    <div class="login-form">
      <h2 class="title">CHIIIPLOWPOST后台管理</h2>
      <img src="@/assets/img/Joji.png" class="loginImg" />
      <!-- form -->
      <n-form
        class="naive-form"
        ref="uform"
        :model="loginForm"
        :rules="rules"
        label-width="10px"
      >
        <n-form-item
          class="naive-form-item"
          path="username"
          :error="usernameError"
          style="padding-top: 10px; padding-down: 0"
        >
          <n-input
            size="large"
            v-model="loginForm.username"
            placeholder="请输入用户名"
            ><template #prefix
              ><n-icon
                depth="1"
                color="#0B243B"
                :size="18"
                class="login-icon"
                :component="UserOutlined" /></template
          ></n-input>
        </n-form-item>
        <n-form-item
          class="naive-form-item"
          path="password"
          :error="passwordError"
        >
          <n-input
            size="large"
            type="password"
            v-model="loginForm.password"
            placeholder="请输入密码"
            show-password-on="click"
            ><template #prefix
              ><n-icon
                depth="1"
                color="#0B243B"
                :size="18"
                class="login-icon"
                :component="LockFilled"
            /></template>
            <template #password-visible-icon>
              <n-icon color="#0B243B" :size="25" :component="GlassesOutline" />
            </template>
            <template #password-invisible-icon>
              <n-icon
                color="#0B243B"
                :size="25"
                :component="Glasses"
              /> </template
          ></n-input>
        </n-form-item>
        <n-form-item class="naive-form-item" path="code">
          <n-input
            size="large"
            v-model="loginForm.code"
            placeholder="请输入验证码"
            ><template #prefix
              ><n-icon
                depth="1"
                color="#0B243B"
                :size="18"
                class="login-icon"
                :component="CodeWorking" /></template
          ></n-input>
        </n-form-item>
        <n-form-item class="naive-form-item">
          <n-button
            color="#0B243B"
            ghost
            type="primary"
            block
            :loading="loading"
            @click="login"
            ><template #icon>
              <n-icon
                :component="CarryOutTwotone"
                color="#0B243B"
                :size="25"
              /> </template
            >登录</n-button
          >
        </n-form-item>
      </n-form>
    </div>
  </div>
</template>

<script>
import { UserOutlined, LockFilled, CarryOutTwotone } from "@vicons/antd";
import { GlassesOutline, Glasses, CodeWorking } from "@vicons/ionicons5";
import { defineComponent, ref } from "vue";
import {
  particlesOptions,
  particlesLoaded,
  particlesInit,
} from "../config/particles-config";

export default defineComponent({
  components: {},
  props: {},
  setup() {
    return {
      //图标
      CarryOutTwotone,
      CodeWorking,
      UserOutlined,
      LockFilled,
      GlassesOutline,
      Glasses,
      //粒子效果配置
      particlesOptions: particlesOptions,
      particlesLoaded: particlesLoaded,
      particlesInit: particlesInit,
      //登录表单
      loginForm: {
        username: "",
        password: "",
      },
    };
  },
});
</script>

<style>
.particles-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.particles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.login-form {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(255, 255, 255, 0);
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  padding: 20px;
  width: 20%;
  height: 55%;
  /* Add your login form styles here */
}
.login-form::before {
  content: "";
  position: absolute;
  backdrop-filter: blur(2px);
  z-index: -1;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.naive-form {
  width: 80%;

  z-index: 99;
}
.naive-form-item {
  padding: 0;
  margin: 0;
}
.title {
  text-align: center;
  padding: 10px;
  left: auto;
  z-index: 99;
}
.login-icon {
  z-index: 99;
}
.loginImg {
  width: 60px;
  height: 60px;
  border-radius: 50%;
  z-index: 99;
}
</style>
