package tests.cucumber_booking;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.booking_pages.HomePage;
import web_pages.booking_pages.ListOfHotelsPage;

import java.util.concurrent.TimeUnit;

public class SelectionTripTest {
    private static final Logger LOGGER = LogManager.getLogger(tests.booking.SelectionTripTest.class);
    WebDriver driver = Driver.getDriver();
    ListOfHotelsPage listOfHotelsPage = new ListOfHotelsPage(driver);

    @Before
    public static void startTest(){
        LOGGER.info("Test is started");
    }

    @Given("I choose {string} at {int} for {int}")
    public void goToMainPage(String nameOfCity, int arriving, int numberOfDays) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        homePage.chooseAnyTrip(nameOfCity, arriving, numberOfDays);
        TimeUnit.SECONDS.sleep(5);
        homePage.chooseDetailsOfTheTrip();
        LOGGER.info("Trip is selected");
    }

    @Then("^I verify Moscow Trip$")
    public void iVerifyPriceMoscowTrip() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.chooseAdultsAndRoomsUsingAction();
        listOfHotelsPage.checkMoscowPriceHotel();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() <= listOfHotelsPage.getCheapPriceHotelDay());
        LOGGER.info("Price is checked");
    }

    @Then("I verify color")
    public void verifyStyleChanges() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.chooseNumberOfChildren();
        homePage.checkPrice();
        listOfHotelsPage.checkChangesInStyleOfAddressHotel();
        Assert.assertEquals("Color of address text is not correct",
                "rgba(255, 0, 0, 1)", listOfHotelsPage.getTextColor());
        LOGGER.info("Style is changed");
    }

    @Then("^I verify Paris Trip$")
    public void verifyPriceParisTrip() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.chooseNumberOfAdults();
        homePage.chooseNumberOfAdults();
        homePage.chooseNumberOfRooms();
        homePage.checkPrice();
        listOfHotelsPage.checkParisPriceHotel();
        Assert.assertTrue("Information about price is incorrect",
                listOfHotelsPage.getRealPriceDayParisHotel() >= listOfHotelsPage.getExpensivePriceHotelDay() );
        LOGGER.info("Price is checked");
    }

    @After
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
