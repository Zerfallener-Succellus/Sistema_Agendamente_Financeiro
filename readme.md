## 🛠️ Projeto de Agendamento de Transferências Financeiras (Spring Boot + Vue.js)

Este projeto consiste em um sistema para **agendamento de transferências financeiras**, utilizando **Spring Boot** no backend e **Vue.js** no frontend. Ele permite que usuários realizem transferências financeiras agendadas com base em uma tabela de taxas e visualizem os extratos das transações.

---

## 📌 Tecnologias Utilizadas

### 🖥️ Backend (Spring Boot)
- **Spring Boot 3.3.9**
- **Spring Security** (Autenticação JWT)
- **Spring Data JPA** (Acesso ao banco de dados H2)
- **Lombok** para reduzir código
- **Spring Web** para criação de API REST
- **Spring Boot DevTools** para recarregamento automático

### 🌐 Frontend (Vue.js 3)
- **Vue**
- **Vue Router** para gerenciar as rotas
- **Vuex** para gerenciamento de estado
- **CSS puro** para estilização no estilo **Neo Brutalista**

---



## 🎯 Funcionalidades Principais

- **Cadastro e autenticação de usuários** utilizando **JWT**.
- **Agendamento de transferências financeiras**, com cálculo de taxas baseado em regras pré-definidas.
- **Visualização de extratos das transferências** realizadas.
- **Suporte a múltiplos usuários**.
- **Integração frontend-backend** via API RESTful.
- **Sistema de login e autenticação JWT.**
- **Configuração CORS** para comunicação com o frontend.
- **Banco de dados H2 embutido** para testes e desenvolvimento.

---

## 🚀 **Como rodar o projeto**

### 🎮 Pré-requisitos
- **Java 17+**
- **Maven**
- **Node.js 16+** com npm ou yarn

### 📌 Rodando o Backend (Spring Boot)
1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>
   cd NOME_DO_PROJETO/backend
   ```
2. Compile e inicie a aplicação backend:
   ```sh
   ./mvnw spring-boot:run
   ```
3. O backend estará disponível em: [http://localhost:8080](http://localhost:8080)
4. O **H2 Database** estará disponível em `http://localhost:8080/h2-console`

---

### 🖥 Como rodar o Frontend (Vue.js)
1. Acesse a pasta do frontend:
   ```sh
   cd frontend
   ```
2. Instale as dependências:
   ```sh
   npm install
   ```
3. Inicie o servidor de desenvolvimento:
   ```sh
   npm run serve
   ```
4. Acesse no navegador:
   [http://localhost:3000](http://localhost:3000)

---

## 🛡️ Autenticação com JWT

O backend foi configurado para autenticação baseada em **JWT (JSON Web Token)**:
- O login é realizado via `POST /api/auth/login`, retornando um **token JWT**.
- Esse token é **necessário** para acessar os endpoints de transferência de valores.
- **Para autenticar:** Envie o token no cabeçalho das requisições **Authorization: Bearer <token>**.
- **Exemplo de headers para requisição autenticada:**
  ```sh
  Authorization: Bearer <TOKEN_AQUI>
  Content-Type: application/json
  ```
- **Banco de Dados H2:**
  - O sistema utiliza um banco de dados **H2 embutido** para desenvolvimento e testes.
  - Console do H2: [http://localhost:8080/h2cmd](http://localhost:8080/h2cmd)

---

## 🚀 **Como rodar o projeto**

### 🔧 Requisitos:
- **JDK 17+**
- **Maven**
- **Node.js** 
- **NPM** 

### 🏗 **Backend (Spring Boot)**

1. Clone o repositório e acesse a pasta do backend:
   ```sh
   git clone <URL_DO_REPOSITORIO>
   cd nome-do-projeto/backend
   ```
2. Inicie a API Spring Boot com:
   ```sh
   ./mvnw spring-boot:run
   ```
3. A API estará disponível em: [http://localhost:8080](http://localhost:8080)
4. Para acessar o **H2 Console**:
   - URL: [http://localhost:8080/h2cmd](http://localhost:8080/h2cmd)
   - **JDBC URL:** `jdbc:h2:mem:testdb`
   - **User:** `user`
   - **Senha:** `senha`

---

### 💻 **Executando o Frontend (Vue.js)**
1. Acesse a pasta do frontend:
   ```sh
   cd frontend
   ```
2. Instale as dependências:
   ```sh
   npm install
   ```
3. Inicie o servidor local:
   ```sh
   npm run dev
   ```
4. Acesse no navegador: [http://localhost:3000](http://localhost:3000)

---



## 📜 **Endpoints**

### 🔑 **Autenticação**
- `POST /api/auth/register` - Cadastro de um novo usuário.
- `POST /api/auth/login` - Retorna um token JWT para autenticação.

### 💰 **Transferências**
- `POST /api/transfers` - Criar um novo agendamento de transferência.
- `GET /api/transfers` - Listar todas as transferências agendadas.
- `GET /api/transfers/user/*id` -Existe também um que foi utilizado somente para verificar a autenticação.

---

## 🎨 **Estilo e Design**
- **Estilo:** **Neo Brutalismo + Old Web**
- **Cores predominantes:**
  - 🟡 **Amarelo (#ffcc00)** - Cor principal para destaques e botões
  - ⚫ **Preto e cinza escuro:** Fundo e contornos grossos
- **Tipografia:** Tipografia digital e angular, remetendo à estética retrô da Web 1.0(Windows 98 etc).
- **Interface chamativa e de alto contraste**.

---

## 📌 **Considerações finais**

O projeto foi desenvolvido seguindo boas práticas de **segurança**, **modularização** e **design estilizado**.

🚀 




