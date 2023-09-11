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
          style="padding-top: 10px; padding-down: 0"
        >
          <n-input
            clearable
            size="large"
            v-model:value="loginForm.username"
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
        <n-form-item class="naive-form-item" path="password">
          <n-input
            clearable
            size="large"
            type="password"
            v-model:value="loginForm.password"
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
            clearable
            size="large"
            v-model:value="loginForm.code"
            placeholder="请输入验证码"
            ><template #prefix
              ><n-icon
                depth="1"
                color="#0B243B"
                :size="18"
                class="login-icon"
                :component="CodeWorking" /></template
          ></n-input>
          <canvas
            class="canvasPic"
            width="200"
            height="60"
            ref="canvasCode"
            @click="refreshCaptcha"
          ></canvas>
        </n-form-item>
        <n-form-item class="naive-form-item">
          <n-button
            color="#0B243B"
            ghost
            type="primary"
            block
            @click="loginMethod"
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
import { defineComponent, ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import {
  particlesOptions,
  particlesLoaded,
  particlesInit,
} from "../config/particles-config";
import axios from 'axios';

export default defineComponent({
  components: {},
  props: {},
  setup() {
    //定义图片验证码值
    const uform = ref(null);
    const canvasCode = ref(null);
    //生成验证码字符
    const generateRandomString = (length) => {
      const characters =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      let result = "";
      for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * characters.length);
        result += characters.charAt(randomIndex);
      }
      return result;
    };
    const generateCaptcha = () => {
      const canvas = canvasCode.value;
      if (canvas) {
        const context = canvas.getContext("2d");
        const captchaText = generateRandomString(4); // 生成6位验证码
        loginFormRef.value.code = ""; // 清空用户输入
        // 绘制验证码
        context.clearRect(0, 0, canvas.width, canvas.height);
        context.fillStyle = "#0B243B";
        context.textAlign = "left";
        context.font = "bold 40px Arial";
        context.fillText(captchaText, 40, 50);
        // 添加模糊效果
        for (let i = 0; i < 30; i++) {
          const x = Math.random() * canvas.width;
          const y = Math.random() * canvas.height;
          const radius = Math.random() * 2;
          context.fillStyle = "rgba(1, 12, 1, 0.2)";
          context.beginPath();
          context.arc(x, y, radius, 0, Math.PI * 2);
          context.fill();
        }

        // 添加干扰线
        for (let i = 0; i < 5; i++) {
          context.strokeStyle = "rgba(2, 16, 50, 0.2)";
          context.beginPath();
          context.moveTo(
            Math.random() * canvas.width,
            Math.random() * canvas.height
          );
          context.lineTo(
            Math.random() * canvas.width,
            Math.random() * canvas.height
          );
          context.stroke();
        }
        loginFormRef.value.canvasTemp = captchaText;
        // 这里可以将生成的captchaText存储在组件的data中以供后续验证使用
      }
    };
    const refreshCaptcha = () => {
      generateCaptcha();
    };
    //路由
    const router = useRouter();
    //登录入参定义
    const loginFormRef = ref({
      username: null,
      password: null,
      code: null,
      canvasTemp: null,
    });
    const handleEnterKey = (event) => {
      if (event.key === "Enter") {
        loginMethod(); // 按下Enter键后触发登录操作
      }
    };
    //登录方法定义
    const loginMethod = () => {
      uform.value?.validate((errors) => {
        if (!errors) {
          if (loginFormRef.value.canvasTemp.toLocaleLowerCase() === loginFormRef.value.code.toLocaleLowerCase()) {
            axios.post("/api/admin/login", {
                username: loginFormRef.value.username,
                password: loginFormRef.value.password,
              })
              .then((res)=>{
                if(res.data.code === 200){
                  console.log(res.data);
                  window.$message.success("登录成功");
                  window.localStorage.setItem("admin",loginFormRef.value);
                  }
              })
          } else {
            loginFormRef.value.username = null;
            loginFormRef.value.password = null;
            loginFormRef.value.code = null;
            generateCaptcha();
            window.$message.error("验证码错误");
          }
        } else {
          loginFormRef.value.username = null;
          loginFormRef.value.password = null;
          loginFormRef.value.code = null;
          generateCaptcha();
          window.$message.error("登录输入未完成");
        }
      });
    };
    //登录入参验证
    const rules = {
      username: [{ required: true, message: "请输入账号", trigger: "blur" }],
      password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      code: [{ required: true, message: "请输入验证码", trigger: "blur" }],
    };
    onMounted(() => {
      generateCaptcha();
      // 监听Enter键事件
      document.addEventListener("keyup", handleEnterKey);
    });
    

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
      loginForm: loginFormRef,
      //登录校验
      rules,
      //登录方法
      loginMethod,
      //刷新图片验证码
      refreshCaptcha,
      //返回图片验证码关联
      canvasCode,
      //登录表单关联
      uform,
    };
  },
  beforeUnmount() {
    // 在组件销毁前移除事件监听器，以避免内存泄漏
    document.removeEventListener("keyup", handleEnterKey);
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
  height: 550px;
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
.naive-form-item-canvas {
  padding: 0;
  margin: 0;
  height: 10px;
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
  border-radius: 60%;
  z-index: 99;
}
.canvasPic {
  width: 100px;
  height: 30px;
}
</style>
