package tests.booking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import utilites.PtopertiesReader;
import web_driver.Driver;
import web_pages.booking_pages.BookingRegistrationPage;
import web_pages.booking_pages.HomePage;
import web_pages.trashmail_pages.TrashmailManagerPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BookingRegistrationTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingRegistrationTest.class);

    public static String PATH = "/Users/natalliasamarava/Final/main.properties";
    WebDriver driver = Driver.getDriver();

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public void registerBookingUser() throws InterruptedException, IOException {
        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        trashmailManagerPage.createTempEmail();
        String emailAddress = trashmailManagerPage.getTrashEmailAddress();
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        homePage.chooseRegistration();
        BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage(driver);
        bookingRegistrationPage.setEmailInput(emailAddress);
        TimeUnit.SECONDS.sleep(3);
        bookingRegistrationPage.setPasswordInput(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        TimeUnit.SECONDS.sleep(3);
        bookingRegistrationPage.setConfirmedPasswordInput(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        bookingRegistrationPage.createAccount();
        TimeUnit.SECONDS.sleep(5);
        bookingRegistrationPage.modalIsDisplayed();

        Assert.assertEquals("Account is not created",true, bookingRegistrationPage.modalIsDisplayed());
    }

    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
