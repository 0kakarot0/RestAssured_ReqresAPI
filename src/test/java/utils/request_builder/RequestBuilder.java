package utils.request_builder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    //Get Request
    public static Response getRequest(String endPoint) {
        return given().
                when().
                get(endPoint);
    }

    //Post Request
    public static Response postRequest(String endPoint, Object requestBody) {
        return given().
                body(requestBody).
                when().
                post(endPoint);
    }

    //Put Request
    public static Response putRequest(String endPoint, Object requestBody) {
        return given().
                body(requestBody).
                when().
                put(endPoint);
    }

    //Patch Request
    public static Response patchRequest(String endPoint, Object requestBody) {
        return given().
                body(requestBody).
                when().
                patch(endPoint);
    }

    //Delete Request
    public static Response deleteRequest(String endPoint) {
        return given().
                when().
                delete(endPoint);
    }
}
