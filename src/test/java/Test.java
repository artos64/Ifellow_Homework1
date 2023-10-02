import ApiTests.ApiSteps;

import static ApiTests.ApiSteps.*;

public class Test {
    public final ApiSteps apiSteps = new ApiSteps();

    @org.junit.jupiter.api.Test
    public void someTest(){
        apiSteps.gettingCharLog("2");
        apiSteps.gettinglastEpisode(charId);
        apiSteps.gettingInfoLastPerson(lastEpisode);
        apiSteps.gettingCharLogLastPerson(lastPerson);
        apiSteps.compairingPerson();
    }
    public void someTest1(){

    }

}
