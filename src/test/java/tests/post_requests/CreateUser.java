package tests.post_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import utils.data_serialize.JSONSerialize;
import utils.request_builder.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

public class CreateUser extends TestBase {

//    TODO Complete the PUT / PATCH / DELETE Classes
    @Test
    public void createUser() {
        Map<String, String> userObject = new HashMap<>();
        userObject.put("name", "David Miller");
        userObject.put("job", "Athlete");
        System.out.println(userObject);
        postEmployeeEndPoint(userObject);
    }

    private Response postEmployeeEndPoint(Object object) {
        return RequestBuilder.postRequest("/api/users", JSONSerialize.serializeObjectAsJson(object));
    }
}
