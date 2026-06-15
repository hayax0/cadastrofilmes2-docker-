# Sistema de Cadastro de Filmes

## Objetivo
Desenvolver a continuação do sistema iniciado em aula, integrando front-end e back-end utilizando SpringBoot + Thymeleaf. Permitindo cadastro e listagem de filmes em uma interface web funcional.

## Itens Obrigatório

| Componentes da Equipe| Bruno César Franca Ferreira; Caio Campos; Guilherme Augusto dos Santos; Fernando Menezes |
| Tema escolhido | Sistema de Cadastro de Filmes |
| Tecnologias usadas | Spring Boot, Thymeleaf, Spring Data JPA, H2 Database, Bootstrap |
| Funcionalidades | Cadastrar, Listar, Alterar, Excluir |
| Como executar |


## Campos do filme

- Nome
- Gênero
- Duração (em minutos)
- Classificação

## Funcionalidades

- Tela de cadastro de filme (Nome, Gênero, Duração, Classificação)
- Botão "Novo Filme" que abre o formulário de cadastro
- Salvamento no banco H2
- Atualização automática da tabela de listagem após cadastrar
- Funcionalidade Alterar (editar filme existente)
- Funcionalidade Excluir (remover filme)
- Mensagem "Filme salvo com sucesso"

## Estrutura do projeto

```
filme-crud
├── pom.xml
└── src/main
    ├── java/com/
    │   ├── CadastroFilmeApplication.java
    │   ├── Filme.java
    │   ├── FilmeDAO.java
    │   └── WebControl.java
    └── resources
        └── templates
            ├── filmes.html
            └── form.html
```

## Como executar

Pré-requisitos: Java 17 (ou superior) e Maven instalados.

1. Clique com o botão direito em cima do arquivo " CadastroFilmeApplication.java"
2. Selecione "Run As "
3. Escolha a Opção " Spring Boot App"
4. Clique duas vezes no arquivo que está no Boot Dashboard
5. Acesse no navegador:

```
http://localhost:8080/filmes
```


## Fluxo de uso

1. Na tela principal, clique em **Novo Filme**.
2. Preencha o formulário (ex.: Nome: Matrix, Gênero: Ficção, Duração: 136, Classificação: 14 anos) e clique em **Salvar**.
3. O filme é salvo no banco e a tabela é atualizada automaticamente, exibindo a mensagem "Filme salvo com sucesso".
4. Use os botões **Alterar** e **Excluir** em cada linha para editar ou remover filmes.
