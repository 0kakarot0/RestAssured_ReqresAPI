package tests.get_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

public class GetListOfUsers extends TestBase {

    @Test(priority = 0)
    public void testGetAllEmployees() {
        //Send request to get all the users
        Response response = getEmployeeApiResponse();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void verifyPageNumber() {
        Response response = getEmployeeApiResponse();
        String responseBody = ResponseParser.getResponseAsString(response);
        System.out.println(responseBody);
        Assert.assertTrue(responseBody.contains("\"page\":" + 1));
    }

    @Test(priority = 2)
    public void verifyPerPageNumber() {
        Response response = getEmployeeApiResponse();
        String responseBody = ResponseParser.getResponseAsString(response);
        Assert.assertTrue(responseBody.contains("\"per_page\":" + 6));
    }

    @Test(priority = 2)
    public void verifyTotalPageNumber() {
        Response response = getEmployeeApiResponse();
        String responseBody = ResponseParser.getResponseAsString(response);
        Assert.assertTrue(responseBody.contains("\"total_pages\":" + 2));
    }

    @Test(priority = 3)
    public void verifyDataInResponse() {
        Response response = getEmployeeApiResponse();
        String responseBody = ResponseParser.getResponseAsString(response);
        Assert.assertTrue(responseBody.contains("\"data\":"));
    }

    @Test(priority = 3)
    public void verifyFirstNameInDataInResponse() {
        Response response = getEmployeeApiResponse();
        String responseBody = ResponseParser.getResponseAsString(response);

        String[] firstNames = {"George", "Janet", "Emma", "Eve", "Charles", "Tracey"};
        for (String userFirstName : firstNames) {
            Assert.assertTrue(responseBody.contains("\"first_name\":\"" + userFirstName + "\""));
        }
    }

    private Response getEmployeeApiResponse() {
        return RequestBuilder.getRequest("/api/users");
    }
}
