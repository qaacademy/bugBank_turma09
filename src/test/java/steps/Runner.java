package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"steps"}, tags = "@smoke and not @wip", publish = true, plugin = {"json:target/cucumber.json"})
public class Runner {

}
