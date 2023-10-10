package PageObject.BaseSteps;

import PageObject.BaseElements.OpenTasksElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static Hooks.WebHooks.saveAsScreenshot;

import java.time.Duration;

public class OpenTasksSteps extends OpenTasksElements {

    public int storedHashText;

    @Step("Запоминаем кол-во задач в счетчике")
    @Затем("Запомнил количество задач")
    public void memberTask(){
        String text = counterTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
        int hashText = counterTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().hashCode();
        System.out.println("Эта переменная равна: \"" + text + "\"");
        System.out.println("Хеш-код = : \"" + hashText + "\"");
        storedHashText = hashText;
        saveAsScreenshot();
    }

    @Step("Сравниваем счет")
    @И("Сравниваем значение в счетчике")
    public void checkNumberOfTasks() {
        int hashTextFirst = storedHashText;
        memberTask();
        int hashTextSecond = storedHashText;
        assertNotEquals(hashTextFirst,hashTextSecond,
                "Значение количества задач не поменялось");
        saveAsScreenshot();
    }

    @Step("Осуществляем поиск задачи {numberTask}")
    @Затем("Находим задачу testSelenium \\\"([^\\\"]*)\\\"$")
    public void findTask(String numberTask){
        inputSearch.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(numberTask).pressEnter();
        saveAsScreenshot();
    }
}
