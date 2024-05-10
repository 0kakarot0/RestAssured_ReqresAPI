package tests.put_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.data_serialize.JSONSerialize;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserByPut extends TestBase {

    @Test
    public void updateUser() {
        Map<String, String> existingUserData = new HashMap<>();
        existingUserData.put("name", "morpheus");
        existingUserData.put("job", "zion resident");
        Response response = putRequest(existingUserData);

        String responseBody = ResponseParser.getResponseAsString(response);
        System.out.println(responseBody);

    }

    private Response putRequest(Object object) {
        return RequestBuilder.putRequest("/api/users/2", JSONSerialize.serializeObjectAsJson(object));
    }
}
