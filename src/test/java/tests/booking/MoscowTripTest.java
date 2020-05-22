package tests.booking;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webDriver.Config;
import webDriver.Driver;
import webPages.bookingPages.HomePage;
import webPages.bookingPages.ListOfHotelsPage;
import java.util.concurrent.TimeUnit;

public class MoscowTripTest {
    WebDriver driver = Driver.getDriver(Config.CHROME);
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    @Test
    public void verifyPriceMoscowTrip() throws InterruptedException {
        driver.navigate().to("https://booking.com/");
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseMoscowTrip("Москва", 10, 5);
        listOfHotelsPage.checkMoscowPriceHotel();
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() <= listOfHotelsPage.getCheapPriceHotelDay());
    }

    @After
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
