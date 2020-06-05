package tests.cucumber_silver_screen;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.silver_screen_pages.SilverHomePage;

public class LoginToSilverScreenTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchCinemaByAnyWordTest.class);
    public static String PATH = "/Users/natalliasamarava/Final/SilverScreen.properties";
    WebDriver driver = Driver.getDriver();

    @Given("I navigate to the app")
    public void iNavigateToTheApp() {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.openSilverHomePage();
        LOGGER.info("I'm on the home page");
    }

    @When("I login with <login> and <password>")
    public void iLoginWithLoginAndPassword() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.loginToSilverScreen();
        LOGGER.info("I logged");
    }

    @Then("I can see Red Carpet Club <level> in upper right corner")
    public void iCanSeeRedCarpetClubLevel() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        Assert.assertTrue("Red Carpet Club level is not displayed", silverHomePage.isRedCarpetRedLevelDisplayed());
        Thread.sleep(3);
        LOGGER.info("Red Carpet Club level is displayed");
    }


}
