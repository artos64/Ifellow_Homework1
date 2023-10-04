package ApiSteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserTask2 {
    @Step
    public void createUser() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/user.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");
        Response gettingJson = given()
                .header("Content-type","application/json")
                .header("charset","UTF-8")
                .baseUri("https://reqres.in/")
                .body(body.toString())
                .when()
                .post("/api/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("Tomato"))
                .body("job", equalTo("Eat market"))
                .extract().response();
    }
}

