package br.com.mentoria.reqresin;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ListarUsuarios {
        @Test
        void resgatarListaUsuario() {
                get("https://reqres.in/api/users?page=1").then().log().all();
        }

        @Test
        void givenWhenThen() {
            given()
                    .when().get("https://reqres.in/api/users?page=1")
                    .then().statusCode(200);

        }
}