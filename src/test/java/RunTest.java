import ApiSteps.RickAndMortyTask1;
import ApiSteps.CreateUserTask2;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RunTest {
    public final RickAndMortyTask1 rickAndMortyTask1 = new RickAndMortyTask1();
    public final CreateUserTask2 createUserTask2 = new CreateUserTask2();

    @Test
    public void rickAndMortyTest(){
        rickAndMortyTask1.gettingCharLog("2");
        rickAndMortyTask1.gettinglastEpisode();
        rickAndMortyTask1.gettingInfoLastPerson();
        rickAndMortyTask1.gettingCharLogLastPerson();
        rickAndMortyTask1.compairingPerson();
    }

    @Test
    public void createUserTest2() throws IOException {
        createUserTask2.createUser();
    }

}
