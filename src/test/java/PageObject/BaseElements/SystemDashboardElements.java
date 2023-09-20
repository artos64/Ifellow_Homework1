package PageObject.BaseElements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SystemDashboardElements {

    public static SelenideElement HeadingText = $x("//h1[text()='System Dashboard']").as("Заголовок System Dashboard");
    public static SelenideElement listProjectText = $x("//a[text()='Проекты']").as("Кнопка 'Проекты'");
    public static SelenideElement buttonTest = $x("//a[text()='Test (TEST)']").as("Кнопка проекта 'Test (TEST)'");
}
