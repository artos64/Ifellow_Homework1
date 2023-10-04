package tests;

import hooks.restAssuredHooks;
import apiSteps.RickAndMortyTask1;
import apiSteps.CreateUserTask2;
import config.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class RunTest extends restAssuredHooks {
    protected static Properties properties = Properties.properties;

    public final RickAndMortyTask1 rickAndMortyTask1 = new RickAndMortyTask1();
    public final CreateUserTask2 createUserTask2 = new CreateUserTask2();

    @DisplayName("Погружение в API")
    @Test
    public void rickAndMortyTest(){
        rickAndMortyTask1.gettingCharLog(properties.idPerson());
        rickAndMortyTask1.gettingInfoLastPerson();
        rickAndMortyTask1.gettingCharLogLastPerson();
        rickAndMortyTask1.comparingPerson();
    }

    @DisplayName("Углубление в API")
    @Test
    public void createUserTest2() throws IOException {
        createUserTask2.createUser();
    }
}
