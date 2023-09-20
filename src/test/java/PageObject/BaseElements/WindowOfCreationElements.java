package PageObject.BaseElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WindowOfCreationElements {
    public static SelenideElement titleOfWindowCreation = $x("//h2[@id='jira-dialog2__heading']").as("Заголовок окна создания задачи");
    public static SelenideElement selectOfWindowCreation = $x("//input[@id='issuetype-field']").as("Селект с типами задач");
    public static SelenideElement summaryOfWindowCreation = $x("//input[@id='summary']").as("Поле Тема");
    public static SelenideElement buttonText = $x("//li[@data-mode='source']//button[text()='Текст']").as("Кнопка переключения режима поля 'Описание'");
    public static SelenideElement ariaText = $x("//textarea[@name='description']").as("Поле для ввода описания");
    public static SelenideElement elementRepair = $x("//select[@id='fixVersions']//option[@value='10001']").as("Вариант выбора 'Version 2.0' в 'Исправленых версиях'");
    public static SelenideElement priorityField = $x("//input[@id='priority-field']").as("Поле 'Приоритет'");
    public static SelenideElement markField = $x("//textarea[@id='labels-textarea']").as("Поле 'Метки'");
    public static SelenideElement buttonEnvironment = $x("//textarea[@id='labels-textarea']").as("Кнопка переключения режима поля 'Окружение'");
    public static SelenideElement ariaEnvironmentText = $x("//textarea[@name='environment']").as("Поле для ввода окружения");

    public static SelenideElement elementAffectedVersions = $x("//select[@id='versions']//option[@value='10001']").as("Вариант выбора 'Version 2.0' в 'Затронутых версих'");

    public static SelenideElement listAffectedTask = $x("//select[@id='issuelinks-linktype']//option[@value='is duplicated by']").as("Список 'Связанные задачи'");
    public static SelenideElement elementListAffectedTask = $x("//select[@id='issuelinks-linktype']//option[@value='is duplicated by']").as("Значение в списке 'Связанные задачи'");

    public static SelenideElement fieldAffectedTask = $x("//textarea[@id='issuelinks-issues-textarea']").as("Поле 'Задачи' в блоке 'Связанные задачи'");

    public static SelenideElement buttonAssigned  = $x("//button[@data-field-id='#assignee']").as("Кнопка 'Назначить меня'");

    //прописать спринт

    public static SelenideElement inputCreate  = $x("//input[@id='create-issue-submit']").as("Кнопка 'Создать'");

    //node.xpath('.//ROOT/TAG[last()]/KEY_NAME')





}
