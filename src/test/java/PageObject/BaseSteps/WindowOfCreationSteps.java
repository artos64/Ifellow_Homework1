package PageObject.BaseSteps;

import PageObject.BaseElements.WindowOfCreationElements;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class WindowOfCreationSteps extends WindowOfCreationElements {
    @Step("Сравнение счетчика, поиск задачи")
    public void createTask() {
        assertEquals("Создание задачи", titleOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).getText(), "Текст заголовка не соответствует");
        selectOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).setValue("Ошибка"); // не работает
        summaryOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).setValue("Тема");
        buttonText.shouldBe(visible, Duration.ofSeconds(10)).click();
        ariaText.shouldBe(visible, Duration.ofSeconds(10)).setValue("Описание");
        elementRepair.shouldBe(visible, Duration.ofSeconds(10)).click();
        priorityField.shouldBe(visible, Duration.ofSeconds(10)); //не работает
        markField.shouldBe(visible, Duration.ofSeconds(10)).setValue("bugfix");
        buttonEnvironment.shouldBe(visible, Duration.ofSeconds(10)).click();
        ariaEnvironmentText.shouldBe(visible, Duration.ofSeconds(10)).setValue("Окружение");

        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        listAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        elementListAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        fieldAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).setValue("TEST-28409").pressEnter(); //ентер не всегда срабатывает
        sleep(10000);
        buttonAssigned.shouldBe(visible, Duration.ofSeconds(10)).click();
        sleep(10000);
        //прописать спринт

        inputCreate.shouldBe(visible, Duration.ofSeconds(10)).click();
        sleep(10000);




    }
}
