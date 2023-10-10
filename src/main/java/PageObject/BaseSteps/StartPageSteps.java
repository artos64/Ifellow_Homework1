package PageObject.BaseSteps;

import PageObject.BaseElements.StartPageElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import config.Properties;
import io.cucumber.java.ru.*;
import io.qameta.allure.Step;
import java.time.Duration;

import static Hooks.WebHooks.saveAsScreenshot;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartPageSteps extends StartPageElements {

    protected static Properties properties = Properties.properties;

    @Step("Переход на страницу авторизации")
    @Дано("Пользователь открыт страницу авторизации на eduJira")
    public void openUrl(){
        open(properties.baseUrl());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Step("Ввод данных: логин, пароль")
    @Когда("Пользователь ввел логин и пароль")
    public void enterLoginAndPassword(){
        loginField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(properties.login());
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(properties.password());
        saveAsScreenshot();
    }

    @Step("Клик по кнопке Войти")
    @И("Нажал на кнопку Войти")
    public void enterButton(){
        enterButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        saveAsScreenshot();
    }

    @Step("Проверка стартового заголовка")
    @Тогда("Он увидит заголовок System Dashboard")
    public void checkHeadling(){
        HeadingText.shouldBe(Condition.visible, Duration.ofSeconds(10));
        assertTrue(HeadingText.is(Condition.visible),
                "System Dashboard");
        saveAsScreenshot();
    }
}

