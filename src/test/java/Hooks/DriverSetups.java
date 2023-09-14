package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class DriverSetups {
    @BeforeAll
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDrivers/chromedriver117.exe");
        System.setProperty("selenide.browser","chrome");
        Configuration.startMaximized=true;
        Configuration.pageLoadStrategy="eager";
    }

    @AfterEach
    public void closeDriver(){
        WebDriverRunner.getWebDriver().close();
    }
}
