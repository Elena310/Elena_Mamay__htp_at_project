package tests.booking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.booking_pages.BookingLoginPage;
import web_pages.booking_pages.HeaderElementPage;
import java.io.IOException;

public class BookingHeaderTest {
    public  static String PATH = "/Users/natalliasamarava/Final/main.properties";
    private static final Logger LOGGER = LogManager.getLogger(BookingHeaderTest.class);

    WebDriver driver = Driver.getDriver();

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public  void isHeaderLoaded() throws IOException, InterruptedException {
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        bookingLoginPage.loginToBooking();
        HeaderElementPage headerElementPage = new HeaderElementPage(driver);

        Assert.assertTrue("logo is not displayed", headerElementPage.isLogoDisplayed());
        Assert.assertTrue("homeIcon is not displayed", headerElementPage.isHomeIconDisplayed());
        Assert.assertTrue("flightsIcon is not displayed", headerElementPage.isFlightsIconDisplayed());
        Assert.assertTrue("carRentalsIcon is not displayed", headerElementPage.isCarRentalsIconDisplayed());
        Assert.assertTrue("attractionsIcon is not displayed", headerElementPage.isAttractionsIconDisplayed());
        Assert.assertTrue("airportTaxisIcon is not displayed", headerElementPage.isAirportTaxisIconDisplayed());
        Assert.assertTrue("currencyIcon is not displayed", headerElementPage.isCurrencyIconDisplayed());
        Assert.assertTrue("languageIcon is not displayed", headerElementPage.isLanguageIconDisplayed());
        Assert.assertTrue("emailIcon is not displayed", headerElementPage.isEmailIconDisplayed());
        Assert.assertTrue("questionIcon is not displayed", headerElementPage.isQuestionIconDisplayed());
        Assert.assertTrue("propertyListIcon is not displayed", headerElementPage.isPropertyListIconDisplayed());
        Assert.assertTrue("avatarIcon is not displayed", headerElementPage.isAvatarIconDisplayed());
        Assert.assertTrue("yourAccount is not displayed", headerElementPage.isYourAccountDisplayed());
    }

   @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
