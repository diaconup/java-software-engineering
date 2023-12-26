package isp.lab3;
import isp.lab3.exercise3.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class VehicleTest {
    @Test
    public void testToStringMethod() {
        Vehicle vehicle1 = new Vehicle("Dacia","Sandero",135,'D');
        assertEquals("Dacia (Sandero) speed 135 fuel type D", vehicle1.toString());

    }
}
