package Hooks;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class WebHooks {

    @BeforeAll
    public static void driverSetup() {
        Configuration.pageLoadStrategy="eager";
    }

    @AfterAll
    public static void closeDriver(){
        getWebDriver().close();
    }

    @BeforeAll
    public static void allureSubthreadParallel(){
        String listenerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));
    }

    @Attachment(value = "screen",type = "image/png")
    public static byte[] saveAsScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @After
    public void onTestFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = Screenshots.takeScreenShotAsFile();
                InputStream targetStream = new FileInputStream(screenshot);
                Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
