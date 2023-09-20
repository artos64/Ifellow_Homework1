package PageObject.BaseSteps;

import PageObject.BaseElements.TaskSeleniumElements;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;

import java.time.Duration;

public class TaskSeleniumSteps extends TaskSeleniumElements{

    @Step("Проверка версии и статуса задачи")
    public void checkVersionStatus(){
        Assertions.assertEquals(url_test, url(), "Ссылка не открыта");
        Assertions.assertEquals("СДЕЛАТЬ",
                statusButton.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Атрибут 'Статус' не соответствует");
        Assertions.assertEquals("Version 2.0",
                taskVersion.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Атрибут 'Верся' не соответствует");
    }
}
