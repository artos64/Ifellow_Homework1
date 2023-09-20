package PageObject.BaseSteps;

import PageObject.BaseElements.OpenTasksElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Duration;

public class OpenTasksSteps extends OpenTasksElements {

    @Step("Запоминаем количество тестов")
    public int memberTask(){
        String text = counterTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
        int hashText = counterTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().hashCode();
        System.out.println("Эта переменная равна: \"" + text + "\"");
        System.out.println("Хеш-код = : \"" + hashText + "\"");
        return hashText;
    }

    @Step("Сравнение счетчика, поиск задачи")
    public void checkNumberOfTasks(int hashText){
        assertNotEquals(hashText,memberTask(),"Значение количества задач не поменялось");
    }

    @Step("Поиск задачи '{numberTask}'")
    public void findTask(String numberTask){
        inputSearch.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(numberTask).pressEnter();
    }

}
