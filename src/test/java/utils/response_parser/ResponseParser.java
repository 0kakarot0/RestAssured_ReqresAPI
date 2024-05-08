package utils.response_parser;

import io.restassured.response.Response;

public class ResponseParser {

    public static String getResponseAsString(Response response) {
        return response.getBody().asString();
    }

    public static String getHeaderValue(Response response, String headerName) {
        return response.getHeader(headerName);
    }

    public static String getJsonValueAsString(Response response, String key) {
        return response.jsonPath().getString(key);
    }

    public static String extractValueByXpath(Response response, String xPathExpression){
        return response.xmlPath().getString(xPathExpression);
    }
}
