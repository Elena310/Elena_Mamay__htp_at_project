package webDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver getDriver(Config config){
        switch (config){
            case CHROME:
                return new ChromeDriver();
            case FF:
                return new FirefoxDriver();
            default:
                throw null;
        }
    }
}
