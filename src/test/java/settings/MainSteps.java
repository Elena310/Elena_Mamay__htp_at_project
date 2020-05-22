package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainSteps {
    public static Properties getProperties(String path) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(path);
        properties.load(input);
        return properties;
    }
}