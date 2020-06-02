package tests.web_service;
import test_objects.ResponseObject;
import test_objects.UserObject;
import java.util.List;

public class SearchTestTools {

    public static boolean responseChecker(ResponseObject actual, ResponseObject expected) {
        List<UserObject> actualUsers = actual.getData();
        List<UserObject> expectedUsers = expected.getData();
        for (int i = 0; i < actualUsers.size(); i++) {
            if (!actualUsers.get(i).toString().equals(expectedUsers.get(i).toString())) {
                System.out.println("Check users:\n");
                System.out.println("User Id:" + expectedUsers.get(i).getId() + "\n");
                System.out.println("Expect User: " + expectedUsers.get(i).toString() + "\n");
                System.out.println("Actual User: " + actualUsers.get(i).toString() + "\n");
                return false;
            }
        }
        return true;
    }
}
