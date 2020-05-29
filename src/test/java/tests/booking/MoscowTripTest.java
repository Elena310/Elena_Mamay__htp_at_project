package tests.booking;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import tests.cucumberSteps.BookingRegistrationSteps;
import webDriver.Config;
import webDriver.Driver;
import webPages.bookingPages.HomePage;
import webPages.bookingPages.ListOfHotelsPage;

import java.util.concurrent.TimeUnit;

public class MoscowTripTest {

    private static final Logger LOGGER = LogManager.getLogger(MoscowTripTest.class);

    WebDriver driver = Driver.getDriver(Config.CHROME);
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public void verifyPriceMoscowTrip() throws InterruptedException {
        driver.navigate().to("https://booking.com/");
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseMoscowTrip("Москва", 10, 5);
        listOfHotelsPage.checkMoscowPriceHotel();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() <= listOfHotelsPage.getCheapPriceHotelDay());
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
