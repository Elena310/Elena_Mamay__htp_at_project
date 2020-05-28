package runners.cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests"},
        features = {
                "src/test/resources/features/theHighestPriceHotelTest.feature",
                "src/test/resources/features/theLowestPriceHotelTest.feature",
                "src/test/resources/features/changingTheStyleOfHotelAddressTest.feature",
                "src/test/resources/features/visibilityOfHeaderPageTest.feature",
                "src/test/resources/features/bookingRegistrationWithTempEmailTest.feature"
        },
       // monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = false)

public class RunTests {

}
