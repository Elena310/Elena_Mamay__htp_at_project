package post_request;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import test_objects.ResponseObject;
import utilites.MyJsonParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostSearchRequest {
    public static Map<String, ResponseObject> searchUsers(String url, String user, boolean strict) throws IOException {
        Map<String, ResponseObject> responseMap = new HashMap();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity postingString = new StringEntity(MyJsonParser.searchJson(user, strict));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        String responseCode = String.valueOf(response.getStatusLine().getStatusCode());
        responseMap.put(responseCode, MyJsonParser.parseActualJson(EntityUtils.toString(response.getEntity())));
        return responseMap;
    }
}
