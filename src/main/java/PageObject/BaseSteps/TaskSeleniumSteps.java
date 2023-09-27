package PageObject.BaseSteps;

import PageObject.BaseElements.TaskSeleniumElements;
import io.cucumber.java.ru.Затем;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;

import java.time.Duration;

public class TaskSeleniumSteps extends TaskSeleniumElements{

    @Затем("Проверяем задачу на соответствие Версии и Статуса")
    public void checkVersionStatus(){
        Assertions.assertEquals(url_test, url(), "Ссылка не открыта");
        Assertions.assertEquals("СДЕЛАТЬ",
                statusButton.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Атрибут 'Статус' не соответствует");
        Assertions.assertEquals("Version 2.0",
                taskVersion.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Атрибут 'Версия' не соответствует");
    }
}
