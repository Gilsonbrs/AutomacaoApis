# Testes de API com Java e RestAssured

Este repositório contém a implementação de testes automatizados para APIs utilizando **Java** e a biblioteca **RestAssured**. O objetivo é validar endpoints de APIs REST, garantindo sua funcionalidade.

## Tecnologias Utilizadas
- **Java** (versão recomendada: 17+)
- **RestAssured** para testes de API
- **JUnit** para estruturação dos testes
- **Maven** para gerenciamento de dependências
- **JSONPath** para validação de respostas JSON

## Requisitos
Antes de começar, certifique-se de ter instalado:
- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.postman.com/downloads/) (opcional, para validação manual de APIs)

## Como Executar os Testes
1. Clone este repositório:
   ```sh
   git clone https://github.com/Gilsonbrs/AutomacaoApis.git
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd AutomacaoApis
   ```
3. Execute os testes com Maven:
   ```sh
   mvn test
   ```

## O que foi implementado
Este projeto contém testes automatizados para validar endpoints de uma API REST. Foram implementados:
- Testes de requisições **GET** para validar a resposta de listagem de usuários.
- Testes de requisições **POST** para criação de novos usuários.
- Testes com **autenticação Bearer Token** para garantir acesso autorizado aos endpoints protegidos.
- Testes com **autenticação Basic (usuário e senha)** para validação de login.
- Validações de **status code** e **corpo da resposta** utilizando JSONPath.
- Estrutura modularizada para facilitar a reutilização de código.
Este projeto contém testes automatizados para validar endpoints de uma API REST. Foram implementados:
- Testes de requisições **GET** para validar a resposta de listagem de usuários.
- Testes de requisições **POST** para criação de novos usuários.
- Testes com **autenticação Bearer Token** para garantir acesso autorizado aos endpoints protegidos.
- Validações de **status code** e **corpo da resposta** utilizando JSONPath.
- Estrutura modularizada para facilitar a reutilização de código.
Este projeto contém testes automatizados para validar endpoints de uma API REST. Foram implementados:
- Testes de requisições **GET** para validar a resposta de listagem de usuários.
- Testes de requisições **POST** para criação de novos usuários.
- Validações de **status code** e **corpo da resposta** utilizando JSONPath.
- Estrutura modularizada para facilitar a reutilização de código.


## Estrutura do Projeto
```
AutomacaoApis/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── config/
│   │   │   │   ├── Config.java
│   │   │   ├── factories/
│   │   │   │   ├── RequestFactory.java
│   │   │   ├── models/
│   │   │   │   ├── User.java
│   │   ├── resources/
│   │   │   ├── testData.json
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/
│   │   │   │   ├── AuthTests.java
│   │   │   │   ├── UserTests.java
├── pom.xml
├── README.md


## Exemplos de Testes
### Testando um GET Request
```java
@Test
public void testGetUsers() {
    given()
        .when()
        .get("https://reqres.in/api/users?page=2")
        .then()
        .statusCode(200)
        .body("data.size()", greaterThan(0));
}
```

### Testando um POST Request
```java
@Test
public void testCreateUser() {
    String requestBody = "{\"name\": \"Gilson\", \"job\": \"QA Engineer\"}";
    given()
        .header("Content-Type", "application/json")
        .body(requestBody)
        .when()
        .post("https://reqres.in/api/users")
        .then()
        .statusCode(201)
        .body("name", equalTo("Gilson"));
}
```

## Referências
- [Curso: Testes de API com Java e RestAssured](https://plataforma.etech.dev/175102-testes-de-api-com-java-restassured)
- [Documentação RestAssured](https://rest-assured.io/)
- [JUnit 5](https://junit.org/junit5/)
- [LinkedIn](https://www.linkedin.com/in/gilsonrbs/)
