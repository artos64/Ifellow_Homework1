package PageObject.BaseSteps;

import PageObject.BaseElements.WindowOfCreationElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.uk.То;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.UUID;

import static Hooks.WebHooks.saveAsScreenshot;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WindowOfCreationSteps extends WindowOfCreationElements {

    public static String nameNewTask = UUID.randomUUID().toString().substring(0,10);

    @Step("Клик на кнопку Создать")
    @Когда("Нажимаем на кнопку создать")
    public void clickCreate(){
        Assertions.assertEquals("Создать",
                createButton.shouldBe(visible, Duration.ofSeconds(10)).getText(),
                "Текст кнопки не соответствует");
        createButton.click();
        saveAsScreenshot();
    }

    @Step("Выбор типа задачи")
    @То("Выбираем Тип задачи \\\"([^\\\"]*)\\\"$")
    public void selectTypeTask(String typeTask){
        selectOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).click();
        selectOfWindowCreation.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        selectOfWindowCreation.sendKeys(typeTask);
        assertEquals(typeTask,selectOfWindowCreation.parent().getAttribute("data-query"),"Вставился неверный тип задачи");
        selectOfWindowCreation.sendKeys(Keys.ENTER);
        saveAsScreenshot();
    }

    @Step("Ввод темы {name}")
    @И("Вводим название темы \\\"([^\\\"]*)\\\"$")
    public void inputTheme(String name){
        nameNewTask = name + UUID.randomUUID().toString().substring(0,10);
        summaryOfWindowCreation.shouldBe(visible, Duration.ofSeconds(10)).setValue(nameNewTask);
        saveAsScreenshot();
    }

    @Step("Ввод описания {description}")
    @И("Вводим описание \\\"([^\\\"]*)\\\"$")
    public void inputDescription(String description){
        Selenide.switchTo().frame("mce_7_ifr");
        frameBody.sendKeys(description);
        Selenide.switchTo().defaultContent();
        saveAsScreenshot();
    }

    @Step("Выбор значения в селекте Исправить в значениях")
    @И("Выбираем значение в 'Исправить в версиях'")
    public void selectVersion(){
        elementRepair.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Выбор приоритета {namePriority}")
    @И("Выбираем приоритет \\\"([^\\\"]*)\\\"$")
    public void selectPriority(String namePriority){
        priorityField.shouldBe(visible, Duration.ofSeconds(10)).click();
        priorityField.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        priorityField.sendKeys(namePriority);
        assertEquals(namePriority,priorityField.parent().getAttribute("data-query"),"Вставился неверный приоритет");
        priorityField.sendKeys(Keys.ENTER);
        saveAsScreenshot();
    }

    @Step("Выбор метки {mark}")
    @И("Указываем метку \\\"([^\\\"]*)\\\"$")
    public void inputMark(String mark){
        markField.shouldBe(visible, Duration.ofSeconds(10)).setValue(mark).pressEnter();
        saveAsScreenshot();
    }

    @Step("Выбор окружения {environment}")
    @И("Вводим окружение \\\"([^\\\"]*)\\\"$")
    public void inputEnvironment(String environment){
        Selenide.switchTo().frame("mce_8_ifr");
        frameBody.sendKeys(environment);
        Selenide.switchTo().defaultContent();
        saveAsScreenshot();
    }

    @Step("Выбор затронутой версии")
    @И("Выбираем затронутую версию")
    public void selectAffectedVersion(){
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Выбираем связанную задачу")
    @И("Выбираем связанную задачу")
    public void selectAffectedTask(){
        elementAffectedVersions.shouldBe(visible, Duration.ofSeconds(10)).click();
        listAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Выбор задачи {nameTask}")
    @И("Выбираем задачу \\\"([^\\\"]*)\\\"$")
    public void selectTask(String nameTask){
        fieldAffectedTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        fieldAffectedTask.sendKeys(Keys.CONTROL+Keys.chord("A")+Keys.DELETE);
        fieldAffectedTask.sendKeys(nameTask);
        sleep(1000L);
        assertEquals(nameTask,fieldAffectedTask.parent().getAttribute("data-query"),"Вставилась неверная задача");
        fieldAffectedTask.sendKeys(Keys.ENTER);
        saveAsScreenshot();
    }

    @Step("Клик по кнопке Назначить меня")
    @И("Нажимаем на 'Назначить меня'")
    public void clickAssignedMe(){
        buttonAssigned.shouldBe(visible, Duration.ofSeconds(10)).click();
        saveAsScreenshot();
    }

    @Step("Проверка пуш окна")
    @И("Нажимаем на кнопку создать задачу с проверкой пуш окна")
    public void finalCreate(){
        createTask.shouldBe(visible, Duration.ofSeconds(10)).click();
        createTask.shouldNotBe(visible,Duration.ofSeconds(10));
        sleep(500L);
        assertTrue(successCreatedTaskWindow.is(visible),
                "Отсутсвует пуш-окно об успешном создании задачи");
        saveAsScreenshot();
    }

    @Step("Открываем созданную задачу")
    @Тогда("Находим созданную задачу с типом 'Ошибка'")
    public void findNewTask(){
        inputSearch.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(nameNewTask).pressEnter();
        saveAsScreenshot();
    }
}
