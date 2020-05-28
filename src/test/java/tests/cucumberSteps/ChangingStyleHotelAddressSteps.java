package tests.cucumberSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChangingStyleHotelAddressSteps {
    private static final Logger LOGGER = LogManager.getLogger(ChangingStyleHotelAddressSteps.class);

    @Given("I begin to run test")
    public void iBeginToRunTest(){
        LOGGER.info("Test is launched");
    }

    @When("I navigate to the page {string}")
    public void iNavigateToThePage(String string) {
        LOGGER.info("I'm on the home page");
    }

    @And("I pick any trip with parameters: city, date of arriving, duration, adults, rooms, children")
    public void iPickAnyTripWithParametersCityDateOfArrivingDurationAdultsRoomsChildren() {
        LOGGER.info("Trip is selected");
    }

    @And("I choose hotels with {int} and {int} stars")
    public void iChooseHotelsWithAndStars(Integer int1, Integer int2) {
        LOGGER.info("Hotels are displayed with 3 and 4 stars");
    }

    @And("I scroll to the tenth hotel in the list of hotels")
    public void iScrollToTheTenthHotelInTheListOfHotels() {
        LOGGER.info("Tenth hotel is found");
    }

    @And("I move cursor to the address of tenth hotel")
    public void iMoveCursorToTheAddressOfTenthHotel() {
        LOGGER.info("Cursor is moved to the hotel address");
    }

    @And("I change background color of hotel address to green")
    public void iChangeBackgroundColorOfHotelAddressToGreen() {
        LOGGER.info("Background color of hotel address is green");
    }

    @And("I change text color of hotel address to red")
    public void iChangeTextColorOfHotelAddressToRed() {
        LOGGER.info("Text color of hotel address is changed to red");
    }

    @Then("I check that text color of hotel address is red")
    public void iCheckThatColorIsRed(){
        LOGGER.info("Text color of hotel address is red");
    }
}
