## 🛠️ Setup Inicial: Projeto de Agendamento de Transferências Financeiras (Spring Boot + Vue.js)

Este projeto consiste em um sistema para **agendamento de transferências financeiras**, utilizando **Spring Boot** no backend e **Vue.js** no frontend. O objetivo é fornecer uma aplicação robusta com autenticação JWT e conexão com um banco de dados **H2**.

---

## 📌 **O que foi feito neste commit?**

### **Backend (Spring Boot + Spring Security)**
- Configuração inicial do projeto Spring Boot 3.3.9 com Java 17.

### **Frontend (Vue.js 3)**
- Configuração inicial do projeto Vue 3.




## 🚀 **Como rodar o projeto?**

### **1️⃣ Clonar o repositório**
```sh
  git clone <URL_DO_REPOSITORIO>
  cd nome-do-projeto
```

### **2️⃣ Configuração do Backend (Spring Boot)**

```sh
cd backend
./mvnw spring-boot:run
```
- O servidor estará rodando em [http://localhost:8080](http://localhost:8080).
- Certifique-se de que o **banco de dados H2** está rodando corretamente.

### **3️⃣ Rodar o Frontend (Vue.js)**

```sh
  cd frontend
  npm install
  npm run serve
```
- O frontend estará disponível em **http://localhost:3000**



---

## 🔜 **Próximos Passos**
- Criar sistema de login e autenticacao
- Implementar a **integração entre Backend e Frontend** (serviço de autenticação e consumo de APIs).
- Criar páginas adicionais (agendamentos e extrato de transferências financeiras).
- Melhorar o design com componentes estilizados.


 🚀

---



