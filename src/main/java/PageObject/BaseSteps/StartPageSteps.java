package PageObject.BaseSteps;

import PageObject.BaseElements.StartPageElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import config.Properties;
import io.cucumber.java.ru.*;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartPageSteps extends StartPageElements {

    protected static Properties properties = Properties.properties;

    @Дано("Пользователь открыт страницу авторизации на eduJira")
    public void openUrl(){
        open(properties.baseUrl());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Когда("Пользователь ввел логин и пароль")
    public void enterLoginAndPassword(){
        loginField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(properties.login());
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(properties.password());
    }

    @И("Нажал на кнопку Войти")
    public void enterButton(){
        enterButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Тогда("Он увидит заголовок System Dashboard")
    public void checkHeadling(){
        HeadingText.shouldBe(Condition.visible, Duration.ofSeconds(10));
        assertTrue(HeadingText.is(Condition.visible),
                "System Dashboard");
    }
}

