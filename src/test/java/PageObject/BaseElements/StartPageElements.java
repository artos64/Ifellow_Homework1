package PageObject.BaseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class StartPageElements {

    public static SelenideElement loginField = $x("//input[@name= 'os_username']").as("Поле Логин");
    public static SelenideElement passwordField = $x("//input[@name= 'os_password']").as("Поле Пароль");
    public static SelenideElement enterButton = $x("//input[@value= 'Войти']").as("Кнопка Войти");

}
