package web_driver;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(Config config) {
        if (null == driver.get()) {
            try {
                driver.set(DriverManager.getDriver(Config.CHROME));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static WebDriver getDriver() {
        if (null == driver.get()) {
            try {
                driver.set(DriverManager.getDriver(Config.CHROME));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }
    public static void closeDriver(){
        driver.get().close();
        driver.get().quit();
    }






}