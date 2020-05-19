package tests;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import webDriver.Config;
import webDriver.Driver;
import webPages.HomePage;
import webPages.ListOfHotelsPage;
import java.util.concurrent.TimeUnit;

public class ParisTripTest {

    WebDriver driver = Driver.getDriver(Config.CHROME);
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    @Test
    public void verifyPriceParisTrip() throws InterruptedException {
        driver.navigate().to("https://booking.com/");
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseParisTrip("Париж", 3, 10);
        TimeUnit.SECONDS.sleep(5);
        listOfHotelsPage.checkParisPriceHotel();
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() >= listOfHotelsPage.getExpensivePriceHotelDay() );

    }
    @After
    public void close(){
        driver.close();
        driver.quit();
    }
}
