package tests.booking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.booking_pages.HomePage;
import web_pages.booking_pages.ListOfHotelsPage;
import java.util.concurrent.TimeUnit;

public class SelectionTripTest {

    private static final Logger LOGGER = LogManager.getLogger(SelectionTripTest.class);
    WebDriver driver = Driver.getDriver();
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    public void goToMainPage(String nameOfCity, int arriving, int numberOfDays) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        homePage.chooseAnyTrip(nameOfCity, arriving, numberOfDays);
        TimeUnit.SECONDS.sleep(5);
        homePage.chooseDetailsOfTheTrip();
    }

    @Test
    public void verifyPriceMoscowTrip() throws InterruptedException {
        goToMainPage("Москва", 10, 5);
        HomePage homePage = new HomePage(driver);
        homePage.chooseAdultsAndRoomsUsingAction();
        listOfHotelsPage.checkMoscowPriceHotel();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() <= listOfHotelsPage.getCheapPriceHotelDay());
    }

    @Test
    public void verifyStyleChanges() throws InterruptedException {
        goToMainPage("Осло", 1, 1);
        HomePage homePage = new HomePage(driver);
        homePage.chooseNumberOfChildren();
        homePage.checkPrice();
        listOfHotelsPage.checkChangesInStyleOfAddressHotel();
        Assert.assertEquals("Color of address text is not correct",
                "rgba(255, 0, 0, 1)", listOfHotelsPage.getTextColor());
    }

    @Test
    public void verifyPriceParisTrip() throws InterruptedException {
        goToMainPage("Париж", 3, 10);
        HomePage homePage = new HomePage(driver);
        homePage.chooseNumberOfAdults();
        homePage.chooseNumberOfAdults();
        homePage.chooseNumberOfRooms();
        homePage.checkPrice();
        listOfHotelsPage.checkParisPriceHotel();
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() >= listOfHotelsPage.getExpensivePriceHotelDay() );
    }

    @After
    public void deleteCookies() {
        Driver.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void closeDriver(){
        Driver.closeDriver();
    }
}
