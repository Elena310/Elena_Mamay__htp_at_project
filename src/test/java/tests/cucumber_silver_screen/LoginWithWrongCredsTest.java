package tests.cucumber_silver_screen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.silver_screen_pages.SilverHomePage;

public class LoginWithWrongCredsTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchCinemaByAnyWordTest.class);
    public static String PATH = "/Users/natalliasamarava/Final/SilverScreen.properties";
    WebDriver driver = Driver.getDriver();

    @Given("I turn up on the home page")
    public void iNavigateToTheApp() {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.openSilverHomePage();
        LOGGER.info("I'm on the home page");
    }

    @When("I login with wrong <login> and wrong <password>")
    public void iLoginWithLoginAndPassword() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.loginWithWrongCreds();
    }

    @Then("I see warning message")
    public void iSeeWarningMessage() {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        Assert.assertTrue("There is no warning message", silverHomePage.isWarningMessageDisplayed());


    }
}
