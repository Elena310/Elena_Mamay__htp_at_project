package tests.cucumberSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LowestPriceHotelSteps {
    private static final Logger LOGGER = LogManager.getLogger(LowestPriceHotelSteps.class);

    @Given("Driver is started")
    public void setString(String string) {
        LOGGER.info("Driver is started");
    }

    @When("I open the page {string}")
    public void iOpenThePage(String string) {
        LOGGER.info("Home page is opened");
    }

    @And("I choose any trip with parameters: city, date of arriving, duration, adults, rooms, children")
    public void iChooseAnyTripWithParametersCityDateOfArrivingDuration() {
        LOGGER.info("Trip is selected");
    }

    @And("I filter hotels with minimum price")
    public void iFilterHotelsWithMinimumPrice() {
        LOGGER.info("Price is filtered by min. value for the day");
    }

    @And("I compare price of hotel with daily hotel price")
    public void iComparePriceOfHotelWithDailyHotelPrice() {
        LOGGER.info("Price is compared");
    }

    @Then("the result should be {string}")
    public void theResultShouldBe(String string, io.cucumber.datatable.DataTable dataTable) {
        LOGGER.info("price of hotel <= daily hotel price");
    }
}
