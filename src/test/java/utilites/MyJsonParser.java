package utilites;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import test_objects.ResponseObject;
import test_objects.RequestObject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MyJsonParser {
    private static final Gson gson = new Gson();

    public static ResponseObject parseExpectedJson(String path) throws IOException {
        File pathToJson = ResourceHelper.getFile(path);
        ResponseObject expected = gson.fromJson(new JsonReader(new FileReader(pathToJson)),
                ResponseObject.class);
        return expected;
    }

    public static String searchJson(String user, boolean strict) {
        RequestObject searchRequestJson = new RequestObject(user, strict);
        return gson.toJson(searchRequestJson);
    }

    public static ResponseObject parseActualJson(String json) {
        return gson.fromJson(json, ResponseObject.class);
    }
}
