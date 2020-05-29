package tests.booking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.MainSteps;
import webDriver.Config;
import webDriver.Driver;
import webPages.bookingPages.BookingLoginPage;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BookingHeaderTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingHeaderTest.class);

    public static String PATH = "/Users/natalliasamarava/Final/property.properties";
    WebDriver driver = Driver.getDriver(Config.CHROME);

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public  void isHeaderLoaded() throws IOException, InterruptedException {
        Properties prop = MainSteps.getProperties(PATH);
        driver.navigate().to("https://booking.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        bookingLoginPage.goToLoginPage();
        TimeUnit.SECONDS.sleep(3);
        bookingLoginPage.fillEmailInput(prop.getProperty("TRASHMAIL_EMAIL"));
        bookingLoginPage.fillPasswordInput(prop.getProperty("PASSWORD"));
        TimeUnit.SECONDS.sleep(5);
        boolean logo = driver.findElement(By.xpath("//*[@id='logo_no_globe_new_logo']")).isDisplayed();
        boolean homeIcon = driver.findElement(By.xpath("//*[@class='xpb__link selected']")).isDisplayed();
        boolean flightsIcon = driver.findElement(By.xpath("//*[@data-decider-header='flights']")).isDisplayed();
        boolean carRentalsIcon = driver.findElement(By.xpath("//*[@id='cross-product-bar']/div/a[2]")).isDisplayed();
        boolean attractionIcon = driver.findElement(By.xpath("//*[@id='cross-product-bar']/div/a[3]")).isDisplayed();
        boolean airportTaxisIcon = driver.findElement(By.xpath("//*[@id='cross-product-bar']/div/a[4]")).isDisplayed();
        boolean currencyIcon = driver.findElement(By.xpath("//*[contains(@aria-label, 'Select your currency')]")).isDisplayed();
        boolean languageIcon = driver.findElement(By.xpath("//*[contains(@data-title, 'Select your language')]")).isDisplayed();
        boolean emailIcon = driver.findElement(By.xpath("//*[contains(@aria-label, 'View your notifications')]")).isDisplayed();
        boolean questionIcon = driver.findElement(By.xpath("//*[contains(@class, 'uc_helpcenter')]")).isDisplayed();
        boolean propertyIcon = driver.findElement(By.xpath("//*[contains(@class, 'add-property__button')]")).isDisplayed();
        boolean avatarIcon = driver.findElement(By.xpath("//*[contains(@alt, 'Profile')]")).isDisplayed();
        boolean yourAccount = driver.findElement(By.xpath("//*[contains(@class, 'header_name')]")).isDisplayed();
    }

    @AfterClass
    public static void finishTest() {
        LOGGER.info("Test is finished");
    }

    public static void closeDriver() {
        Driver.getDriver(Config.CHROME).close();
        Driver.getDriver(Config.CHROME).quit();
    }
}
