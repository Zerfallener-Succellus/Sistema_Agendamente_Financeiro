<template>
  <div>
    <h2>Perfil de Usuário</h2>
    <p>Usuário: {{ user }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {}, 
    };
  },
  async mounted() {
    await this.getUserProfile(); 
  },
  methods: {
    async getUserProfile() {
      try {
        const token = localStorage.getItem("auth-token"); 
        if (!token) {
          console.error("Nenhum token encontrado!");
          return;
        }

        const response = await fetch("http://localhost:8080/api/users/me", {
          method: "GET",
          headers: {
            "Authorization": `Bearer ${token}`, 
            "Content-Type": "application/json",
          },
        });

        if (!response.ok) {
          throw new Error("Erro ao buscar dados do usuário");
        }

        this.user = await response.json(); 
      } catch (error) {
        console.error("Erro ao buscar perfil:", error);
      }
    },
  },
};
</script>