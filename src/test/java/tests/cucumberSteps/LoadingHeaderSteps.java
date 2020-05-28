package tests.cucumberSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoadingHeaderSteps {
    private static final Logger LOGGER = LogManager.getLogger(LoadingHeaderSteps.class);

    @Given("I start")
    public void startTest(){
        LOGGER.info("Test is started");
    }

    @When("I turn up on the page {string}")
    public void iTurnUpOnThePage(String string) {
        LOGGER.info("I'm on the Booking page");
    }

    @And("I go to login page")
    public void iGoToLoginPage() {
        LOGGER.info("I'm on login page");
    }

    @And("I enter email address")
    public void iEnterEmailAddress() {
        LOGGER.info("I filled email address field");
    }

    @And("I enter password")
    public void iEnterPassword() {
       LOGGER.info("I filled password field");
    }

    @And("User is redirected to home page")
    public void userIsRedirectedToHomePage() {
        LOGGER.info("User is logged in");
    }

    @Then("the all elements in the header are displayed and consistent with {string}")
    public void theAllElementsInTheHeaderShouldBeDisplayedAndConsistentWith(String string, io.cucumber.datatable.DataTable dataTable) {
        LOGGER.info("All elements in the header are displayed");
    }
}
