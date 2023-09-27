package PageObject.BaseSteps;

import PageObject.BaseElements.WindowOfCreationElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.uk.То;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.UUID;

public class WindowOfCreationSteps extends WindowOfCreationElements {

    public static String nameNewTask = UUID.randomUUID().toString().substring(0,10);

    @Когда("Нажимаем на кнопку создать")
    public void clickCreate(){
        Assertions.assertEquals("Создать",
                createButton.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Текст кнопки не соответствует");
        createButton.click();
    }

    @То("Выбираем Тип задачи \\\"([^\\\"]*)\\\"$")
    public void selectTypeTask(String typeTask){
        selectOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).click();
        selectOfWindowCreation.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        selectOfWindowCreation.sendKeys(typeTask);
        assertEquals(typeTask,selectOfWindowCreation.parent().getAttribute("data-query"),"Вставился неверный тип задачи");
        selectOfWindowCreation.sendKeys(Keys.ENTER);
    }


    @Затем("Вводим название темы \\\"([^\\\"]*)\\\"$")
    public void inputTheme(String name){
        nameNewTask = name + UUID.randomUUID().toString().substring(0,10);
        summaryOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).setValue(nameNewTask);
    }

    @И("Вводим описание \\\"([^\\\"]*)\\\"$")
    public void inputDescription(String description){
        Selenide.switchTo().frame("mce_7_ifr");
        frameBody.sendKeys(description);
        Selenide.switchTo().defaultContent();
    }

    @И("Выбираем значение в 'Исправить в версиях'")
    public void selectVersion(){
        elementRepair.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @И("Выбираем приоритет \\\"([^\\\"]*)\\\"$")
    public void selectPriority(String namePriority){
        priorityField.shouldBe(visible, Duration.ofSeconds(10)).click();
        priorityField.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        priorityField.sendKeys(namePriority);
        assertEquals(namePriority,priorityField.parent().getAttribute("data-query"),"Вставился неверный приоритет");
        priorityField.sendKeys(Keys.ENTER);
    }

    @И("Указываем метку \\\"([^\\\"]*)\\\"$")
    public void inputMark(String mark){
        markField.shouldBe(visible, Duration.ofSeconds(10)).setValue(mark).pressEnter();
    }

    @И("Вводим окружение \\\"([^\\\"]*)\\\"$")
    public void inputEnvironment(String environment){
        Selenide.switchTo().frame("mce_8_ifr");
        frameBody.sendKeys(environment);
        Selenide.switchTo().defaultContent();
    }

    @И("Выбираем затронутую версию")
    public void selectAffectedVersion(){
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @И("Выбираем связанную задачу")
    public void selectAffectedTask(){
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        listAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @И("Выбираем задачу \\\"([^\\\"]*)\\\"$")
    public void selectTask(String nameTask){
        fieldAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        fieldAffectedTask.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        fieldAffectedTask.sendKeys(nameTask);
        sleep(1000L);
        assertEquals(nameTask,fieldAffectedTask.parent().getAttribute("data-query"),"Вставилась неверная задача");
        fieldAffectedTask.sendKeys(Keys.ENTER);
    }

    @И("Нажимаем на 'Назначить меня'")
    public void clickAssignedMe(){
        buttonAssigned.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @И("Нажимаем на кнопку создать задачу с проверкой пуш окна")
    public void finalCreate(){
        createTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        createTask.shouldNotBe(visible,Duration.ofSeconds(10));
        sleep(500L);
        assertTrue(successCreatedTaskWindow.is(visible),"Отсутсвует пуш-окно об успешном создании задачи");
    }

    @Тогда("Находим нами созданную задачу")
    public void findNewTask(){
        inputSearch.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(nameNewTask).pressEnter();
    }
}
