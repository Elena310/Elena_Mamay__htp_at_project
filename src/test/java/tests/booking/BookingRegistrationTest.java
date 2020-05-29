package tests.booking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import settings.MainSteps;
import webDriver.Config;
import webDriver.Driver;
import webPages.bookingPages.BookingRegistrationPage;
import webPages.bookingPages.HomePage;
import webPages.trashMailPages.TrashmailManagerPage;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BookingRegistrationTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingRegistrationTest.class);

    public static String PATH = "/Users/natalliasamarava/Final/property.properties";
    WebDriver driver = Driver.getDriver(Config.CHROME);

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public void registerBookingUser() throws InterruptedException, IOException {
        Properties prop = MainSteps.getProperties(PATH);

        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        trashmailManagerPage.createTempEmail();
        String emailAddress = trashmailManagerPage.getTrashEmailAddress();
        driver.navigate().to("https://booking.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseRegistration();
        BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage(driver);
        bookingRegistrationPage.setEmailInput(emailAddress);
        TimeUnit.SECONDS.sleep(3);
        bookingRegistrationPage.setPasswordInput(prop.getProperty("PASSWORD"));
        bookingRegistrationPage.setConfirmedPasswordInput(prop.getProperty("PASSWORD"));
        bookingRegistrationPage.createAccount();
        TimeUnit.SECONDS.sleep(5);
        bookingRegistrationPage.modalIsDisplayed();
        Assert.assertEquals("Account is not created",true, bookingRegistrationPage.modalIsDisplayed());
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
