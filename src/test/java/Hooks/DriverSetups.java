package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class DriverSetups {

    protected static Properties properties = Properties.properties;

    @BeforeAll
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver", properties.chromedriver());
        System.setProperty("selenide.browser","chrome");
        Configuration.startMaximized=true;
        Configuration.pageLoadStrategy="eager";
    }

    @AfterEach
    public void closeDriver(){
        WebDriverRunner.getWebDriver().close();
    }
}
