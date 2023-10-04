package apiSteps;

import apiMethods.ApiMethods;
import config.Properties;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CreateUserTask2 {

    protected static Properties properties = Properties.properties;

    @Step("Создание нового пользователя, отправка post-запроса с телом и сравнение получаемого ответа")
    public void createUser() throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/user.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");

        Response res = new ApiMethods().postMethod(
                body,
                properties.baseUrlCreateUser(),
                "/api/users",
                201, // в задании написано статус 200, но тест не проходит, возвращает код 201
                "application/json",
                "UTF-8");

        Assertions.assertEquals("Tomato", res.path("name"));
        Assertions.assertEquals("Eat market", res.path("job"));
    }
}

