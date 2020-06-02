package tests.cucumber_booking;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilites.PtopertiesReader;
import web_driver.Driver;
import web_pages.booking_pages.BookingRegistrationPage;
import web_pages.booking_pages.HomePage;
import web_pages.trashmail_pages.TrashmailManagerPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BookingRegistrationTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingRegistrationTest.class);

    public  static String PATH = "/Users/natalliasamarava/Final/main.properties";

    WebDriver driver = Driver.getDriver();

    @Given("\\({string})")
    public void iBeginMyTest(String string) {
      LOGGER.info("Driver is started");
    }

    @When("I get temporary address")
    public void iGetTemporaryAddress() throws IOException, InterruptedException {
        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        trashmailManagerPage.createTempEmail();
        LOGGER.info("I got temporary address");
    }

    @And("I navigate to booking page")
    public void iGoToBookingPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);
        LOGGER.info("I'm on the booking home page");
    }

    @And("I choose registration option")
    public void iChooseRegistrationOption() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseRegistration();
        LOGGER.info("I navigate to registration screen");
    }

    @And("I enter new temporary email in the email address field")
    public void iEnterNewTemporaryEmailInTheEmailAddressField() throws InterruptedException {
        BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage(driver);
        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        bookingRegistrationPage.setEmailInput(trashmailManagerPage.getTrashEmailAddress());
        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("I enter new temporary trashmail email in the email address field");
    }

    @And("I enter new password in the password field")
    public void iEnterNewPasswordInThePasswordField() throws InterruptedException {
        BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage(driver);
        bookingRegistrationPage.setPasswordInput(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("I enter new password in the password field");
    }

    @And("I confirm my password and create new account")
    public void iConfirmMyPasswordInAndCreateNewAccount() throws InterruptedException {
        BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage(driver);
        bookingRegistrationPage.setConfirmedPasswordInput(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        bookingRegistrationPage.createAccount();
        TimeUnit.SECONDS.sleep(5);
        bookingRegistrationPage.modalIsDisplayed();
        LOGGER.info("I confirm my password and create new account");
    }

    @Then("I check that Welcome modal is displayed after successful registration")
    public void iCheckThatWelcomeModalIsDisplayedAfterSuccessfulRegistration() {
        BookingRegistrationPage bookingRegistrationPage = new BookingRegistrationPage(driver);
        Assert.assertEquals("Account is not created",true, bookingRegistrationPage.modalIsDisplayed());
        LOGGER.info("Welcome modal is displayed after successful registration");
    }

    @After
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
