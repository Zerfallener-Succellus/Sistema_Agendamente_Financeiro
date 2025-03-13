<template>
  <div>
    <h2>Register</h2>
    <form @submit.prevent="register">
      <input type="text" v-model="username" placeholder="Username" />
      <input type="password" v-model="password" placeholder="Password" />
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
import axios from '../../axios';

export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    async register() {
      try {
        await axios.post('/auth/register', {
          username: this.username,
          password: this.password,
          role: 'USER', // Pode ser adaptado conforme necessidade
        });
        this.$router.push('/login');
      } catch (error) {
        alert('Erro ao registrar');
      }
    },
  },
};
</script>

<style scoped>

div {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 80vh;
    background: #f4f4f4;
    font-family: "Courier New", Courier, monospace;
  }

.container {
  max-width: 350px;
  margin: 50px auto;
  padding: 20px;
  background: white;
  border-radius: 8px;
  border: 4px solid black; /* Contorno forte */
  box-shadow: 8px 8px 0px black; /* Sombra estilo neo-brutalista */
  text-align: center;
}

h2 {
  font-family: "Courier New", Courier, monospace;
  color: black;
  font-size: 22px;
  text-transform: uppercase;
}

input {
  width: 100%;
  padding: 12px;
  margin: 10px 0;
  border: 3px solid black;
  border-radius: 5px;
  font-size: 16px;
  font-family: "Courier New", Courier, monospace;
}

button {
  width: 100%;
  padding: 12px;
  background: #ffcc00;
  color: black;
  border: 3px solid black;
  border-radius: 5px;
  font-size: 16px;
  font-family: "Courier New", Courier, monospace;
  cursor: pointer;
  box-shadow: 4px 4px 0px black;
  transition: 0.2s;
}

button:hover {
  background: black;
  color: #ffcc00;
}
</style>
