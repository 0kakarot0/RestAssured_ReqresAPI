package tests.patch_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.data_serialize.JSONSerialize;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserByPatch extends TestBase {

    @Test
    public void updateUserByPatch(){
        Map<String, String> existingUser = new HashMap<>();
        existingUser.put("name", "David");
        existingUser.put("job","Resident");
        Response response = patchRequest(existingUser);

        String responseBody = ResponseParser.getResponseAsString(response);

        System.out.println(responseBody);
    }

    private Response patchRequest(Object object) {
        return RequestBuilder.patchRequest("/api/users/1", JSONSerialize.serializeObjectAsJson(object));
    }

}
