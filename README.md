<h1 align="center"> :speech_balloon: Challenge ONE Praticando Spring Framework: Fórum Hub :speech_balloon: </h1>

<div align="center">

ForumHub é uma aplicação web desenvolvida em Java com Spring Boot, que simula um fórum de discussão online. O objetivo principal é permitir a criação, visualização e interação em tópicos de discussão, facilitando o aprendizado colaborativo e a troca de conhecimento entre usuários.



</div>

## :round_pushpin: Objetivo do Desafio

- **Gerenciamento de Usuários:** Cadastro, autenticação e gerenciamento de usuários.
- **Tópicos de Discussão:** Criação, listagem, detalhamento e atualização de tópicos.
- **Respostas:** Permite que usuários respondam aos tópicos e interajam entre si.
- **Cursos:** Organização dos tópicos por cursos e categorias.
- **Validações e Segurança:** Utiliza autenticação JWT e validações para garantir a integridade dos dados.

## :computer: Tecnologias Utilizadas

- Java 17+
- Maven
- Spring Boot
- Spring Data JPA
- Spring Security
- Flyway (migração de banco de dados)
- Banco de dados relacional (ex: PostgreSQL)
- Lombok
- Java JWT
- Spring Documentation (Swagger)

## :arrow_forward: Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone git@github.com:gyselle-marques/ChallengeONE-ForumHub.git
   cd forumhub
   ```

2. **Configure o banco de dados:**
   - Edite o arquivo `src/main/resources/application.properties` com as credenciais e URL do seu banco de dados.
   - As migrations do banco serão executadas automaticamente via Flyway ao iniciar a aplicação.

3. **Compile o projeto:**
   ```bash
   ./mvnw clean install
   ```
   Ou, no Windows:
   ```cmd
   mvnw.cmd clean install
   ```

4. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```
   Ou, no Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```

5. **Acesse a aplicação:**
   - Por padrão, estará disponível em: `http://localhost:8080`

## :pushpin: Estrutura do Projeto

- `src/main/java/challenge/forumhub/` - Código-fonte principal
- `src/main/resources/` - Arquivos de configuração e recursos
- `db/migration/` - Scripts de migrations do banco de dados

## :warning: Observações

- O projeto utiliza autenticação JWT para proteger as rotas.
- Para testar endpoints protegidos, é necessário autenticar-se e utilizar o token JWT retornado.
- Consulte a documentação dos controllers para detalhes dos endpoints disponíveis.

## :pencil2: Documentação
A documentação da API pode ser acessada via Swagger em `/swagger-ui.html` (se configurado).

## :page_facing_up: Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE.txt` para mais detalhes.
