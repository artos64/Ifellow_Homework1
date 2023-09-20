package Tests;

import Hooks.DriverSetups;
import PageObject.BaseSteps.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RunTest extends DriverSetups {

    public final StartPageSteps startPageSteps = new StartPageSteps();
    public final SystemDashboardSteps systemDashboardSteps = new SystemDashboardSteps();
    public final OpenTasksSteps openTasksSteps = new OpenTasksSteps();
    public final TaskSeleniumSteps taskseleniumsteps = new TaskSeleniumSteps();
    public final WindowOfCreationSteps windowOfCreationSteps = new WindowOfCreationSteps();
    public final ChangeStatusSteps changeStatusSteps = new ChangeStatusSteps();

    @DisplayName("Тест от Ifellow по EduJira")
    @Test
    public void checkCreateTaskTest(){
        //авторизация в джира
        startPageSteps.startEduJira();
        //
        systemDashboardSteps.openProject();
        //
        int hashText = openTasksSteps.memberTask();
        //
        openTasksSteps.findTask("TEST-28409");
        //
        taskseleniumsteps.checkVersionStatus();
        //
        String nameTask ="Тема" + UUID.randomUUID().toString().substring(0,10);
        //
        windowOfCreationSteps.createTask(nameTask);
        //
        systemDashboardSteps.openProject();
        //
        openTasksSteps.checkNumberOfTasks(hashText);
        //
        openTasksSteps.findTask(nameTask);
        //
        changeStatusSteps.checkAndChangeStatus();
    }
}
