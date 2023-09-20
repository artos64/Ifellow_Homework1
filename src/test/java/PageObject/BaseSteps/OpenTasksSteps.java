package PageObject.BaseSteps;

import PageObject.BaseElements.OpenTasksElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

public class OpenTasksSteps extends OpenTasksElements {

    @Step("Сравнение счетчика, поиск задачи")
    public void openTask(){
        String text = counterTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).text();
        System.out.println("Эта переменная равна: " + text);

        inputSearch.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue("TEST-28409").pressEnter();
    }

}
