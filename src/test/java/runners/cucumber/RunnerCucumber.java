package runners.cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.cucumber_silver_screen"},
        features = {
                "src/test/resources/features/WrongLogin.feature",

        },
       // monochrome = true,
        strict = false)

public class RunnerCucumber {

}
