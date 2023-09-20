package PageObject.BaseSteps;

import PageObject.BaseElements.SystemDashboardElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class SystemDashboardSteps extends SystemDashboardElements {
    @Step("Переход к списку тестов")
    public void openProject(){
        //Ассерт тут по факту не нужен,т.к. мы проверяем все через shouldBe, но по заданию попросили
        //в каждый степ их добавить
        listProjectText.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        assertTrue(listProjectText.is(Condition.visible),"Проекты");
        buttonTest.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
