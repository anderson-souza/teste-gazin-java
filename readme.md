# Teste Técnico Gazin

Teste técnico para a vaga de Desenvolvedor na Gazin

Projeto desenvolvido em Java 1.8 utilizando o framework Spring Boot 2.2.0 para criação das APIs e rotas da aplicação.



## Requisitos

- Java 1.8
- MySql 8
- Maven

## Instalação e configuração

Clone o repositório utilizando o comando: `git clone https://github.com/anderson-souza/teste-gazin-java.git`

### Configuração do banco de dados

Crie o banco no MySQL através do comando  `create database teste-gazin` ou através de qualquer outra ferramenta GUI para gerenciamento, como o MySql Workbench. 

Para conectar-se no banco de dados, a aplicação está utilizando os seguintes dados

> `url=jdbc:mysql://localhost:3306/teste-gazin`
>
> `username=root`
>
> `password=root`

Caso tenha modificado estes dados na instalação de seu MySql, edite o arquivo `application.properties` localizado em `teste-gazin-api\src\main\resources` para refletir os dados que utiliza em sua máquina.

A aplicação criará todas as tabelas e relacionamentos necessários assim que o projeto for iniciado, mas caso seja preciso rodar manualmente os códigos SQL, verificar o arquivo `script-geracao-bd-gazin.sql`



## Execução

Abra o prompt de comandos na raiz do projeto e execute o comando `mvn spring-boot:run`, este comando baixará todas as dependências necessárias e executará o projeto, que passará a ouvir requisições no endereço `http://localhost:8080/api`

Caso o comando acima *apresente algum erro*, executar o comando  `mvn clean package`, que gerará um arquivo JAR na pasta `target`. Então, executar o comando  `java -jar target/Teste-Gazin-1.0.0-SNAPSHOT.jar`



## Documentação

A documentação das APIs pode ser visualizada no seguinte [link](https://app.swaggerhub.com/apis/andersonsouza/Documentacao-API-Teste-Gazin/1.0) 



## Testes

Qualquer software que seja capaz de testar APIs pode fazer a execução do projeto, abaixo sugiro dois deles.

### Postman

Para testar a aplicação de forma fácil, é recomendado a utilização do software [Postman](https://www.getpostman.com/), uma ótima ferramenta para testes em APIs. Na raiz do projeto existe o arquivo `Teste Gazin.postman_collection.json` que contém uma coleção com as funções já criadas para testar a API no Postman. 

Para importar esta coleção dentro do Postman, basta clicar em "File->Import" e selecionar o arquivo.

Para Persistência e Seleção de um filme, seguir os passos

- Executar a request POST Produtor (Cria um Produtor)
- Executar a request POST Diretor (Cria um Diretor)
- Executar a request POST Ator (Cria um Ator)
- Executar a request POST Filmes (Cria um filme)
- Executar a request GET Filmes (Recupera o Filme criado)



### cUrl

Também é possível executar as operações utilizando o [cUrl](https://curl.haxx.se/)

Na pasta `Testar Aplicação` criei um simples arquivo .bat que executa os comandos via cUrl para criação de um Filme, em seguida, executa o comando GET para visualização do Filme criado. A resposta será gerada no terminal.



***Nota sobre os testes** devido ao tempo para realização do teste, preferi não adicionar a parte de Segurança no Spring Boot, para habilitar a execução de CORS e então visualizar as requisições no navegador, por este motivo disponibilizo as formas acima para execução do projeto.*

