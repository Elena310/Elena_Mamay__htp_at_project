package tests.cucumber_silver_screen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilites.PtopertiesReader;
import web_driver.Driver;
import web_pages.silver_screen_pages.SilverHomePage;

public class SearchCinemaByAnyWordTest {
    private static final Logger LOGGER = LogManager.getLogger(SearchCinemaByAnyWordTest.class);
    public static String PATH = "/Users/natalliasamarava/Final/SilverScreen.properties";
    WebDriver driver = Driver.getDriver();

    @Given("I open an app")
    public void iOpenApp() {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.openSilverHomePage();
        LOGGER.info("I'm on Silver screen main page");
    }

    @When("I search for <search word> word")
    public void iSearchForSearchWord() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.searchMovieByWord(PtopertiesReader.getValueProperty("SEARCH_WORD", PATH));
        LOGGER.info("I enter word in search Field");
    }

    @Then("I see each  movie item in the list contains <search word> in the title or description")
    public void iSeeListOfMovieItems() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.searchWordInTitleAndDescription(PtopertiesReader.getValueProperty("SEARCH_WORD", PATH));
        Thread.sleep(5);
        LOGGER.info("each  movie item contains <search word>");
    }


}
