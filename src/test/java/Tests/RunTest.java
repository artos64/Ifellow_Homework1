package Tests;

import Hooks.DriverSetups;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"PageObject/BaseSteps","Hooks"},
        tags = "@Test"
)
public class RunTest extends DriverSetups {

    @DisplayName("Тест от Ifellow по EduJira")
    @Test
    public void checkCreateTaskTest(){

    }
}
