package br.com.mentoria.reqresin;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;

public class Cadastro {
    @Test
    void cadastrarUsuario(){
        with().body("{\n" +
                "    \"name\": \"Gilson Rodrigues1997\",\n" +
                "    \"job\": \"QA Jr\"\n" +
                "}").post("https://reqres.in/api/users").then().log().all();
    }

}
