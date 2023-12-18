<template>
    <header>
        <nav class="navbar">
            <div class="container">
                <router-link to="/" class="logo">E-Commerce</router-link>
                <div class="nav-links">
                    <router-link to="/produtos">Produtos</router-link>
                    <router-link to="/carrinho">Carrinho</router-link>
                </div>
            </div>
        </nav>
    </header>
</template>
<script>

</script>

<style scoped>
.navbar {
    background-color: #333;
    color: white;
    padding: 15px 0;
}

.container {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo {
    font-size: 1.5em;
    color: white;
    text-decoration: none;
}

.nav-links {
    display: flex;
}

.nav-links a {
    color: white;
    margin-left: 20px;
    text-decoration: none;
}

.nav-links a:hover {
    text-decoration: none;
}
</style>