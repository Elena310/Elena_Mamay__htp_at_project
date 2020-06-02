package tests.cucumber_booking;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import tests.booking.BookingHeaderTest;
import utilites.PtopertiesReader;
import web_driver.Driver;
import web_pages.booking_pages.BookingLoginPage;
import web_pages.booking_pages.HeaderElementPage;
import web_pages.booking_pages.HomePage;

import java.util.concurrent.TimeUnit;

public class LoadingHeaderTest {
    private static final Logger LOGGER = LogManager.getLogger(LoadingHeaderTest.class);
    public  static String PATH = "/Users/natalliasamarava/Final/main.properties";

    WebDriver driver = Driver.getDriver();

    @Given("I start")
    public void startTest(){
        LOGGER.info("Test is started");
    }

    @When("I go to booking page")
    public void iGoToBookingPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LOGGER.info("I'm on the Booking page");
    }
    @And("I go to login page")
    public void iGoToLoginPage() throws InterruptedException {
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        bookingLoginPage.goToLoginPage();
        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("I'm on login page");
    }

    @And("I enter email address")
    public void iEnterEmailAddress() {
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        bookingLoginPage.fillEmailInput(PtopertiesReader.getValueProperty("TRASHMAIL_EMAIL", PATH));
        LOGGER.info("I filled email address field");
    }

    @And("I enter password")
    public void iEnterPassword() throws InterruptedException {
       BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
       bookingLoginPage.fillPasswordInput(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        TimeUnit.SECONDS.sleep(5);
        LOGGER.info("I filled password field");
    }

    @Then("I check that all elements in the header are displayed")
    public void checkHeaderElements() {
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
        LOGGER.info("All elements in the header are displayed");
    }

    @After
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
