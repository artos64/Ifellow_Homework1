package PageObject.BaseSteps;

import PageObject.BaseElements.StartPageElements;
import com.codeborne.selenide.Condition;
import config.Properties;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.open;


public class StartPageSteps extends StartPageElements {

    protected static Properties properties = Properties.properties;

    @Step("Авторизация на сервисе eduJira")
    public void startEduJira(){

        open(properties.baseUrl());

        loginField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(properties.login());
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(properties.password());
        enterButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

    }
}

