# Sistema de Cadastro de Filmes

## Descrição do Projeto

Este projeto consiste em uma aplicação de gerenciamento de catálogo de filmes desenvolvida em ambiente acadêmico e posteriormente evoluída para uma arquitetura mais próxima do mercado.

A solução integra um Frontend responsivo e moderno com um Backend desenvolvido em Spring Boot, utilizando Docker para conteinerização, garantindo isolamento de ambiente, comunicação entre serviços e persistência real dos dados utilizando PostgreSQL.

O principal objetivo desta etapa foi aplicar boas práticas de desenvolvimento de software, aproximando a aplicação de um cenário profissional com infraestrutura baseada em containers.

---

# Integrantes da Equipe

- Bruno César Franca Ferreira
- Caio Campos
- Guilherme Augusto dos Santos
- Fernando Menezes

---

# Tecnologias Utilizadas

| Camada | Tecnologia | Descrição |
|---|---|---|
| Frontend | Thymeleaf + Bootstrap 5 | Interface responsiva, formulários modernos e componentes visuais |
| Backend | Spring Boot 3 + Java 17 | API REST, regras de negócio e arquitetura MVC |
| Persistência | Spring Data JPA | ORM e comunicação com banco de dados |
| Banco de Dados | PostgreSQL | Banco relacional executado em container Docker |
| Infraestrutura | Docker | Conteinerização e isolamento dos serviços |

---

# Funcionalidades

A aplicação possui um CRUD completo para gerenciamento de filmes.

## Cadastro

Permite adicionar novos filmes ao catálogo com validação dos campos.

## Listagem

Exibe todos os filmes cadastrados através de uma interface responsiva.

## Alteração

Possibilita editar informações de filmes já existentes.

## Exclusão

Permite remover filmes do banco de dados.

## Feedbacks Visuais

A aplicação apresenta mensagens de sucesso e erro após as operações realizadas pelo usuário.

---

# Campos do Filme

Cada registro possui os seguintes atributos:

- Nome - Título do filme
- Gênero - Ação, Drama, Ficção, Comédia, entre outros
- Duração - Tempo do filme em minutos
- Classificação Indicativa:
  - Livre
  - 12 anos
  - 14 anos
  - 16 anos
  - 18 anos

---

# Estrutura do Projeto

```text
filme-crud
|
├── pom.xml
├── Dockerfile
|
└── src/main
    |
    ├── java/com/
    |   |
    |   ├── CadastroFilmeApplication.java
    |   ├── Filme.java
    |   ├── FilmeDAO.java
    |   └── WebControl.java
    |
    └── resources
        |
        ├── application.properties
        |
        └── templates
            |
            ├── filmes.html
            └── form.html
```

---

# Execução do Projeto com Docker

## Pré-requisitos

Antes de iniciar, tenha instalado:

- Docker
- Docker Compose (opcional)
- Maven

---

# 1. Criando a Rede Docker

```bash
docker network create filme-net
```

---

# 2. Inicializando o Banco PostgreSQL

```bash
docker run -d \
  --name pg-filmes \
  --network filme-net \
  -p 5432:5432 \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=root \
  -e POSTGRES_DB=db_filmes \
  postgres:latest
```

Configuração utilizada:

```text
Banco: db_filmes
Usuário: postgres
Senha: root
Porta: 5432
```

---

# 3. Gerando o Build da Aplicação

Na raiz do projeto:

```bash
mvn clean package -DskipTests
```

---

# 4. Criando a Imagem Docker do Backend

```bash
docker build -t backend-filmes .
```

---

# 5. Inicializando o Container Backend

```bash
docker run -d \
  --name api-filmes \
  --network filme-net \
  -p 8080:8080 \
  backend-filmes
```

---

# Acessando a Aplicação

Após iniciar os containers:

```text
http://localhost:8080/filmes
```

---

# Fluxo da Aplicação

## Acesso ao Sistema

Ao acessar:

```text
/filmes
```

o usuário visualizará o dashboard contendo os filmes cadastrados.

---

## Cadastro de Filme

Clique em:

```text
Novo Filme
```

Preencha os campos e salve o registro.

---

## Persistência dos Dados

Fluxo da aplicação:

```text
Frontend
   |
   v
Spring Boot Backend
   |
   v
Spring Data JPA
   |
   v
PostgreSQL Container
```

---

# Arquitetura Docker

```text
                 Docker Network
                    filme-net

        +----------------------+
        |                      |
        | Backend Spring Boot  |
        | Porta: 8080          |
        |                      |
        +-----------+----------+
                    |
                    |
        +-----------v----------+
        |                      |
        | PostgreSQL            |
        | Banco: db_filmes      |
        | Porta: 5432           |
        |                      |
        +----------------------+
```

---

# Objetivos Alcançados

- Aplicação CRUD completa
- Interface responsiva utilizando Bootstrap
- Backend estruturado com Spring Boot
- Persistência real utilizando PostgreSQL
- Ambiente isolado através de Docker
- Comunicação entre containers via Docker Network
- Organização próxima de um ambiente profissional

---

# Projeto desenvolvido para fins acadêmicos
