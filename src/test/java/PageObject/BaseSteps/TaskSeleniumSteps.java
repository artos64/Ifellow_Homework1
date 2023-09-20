package PageObject.BaseSteps;

import PageObject.BaseElements.TaskSeleniumElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.function.BooleanSupplier;

public class TaskSeleniumSteps extends TaskSeleniumElements{

    @Step("Проверка версии и статуса задачи")
    public void checkVersionStatus(){

        Assertions.assertEquals(url_test, url(), "Ссылка не открыта");
        //statusButton.shouldBe(visible, Duration.ofSeconds(10));
        //Assertions.assertTrue(statusButton.is(visible), "Элемент statusButton не найден"); — работает
        //String expectedResult = "ГОТОВО";
        Assertions.assertEquals("ГОТОВО", statusButton.shouldBe(visible, Duration.ofSeconds(10)).getText(), "Атрибут 'Статус' не соответствует");

        //taskVersion.shouldBe(visible, Duration.ofSeconds(10));
        Assertions.assertEquals("Version 2.0", taskVersion.shouldBe(visible, Duration.ofSeconds(10)).getText(), "Атрибут 'Верся' не соответствует");
        //Assertions.assertTrue(taskVersion.shouldBe(visible, Duration.ofSeconds(10)).getText().equals("Version 2.0"), "Атрибут 'Версия' не найден или не соответствует ожидаемому");

        //Assertions.assertTrue(taskVersion.shouldBe(visible, Duration.ofSeconds(10)).exists(), "Элемент 'Версия' не найден");
        //String actualText = taskVersion.getText();
        //Assertions.assertEquals("Version 2.0", actualText, "Текст 'Версия' не соответствует ожидаемому");

        Assertions.assertEquals("Создать", createButton.shouldBe(visible, Duration.ofSeconds(10)).getText(), "Текст кнопки не соответствует");
        createButton.click();




    }
}
