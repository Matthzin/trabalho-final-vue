<script setup>
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'

const produtos = ref([])
const termoPesquisa = ref('');

onMounted(() => {
  axios.get('http://localhost:8089/produtos')
  .then(response => {
    produtos.value = response.data
  })
})

const produtosFiltrados = computed(() => {
  return produtos.value.filter((p) =>
    p.descricao.toLowerCase().includes(termoPesquisa.value.toLowerCase())
  );
});

</script>

<template>
  <div class="search-container">
    <input v-model="termoPesquisa" placeholder="Pesquisar" class="search-input" />
  </div>
  <div class="container">
    <div v-for="p in produtosFiltrados" :key="p.id" class="produto-card">
      <img :src="p.imagens.length > 0 ? p.imagens[0].url : 'x'" class="produto-imagem">
      <h3 class="produto-nome">{{ p.descricao }}</h3>
      <p class="produto-preco">R$ {{ p.preco.toFixed(2) }}</p>
      <router-link :to="{ name: 'detalhes-produto', params: { id: p.id } }" class="ver-detalhes">Ver detalhes</router-link>
        <!-- Este botão de ver detalhes está redirecionando para uma página em branco. O router parece não funcionar corretamente;
        Caso clique para ver detalhes e retorne à página inicial, aperte F5 para atualizá-la e os produtos aparecerão novamente -->
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 70vh;
}

.produto-card {
  border: 1px solid #ddd;
  padding: 20px;
  margin: 20px;
  text-align: center;
  max-width: 300px;
}

.produto-imagem {
  max-width: 150px;
  height: auto;
}
.search-container{
  margin-top: 80px;
  align-items: center;
  justify-content: center;
  display: flex;
}
.search-input {
  width: 300px;
  padding: 10px;
  font-size: 16px;
}

.ver-detalhes {
  background-color: #4caf50;
  color: white;
  padding: 10px;
  margin-top: 10px;
  cursor: pointer;
  border: none;
  text-decoration: none;
}

.ver-detalhes:hover {
  background-color: #45a049;
}
</style>