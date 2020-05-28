package tests.cucumberSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HighestPriceHotelSteps {
    private static final Logger LOGGER = LogManager.getLogger(HighestPriceHotelSteps.class);

    @Given("I start the test")
    public void printString() {
        LOGGER.info("Driver is started");
    }

    @When("I go to the page {string}")
    public void iOpenThePage(String string) {
        LOGGER.info("Home page is opened");
    }

    @And("I select any trip with parameters: city, date of arriving, duration, adults, rooms, children")
    public void iChooseAnyTripWithParametersCityDateOfArrivingDuration() {
        LOGGER.info("Trip is selected");
    }

    @And("I choose hotels with maximum price for the day")
    public void iFilterHotelsWithMinimumPrice() {
        LOGGER.info("Price is filtered by max. value for the day");
    }

    @And("I filter hotels starting with a low-cost")
    public void iFilterHotelsStartingWithALowCost() {
        LOGGER.info("Hotels are displayed starting with a low-cost");
    }

    @And("I compare price of hotel with daily price")
    public void iComparePriceOfHotelWithDailyHotelPrice() {
        LOGGER.info("Price is compared");
    }

    @Then("the price should be {string}")
    public void theResultShouldBe(String string, io.cucumber.datatable.DataTable dataTable) {
        LOGGER.info("price of hotel >= daily hotel price");
    }
}
