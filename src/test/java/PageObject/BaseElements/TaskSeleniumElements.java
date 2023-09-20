package PageObject.BaseElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskSeleniumElements {

    public static String url_test = "https://edujira.ifellow.ru/browse/TEST-28409";
    public static SelenideElement statusButton = $x("//li[@class='item item-right']//span[text()='Готово']").as("Статус задачи TestSelenium TEST-28409");
    public static SelenideElement taskVersion = $x("//li[@class='item item-right']//a[@title = 'Version 2.0 ']").as("Версия задачи TestSelenium TEST-28409");
    public static SelenideElement createButton = $x("//li[@id='create-menu']//a[@id='create_link']").as("Кнопка создания новой задачи");

}
