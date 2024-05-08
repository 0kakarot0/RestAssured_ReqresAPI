package utils.rest_assured_config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.basic;

public class RestConfig {

    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";

//        setAuthentication();
    }

    private static void setAuthentication() {
        RestAssured.authentication = basic("eve.holt@reqres.in", "cityslicka");
    }

    public static RequestSpecification getRequestSpecification() {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .log().all();
    }
}
