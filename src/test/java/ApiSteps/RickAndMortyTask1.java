package ApiSteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RickAndMortyTask1 {

    public static String lastEpisode; //
    public static String lastPerson;
    public static String charId;

    public String charLog;
    public String charSpecies;
    public String baseUrl = "https://rickandmortyapi.com/api";
    public int episode;
    public int person;

    public String charLog1;
    public String charId1;
    public String charSpecies1;

    @Step
    public void gettingCharLog(String id){

        Response gettingCharLog = given()
                .header("Content-type","application/json")
                .header("charset","UTF-8")
                .baseUri(baseUrl)
                .when()
                .get("/character/" + id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        charLog = new JSONObject(gettingCharLog.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpecies = new JSONObject(gettingCharLog.getBody().asString()).get("species").toString();
        charId = new JSONObject(gettingCharLog.getBody().asString()).get("id").toString();
    }
    @Step
    public void gettinglastEpisode(){

        Response gettinglastEpisode = given()
                .baseUri(baseUrl)
                .when()
                .get("/character/" + charId)
                .then()
                .statusCode(200)
                .extract().response();
        episode = (new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("episode").length()-1);
        lastEpisode = new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
    }

    @Step
    public void gettingInfoLastPerson(){

        Response gettinglastEpisode = given()
                .baseUri(baseUrl)
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .extract().response();
        person = (new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("characters").length()-1);
        lastPerson = new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("characters").get(person).toString().replaceAll("[^0-9]", "");
    }

    @Step
    public void gettingCharLogLastPerson(){

        Response gettingCharLogLastPerson = given()
                .baseUri(baseUrl)
                .when()
                .get("/character/" + lastPerson)
                .then()
                .extract().response();
        charLog1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpecies1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).get("species").toString();
        charId1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).get("id").toString();
    }
    @Step
    public void compairingPerson(){

        Assertions.assertEquals(charSpecies, charSpecies1,
                "Раса не совпадает");
        System.out.println("Раса Морти Смита = " +  charSpecies + " и раса второго персонажа " + charSpecies1);

        Assertions.assertNotEquals(charLog, charLog1,
                "Локация не совпадает");
        System.out.println("Локация Морти Смита = " + charLog + " и локация второго персонажа " + charLog1);
    }

}
