<template>
    <div>
      <nav>
        <router-link to="/">Home</router-link>
        <router-link to="/login">Login</router-link>
        <router-link to="/register">Register</router-link>
        <router-link to="/profile">Profile</router-link>
      </nav>
      <router-view />
    </div>
  </template>
  
  <script>
  export default {
    name: "App",
  };
  </script>
  
  <style scoped>

  * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  
}



nav {
  background: #ffcc00; /* Cor vibrante estilo old web */
  padding: 15px;
  text-align: center;
  border-bottom: 5px solid black; /* Contorno forte estilo neo-brutalista */
}

nav a {
  color: black;
  text-decoration: none;
  font-size: 18px;
  font-family: "Courier New", Courier, monospace; /* Fonte old web */
  padding: 10px 15px;
  border: 3px solid black; /* Contorno forte */
  border-radius: 5px;
  background: white;
  margin: 5px;
  display: inline-block;
  transition: 0.2s;
}

nav a:hover {
  background: black;
  color: #ffcc00;
}
</style>

  