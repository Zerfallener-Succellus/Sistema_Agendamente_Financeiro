const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    port: 3000, // Define a porta desejada (pode ser outra, ex: 5173)
  },
  transpileDependencies: true
})
