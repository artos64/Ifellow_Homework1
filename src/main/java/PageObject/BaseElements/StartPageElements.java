package PageObject.BaseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class StartPageElements {
    public SelenideElement loginField = $x("//input[@name= 'os_username']").as("Поле Логин");
    public SelenideElement passwordField = $x("//input[@name= 'os_password']").as("Поле Пароль");
    public SelenideElement enterButton = $x("//input[@value= 'Войти']").as("Кнопка Войти");
    public SelenideElement HeadingText = $x("//h1[text()='System Dashboard']").as("Заголовок System Dashboard");
}
