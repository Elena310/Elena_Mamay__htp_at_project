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

public class OsloTripTest {
    WebDriver driver = Driver.getDriver(Config.CHROME);
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

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

    @After
    public  void closeDriver(){
        driver.close();
        driver.quit();
    }
}