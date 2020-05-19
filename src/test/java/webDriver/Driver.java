package webDriver;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(Config config){
        if(null == driver){
            driver = DriverManager.getDriver(config);
        }
        return driver;
    }
}
