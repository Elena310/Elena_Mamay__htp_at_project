package tests.web_service;
import post_request.PostSearchRequest;
import org.junit.Assert;
import org.junit.Test;
import test_objects.ResponseObject;
import utilites.MyJsonParser;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class SearchSteps {

    private static final String postUrl = "http://178.124.206.46:8001/app/ws/";

    @Test
    public void fullListTest() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "", true);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/users.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
    }

    @Test
    public void strictLongNameSearchTest() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "saldo", true);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/strict_long_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
    }

    @Test
    public void strictShortNameSearchTest() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "a", true);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/strict_short_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
    }

    @Test
    public void partialLongNameSearchTest() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "rangara", false);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/partial_long_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
    }

    @Test
    public void partialShortNameSearchTest() throws IOException {
        Map<String, ResponseObject> actualResponse = PostSearchRequest.searchUsers(postUrl, "s", false);
        ResponseObject actualResponseBody = actualResponse.entrySet().iterator().next().getValue();
        ResponseObject expected = MyJsonParser.parseExpectedJson("expected_result/partial_short_name.json");
        assertEquals("Response code isn't expected", "200",
                actualResponse.entrySet().iterator().next().getKey());
        Assert.assertTrue(SearchTestTools.responseChecker(actualResponseBody, expected));
    }
}
