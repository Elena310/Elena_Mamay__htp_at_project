package tests.booking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import webDriver.Config;
import webDriver.Driver;
import webPages.bookingPages.HomePage;
import webPages.bookingPages.ListOfHotelsPage;
import java.util.concurrent.TimeUnit;

public class OsloTripTest {
    private static final Logger LOGGER = LogManager.getLogger(OsloTripTest.class);

    WebDriver driver = Driver.getDriver(Config.CHROME);
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public void verifyStyleChanges() throws InterruptedException {
        driver.navigate().to("https://booking.com/");
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseOsloTrip("Осло", 1, 1);
        listOfHotelsPage.checkChangesInStyleOfAddressHotel();
        Assert.assertEquals("Color of address text is not correct",
                "rgba(255, 0, 0, 1)", listOfHotelsPage.getTextColor());
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