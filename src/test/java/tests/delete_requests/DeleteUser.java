package tests.delete_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

public class DeleteUser extends TestBase {

    @Test
    public void deleteUserFromUserList(){
        Response response = RequestBuilder.deleteRequest("/api/users/2");

        String responseBody = ResponseParser.getResponseAsString(response);

        System.out.println(responseBody);
    }
}
