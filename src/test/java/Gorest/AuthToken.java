package Gorest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class AuthToken {

    private static RequestSpecification reqSpec;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://gorest.co.in/";
        //             port = 8080
        basePath = "public/v2";
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.log(LogDetail.ALL);
        reqSpec = requestBuilder.build();
    }

    @Test

    public void testeBearerAutenticacao(){
        String authToken = "01e691f266139624ab53697214ff8f6c18ff1fa73055c21614975621362036f3";


                given()
                        .spec(reqSpec)
                            .header("Content-Type", "application/json")
                            .header("Authorization", "Bearer " + authToken)
                            .get("/users")
                .then()
                .statusCode(200);

    }

    @Test
    public void testeAuthBasicUserAndPass(){
        String userPass = "{\"username\": \"emilys\" ,\"password\" :\"emilyspass\"}";
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(userPass)
                .when().post("https://dummyjson.com/auth/login");
        response.prettyPrint();
        String token = response.jsonPath().getString("accessToken");
        System.out.println("Seu Token é: " + token);
    }
}
