# Testes de API com Java e RestAssured

Este repositório contém a implementação de testes automatizados para APIs utilizando **Java** e a biblioteca **RestAssured**. O objetivo é validar endpoints de APIs REST, garantindo sua funcionalidade e confiabilidade.

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

## Estrutura do Projeto
```
AutomacaoApis/
src/
   test/
       java/
           tests/
               ApiTest.java
           utils/
               Config.java
               RequestFactory.java
pom.xml
README.md
```

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
