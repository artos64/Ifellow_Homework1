package PageObject.BaseSteps;

import PageObject.BaseElements.ChangeStatusElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import java.time.Duration;

import static Hooks.WebHooks.saveAsScreenshot;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static com.codeborne.selenide.Selenide.sleep;

public class ChangeStatusSteps extends ChangeStatusElements {


    @Step("Проверка смены статусов")
    @И("Проверка смены статусов задачи")
    public void checkAndChangeStatus(){
        String stateTask = stateTask();

        while(!stateTask().contains("ГОТОВО")) {
            if(stateTask.contains("СДЕЛАТЬ")) {
                clickInWork();
                sleep(1000L);
                checkState(stateTask,stateTask());
            }
            if (stateTask.contains("В РАБОТЕ")){
                clickBusiness();
                clickDone();
                sleep(1000L);
                checkState(stateTask,stateTask());
            }
            stateTask = stateTask();
        }
        saveAsScreenshot();
    }

    public String stateTask(){
        return activeStatusTask.shouldBe(Condition.visible,Duration.ofSeconds(10)).getText();
    }

    public void clickInWork(){
        buttonInProgress.shouldBe(Condition.visible,Duration.ofSeconds(15)).click();
    }

    public void checkState(String state1, String state2){
        assertNotEquals(state1,state2,
                "Состояние не изменилось");
    }

    public void clickBusiness(){
        buttonBusinessProcess.shouldBe(Condition.visible,Duration.ofSeconds(10)).click();
    }

    public void clickDone(){
        buttonDone.shouldBe(Condition.visible,Duration.ofSeconds(15)).click();
    }
}

