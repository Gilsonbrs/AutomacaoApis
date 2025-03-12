package br.com.mentoria.reqresin;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.*;

public class ListarUsuarios {
        private static RequestSpecification reqSpec;
        @BeforeAll
        static  void setup (){
                RestAssured.baseURI = "https://reqres.in";
                //             port = 8080
                basePath = "/api";
                RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
                requestBuilder.log(LogDetail.ALL);
                 reqSpec = requestBuilder.build();
        }

        @Test
        void givenWhenThen() {

                given()
                        .spec(reqSpec)
                        .when()
                        .get("/users?page=1")
                        .then()
                        .statusCode(200);

        }

        @Test
        void resgatarListaUsuario() {
                given()
                        .spec(reqSpec)
                        .when()
                                .get("/users?page=2")
                        .then()
                                .log()
                                .all()
                        .statusCode(200)
                        .body("page",is (2))
                        .body("per_page",is (6))
                        .body("total",greaterThan (10))
                        .body("total_pages", lessThan (5));
        }
        @Test
        public void JuniValidacaoResgatarLista(){
                Response response = RestAssured.request(Method.GET, "https://reqres.in/api/users?page=2");

                //path
                Assertions.assertEquals(Integer.valueOf(2), response.path("page"));
                Assertions.assertEquals(Integer.valueOf(6), response.path("per_page"));

                //JsonPath
                JsonPath jsonPath = new JsonPath(response.asString());
                Assertions.assertEquals(12, jsonPath.getInt("total"));
                Assertions.assertEquals(2, jsonPath.getInt("total_pages"));


        }

}