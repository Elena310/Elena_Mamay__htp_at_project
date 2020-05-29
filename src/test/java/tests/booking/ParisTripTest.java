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

public class ParisTripTest {
    private static final Logger LOGGER = LogManager.getLogger(ParisTripTest.class);

    WebDriver driver = Driver.getDriver(Config.CHROME);
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    @BeforeClass
    public static void startTest() {
        LOGGER.info("Test is started");
    }

    @Test
    public void verifyPriceParisTrip() throws InterruptedException {
        driver.navigate().to("https://booking.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseParisTrip("Париж", 3, 10);
        TimeUnit.SECONDS.sleep(5);
        listOfHotelsPage.checkParisPriceHotel();
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() >= listOfHotelsPage.getExpensivePriceHotelDay() );

    }
    @AfterClass

    public void finishTest() {
        LOGGER.info("Test is finished");
    }
    public  void closeDriver() {
        Driver.getDriver(Config.CHROME).close();
        Driver.getDriver(Config.CHROME).quit();
    }



}
