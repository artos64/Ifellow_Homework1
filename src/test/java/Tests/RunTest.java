package Tests;

import Hooks.DriverSetups;
import PageObject.BaseSteps.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunTest extends DriverSetups {

    @DisplayName("Тест от Ifellow по EduJira")
    @Test
    public void checkCreateTastTest(){

        StartPageSteps startPageSteps = new StartPageSteps();
        startPageSteps.startEduJira();
        sleep(3);

        SystemDashboardSteps systemDashboardSteps = new SystemDashboardSteps();
        systemDashboardSteps.openProject();
        sleep(15L);

        OpenTasksSteps openTasksSteps = new OpenTasksSteps();
        openTasksSteps.openTask();
        sleep(10);

        TaskSeleniumSteps taskseleniumsteps = new TaskSeleniumSteps();
        taskseleniumsteps.checkVersionStatus();

        sleep(10);

        WindowOfCreationSteps windowOfCreationSteps = new WindowOfCreationSteps();
        windowOfCreationSteps.createTask();

        //sleep(1000);



    }

}
