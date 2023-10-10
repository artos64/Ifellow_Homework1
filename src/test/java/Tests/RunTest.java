package Tests;

import Hooks.WebHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"PageObject/BaseSteps","Hooks"},
        tags = "@Test",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "json:target/cucumber.json"}
)
public class RunTest extends WebHooks {

}
