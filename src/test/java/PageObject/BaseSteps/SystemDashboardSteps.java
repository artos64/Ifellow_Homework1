package PageObject.BaseSteps;

import PageObject.BaseElements.SystemDashboardElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

public class SystemDashboardSteps extends SystemDashboardElements {
    @Step("Переход к списку тестов")
    public void openProject(){

        HeadingText.shouldBe(Condition.visible, Duration.ofSeconds(10));
        listProjectText.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        buttonTest.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();


    }
}
