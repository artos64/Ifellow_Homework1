package apiSteps;

import apiMethods.ApiMethods;
import config.Properties;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;


public class RickAndMortyTask1 {

    protected static Properties properties = Properties.properties;
    public String baseUrl = properties.baseUrlRickAndMorty();

    public static String lastEpisode;
    public static String lastPerson;

    public String charLog;
    public String charSpecies;

    public int episode;
    public int person;

    public String charLog1;
    public String charSpecies1;

    @Step("Отправляем get-запрос для нахождения по персонажу с id '{0}' последнего эпизода, где он учавствовал")
    public void gettingCharLog(String id){

        Response gettingCharLog = new ApiMethods().getMethod(
                baseUrl,
                "/character/" + id,
                200,
                "application/json",
                "UTF-8");

        charLog = new JSONObject(gettingCharLog.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpecies = new JSONObject(gettingCharLog.getBody().asString()).get("species").toString();
        episode = (new JSONObject(gettingCharLog.getBody().asString()).getJSONArray("episode").length()-1);
        lastEpisode = new JSONObject(gettingCharLog.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
        System.out.println(lastEpisode);
    }

    @Step("Отправляем get-запрос для нахождения последнего персонажа в последнем эпизоде")
    public void gettingInfoLastPerson(){

        Response gettinglastEpisode = new ApiMethods().getMethod(
                baseUrl,
                "/episode/" + lastEpisode,
                200,
                "application/json",
                "UTF-8");


        person = (new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("characters").length()-1);
        lastPerson = new JSONObject(gettinglastEpisode.getBody().asString()).getJSONArray("characters").get(person).toString().replaceAll("[^0-9]", "");
    }

    @Step("Отправляем get-запрос для нахождения локации последнего персонажа в последнем эпизоде")
    public void gettingCharLogLastPerson(){

        Response gettingCharLogLastPerson = new ApiMethods().getMethod(
                baseUrl,
                "/character/" + lastPerson,
                200,
                "application/json",
                "UTF-8");

        charLog1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpecies1 = new JSONObject(gettingCharLogLastPerson.getBody().asString()).get("species").toString();
    }
    @Step("Сравниваем значения персонажей")
    public void comparingPerson(){

        Assertions.assertEquals(charSpecies, charSpecies1,
                "Раса не совпадает");
        System.out.println("Раса Морти Смита = " +  charSpecies + " и раса второго персонажа " + charSpecies1);

        Assertions.assertNotEquals(charLog, charLog1,
                "Локация не совпадает");
        System.out.println("Локация Морти Смита = " + charLog + " и локация второго персонажа " + charLog1);
    }
}
