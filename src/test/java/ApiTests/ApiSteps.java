package ApiTests;


import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ApiSteps {

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

    public String gettingCharLog(String id){

        Response gettingCharLog = given()
                .baseUri(baseUrl)
                .when()
                .get("/character/" + id)
                .then()
                .log().all()
                .extract().response();
        charLog = new JSONObject(gettingCharLog.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpecies = new JSONObject(gettingCharLog.getBody().asString()).get("species").toString();
        charId = new JSONObject(gettingCharLog.getBody().asString()).get("id").toString();
        System.out.println(charLog);
        System.out.println(charSpecies);
        System.out.println(charId);
        return charId;
    }
    public String gettinglastEpisode(String number){

        Response gettinglastEpisode = given()
                .baseUri(baseUrl)
                .when()
                .get("/character/" + number)
                .then()
                .extract().response();
        episode = (new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("episode").length()-1);
        lastEpisode = new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
        System.out.println(lastEpisode);
        System.out.println(episode);
        return lastEpisode;
    }

    public String gettingInfoLastPerson(String number){

        Response gettinglastEpisode = given()
                .baseUri(baseUrl)
                .when()
                .get("/episode/" + number)
                .then()
                .extract().response();
        person = (new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("characters").length()-1);
        lastPerson = new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("characters").get(person).toString().replaceAll("[^0-9]", "");
        System.out.println(person);
        System.out.println(lastPerson);
        return lastPerson;
    }

    public String gettingCharLogLastPerson(String number){

        Response gettingCharLogLastPerson = given()
                .baseUri(baseUrl)
                .when()
                .get("/character/" + number)
                .then()
                .extract().response();
        charLog1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpecies1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).get("species").toString();
        charId1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).get("id").toString();
        System.out.println(charLog1);
        System.out.println(charSpecies1);
        System.out.println(charId1);
        return null;
    }

    public void compairingPerson(){

        Assertions.assertEquals(charSpecies, charSpecies1, "Раса не совпадает");
        System.out.println("Раса Морти Смита = " +  charSpecies + " и раса второго персонажа " + charSpecies1);
        Assertions.assertNotEquals(charLog, charLog1, "Локация не совпадает");
        System.out.println("Локация Морти Смита = " + charLog + " и локация второго персонажа " + charLog1);
    }
}
