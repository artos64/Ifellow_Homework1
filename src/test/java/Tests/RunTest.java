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
        //открытие проекта Test
        systemDashboardSteps.openProject();
        //получение счетчика кол-ва задач
        int hashText = openTasksSteps.memberTask();
        //отрытие задачи testSelenium
        openTasksSteps.findTask("TEST-28409");
        //проверка версии и статуса задачи testSelenium
        taskseleniumsteps.checkVersionStatus();
        //создаем новую задачу, наименование генерируем
        String nameTask ="Тема" + UUID.randomUUID().toString().substring(0,10);
        windowOfCreationSteps.createTask(nameTask);
        //переход к в проект Test для сравнения счетчика
        systemDashboardSteps.openProject();
        //проверяем через хеш-таблицу отличие в значении счетчика
        openTasksSteps.checkNumberOfTasks(hashText);
        //открываем созданную задачу
        openTasksSteps.findTask(nameTask);
        //проверяем изменение статусов (двигаем по статусам) и их соответствии на общей форме, т.е привязку кнопок к статусам
        //через конструкцию while
        changeStatusSteps.checkAndChangeStatus();
    }
}
