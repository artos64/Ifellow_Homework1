package PageObject.BaseSteps;

import PageObject.BaseElements.SystemDashboardElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Дано;
import io.qameta.allure.Step;
import java.time.Duration;

import static Hooks.WebHooks.saveAsScreenshot;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.*;


public class SystemDashboardSteps extends SystemDashboardElements {
    @Step("Переход в проект")
    @Дано("Осуществлен переход к списку тестов")
    public void openProject(){
        listProjectText.shouldBe(visible, Duration.ofSeconds(10)).click();
        assertTrue(listProjectText.is(Condition.visible),
                "Проекты");
        buttonTest.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }
}
