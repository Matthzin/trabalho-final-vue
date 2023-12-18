### INICIANDO A APLICAÇÃO

- Abra a aplicação Spring Boot na pasta Back-end;
- Crie uma base de dados no MySQL e não adicione nenhuma tabela;
- Concilie as informações do MySQL com as do Spring na application.properties na aplicação Java;
- Rode a aplicação Java;<br><br>

- Abra a pasta e-commerce que está dentro da pasta Front-end;
- Inicie um novo terminal e execute o código `npm install`;
- Após, execute `npm run dev`;

### NAVEGANDO NO SITE

A aplicação faz reuqisições `GET` na base de dados para trazer produtos à tela inicial.
Os produtos estão dentro de um filtro computado que permite o retorno de um produto específico ao ter seu nome pesquisado.
O botão `Ver detalhes` deveria enviar o usuário à página específica do produto, mas não está funcionando.
Ao clicar no botão `Ver detalhes`, o usuário é enviado para uma página em branco, contendo apenas o menu navegável da aplicação.
É possível retornar à página inicial pelos botões `Produtos` e `E-commerce` na barra de navegação ao topo da página.

**Nota:** Ao retornar para a página inicial, a mesma pode não ser carregada, ficando em branco. Neste caso, basta recarregar a página.
