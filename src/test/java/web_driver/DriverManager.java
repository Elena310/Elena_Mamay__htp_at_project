package web_driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static WebDriver getDriver(Config config) throws MalformedURLException {
        switch (config) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

                return new ChromeDriver(chromeOptions);
            case FF:
                return new FirefoxDriver();
            case REMOTE:
                return getRemoteDriver();
            default:
                throw null;
        }
    }

    public static WebDriver getRemoteDriver() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        RemoteWebDriver webdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        return webdriver;
    }
}