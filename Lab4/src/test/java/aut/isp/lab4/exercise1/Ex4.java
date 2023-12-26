import aut.isp.lab4.exercise4.AquariumController;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Ex4 {

    @Test
    public void testToString(){
        AquariumController aquarium1 = new AquariumController("Steins","M321");

        aquarium1.setCurrentTime(7);
        aquarium1.setFeedingTime(2.3f);

        assertEquals("AquariumController{model = M321, manufacturer Steins, currentTime 7.0, feedingTime 2.3}", aquarium1.toString());
    }

    @Test
    public void testGetLightOnTime(){
        AquariumController aquarium1 = new AquariumController("Steins","M321");
        aquarium1.setLightOnTime(2.3f);

        assertEquals(2.3, aquarium1.getLightOnTime(),2.3);
    }
    @Test
    public void testGetLightOffTime(){
        AquariumController aquarium1 = new AquariumController("Steins","M321");
        aquarium1.setLightOffTime(4.3f);

        assertEquals(4.3, aquarium1.getLightOffTime(),4.3);
    }


}
