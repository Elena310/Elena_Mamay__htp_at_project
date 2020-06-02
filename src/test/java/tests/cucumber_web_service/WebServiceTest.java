package tests.cucumber_web_service;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import post_request.PostSearchRequest;
import test_objects.ResponseObject;
import tests.web_service.SearchTestTools;
import utilites.MyJsonParser;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WebServiceTest {
    private static final String postUrl = "http://178.124.206.46:8001/app/ws/";
    private static final Logger LOGGER = LogManager.getLogger(WebServiceTest.class);

    @Given("I start search all users by {int}")
    public void iStartSearchAllUsers(Integer int1) throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "", true);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/users.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
        LOGGER.info("I searched all users, actual result = expected result");
    }

    @When("I search users by strict long name")
    public void iSearchUsersByStrictLongName() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "saldo", true);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/strict_long_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
        LOGGER.info("I searched users by strict long name, actual result = expected result");

    }

    @And("I search users by strict short name")
    public void iSearchUsersByStrictShortName() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "a", true);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/strict_short_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
        LOGGER.info("I searched users by strict short name, actual result = expected result");

    }

    @And("I search users by partial long name")
    public void iSearchUsersByPartialLongName() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "rangara", false);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/partial_long_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
        LOGGER.info("I searched users by partial long name, actual result = expected result");
    }

    @Then("I search users by partial short name and I validate the web service response {string}")
    public void i_search_users_by_partial_short_name_and_I_validate_the_web_service_response(String string) throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "s", false);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/partial_short_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
        LOGGER.info("Everything is good");
    }
}
