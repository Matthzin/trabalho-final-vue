<!-- Esta parte de exibição dos produtos em páginas separadas não está funcionando. Deve haver um problema com as rotas
do qual eu não consegui resolver;

A página fica em branco e o produto não é exibido;
Se clicar em um produto na lista, retorne à página inicial e atualiza a página pois a mesma pode aparecer em branco;-->

<template>
    <div class="detalhes-produto">
      <img :src="produto.imagens.length > 0 ? produto.imagens[0].url : 'x'" class="produto-imagem">
      <h2 class="produto-nome">{{ produto.descricao }}</h2>
      <p class="produto-preco">R$ {{ produto.preco.toFixed(2) }}</p>
      
      <div v-if="produto.comentarios.length > 0">
        <h3>Comentários</h3>
        <ul>
          <li v-for="comentario in produto.comentarios" :key="comentario.id">
            <strong>{{ comentario.usuario }}:</strong> {{ comentario.comentario }}
          </li>
        </ul>
      </div>
  
      <router-link :to="{ name: 'home' }" class="voltar-home">Voltar para a lista de produtos</router-link>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue'
  import axios from 'axios'
  
  const produto = ref(null)
  
  onMounted(() => {
    const produtoId = this.$route.params.id //Aqui deve haver um erro com a rota
    
    axios.get(`http://localhost:8089/produtos/${produtoId}`)
      .then(response => {
        produto.value = response.data
      })
  })
  </script>
  
  <style scoped>
  .detalhes-produto {
    text-align: center;
    max-width: 600px;
    margin: 0 auto;
  }
  
  .produto-imagem {
    max-width: 100%;
    height: auto;
  }
  
  .voltar-home {
    display: block;
    margin-top: 20px;
    text-decoration: none;
    background-color: #4caf50;
    color: white;
    padding: 10px;
  }
  </style>
  