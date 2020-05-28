package tests.cucumberSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BookingRegistrationSteps {
    private static final Logger LOGGER = LogManager.getLogger(BookingRegistrationSteps.class);

    @Given("\\({string})")
    public void iBeginMyTest(String string) {
      LOGGER.info("Driver is started");
    }

    @When("I navigate to the  home page {string}")
    public void iNavigateToTheHomePage(String string) {
        LOGGER.info("I'm on the trashmail home page");
    }

    @And("I open login page")
    public void iOpenLoginPage() {
        LOGGER.info("I'm on login page");
    }

    @And("I enter existing username")
    public void iEnterExistingUsername() {
        LOGGER.info("I enter existing username");
    }

    @And("I enter  existing password")
    public void iEnterExistingPassword() {
       LOGGER.info("I enter  existing password");
    }

    @And("I turn up on the my home page")
    public void iTurnUpOnTheMyHomePage() {
        LOGGER.info("I turn up on the my home page");
    }

    @And("I add new temporary email")
    public void iAddNewTemporaryEmail() {
        LOGGER.info("I added new temporary email ");
    }

    @When("I switch to home page {string}")
    public void iSwitchToHomePage(String string) {
        LOGGER.info("I'm on the booking home page");
    }

    @And("I choose registration option")
    public void iChooseRegistrationOption() {
        LOGGER.info("I navigate to registration screen");
    }

    @And("I enter new temporary trashmail email in the email address field")
    public void iEnterNewTemporaryTrashmailEmailInTheEmailAddressField() {
        LOGGER.info("I enter new temporary trashmail email in the email address field");
    }

    @And("I enter any new password in the password field")
    public void iEnterAnyNewPasswordInThePasswordField() {
        LOGGER.info("I enter any new password in the password field");
    }

    @And("I confirm my password in the confirm password field")
    public void iConfirmMyPasswordInTheConfirmPasswordField() {
        LOGGER.info("I confirm my password in the confirm password field");
    }

    @And("I create my account")
    public void iCreateMyAccount() {
        LOGGER.info("I created my new booking account");
    }

    @Then("I check that Welcome modal is displayed after successful registration")
    public void iCheckThatWelcomeModalIsDisplayedAfterSuccessfulRegistration() {
        LOGGER.info("Welcome modal is displayed after successful registration");
    }
}
