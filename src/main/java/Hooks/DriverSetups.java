package Hooks;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class DriverSetups {

    @BeforeAll
    public static void driverSetup() {
        Configuration.pageLoadStrategy="eager";
    }

    @AfterEach
    public void closeDriver(){
        getWebDriver().close();
    }
}
