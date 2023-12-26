package isp.lab6.exercise1;
import isp.lab6.exercise2.Vehicle;
import isp.lab6.exercise2.VehicleRegistry;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestExercise2 {
    @Test
    public void testAdd(){
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle = new Vehicle("ABC123", "XYZ789", "Toyota", "Corolla", 2010);
        registry.addVehicle(vehicle);

        assertTrue(registry.containsVehicle("ABC123"));
        assertEquals(1, registry.getVehicles().size());
    }

    @Test
    public void testRemove(){
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle = new Vehicle("DEF456", "JKL012", "Honda", "Civic", 2015);
        registry.addVehicle(vehicle);

        assertTrue(registry.containsVehicle("DEF456"));

        registry.removeVehicle("DEF456");

        assertFalse(registry.containsVehicle("DEF456"));
        assertEquals(0, registry.getVehicles().size());
    }

    @Test
    public void testContains(){
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle1 = new Vehicle("GHI789", "MNO345", "Ford", "Fusion", 2020);
        Vehicle vehicle2 = new Vehicle("PQR012", "STU345", "Chevrolet", "Impala", 2012);
        registry.addVehicle(vehicle1);

        assertTrue(registry.containsVehicle("GHI789"));
        assertFalse(registry.containsVehicle("PQR012"));

        registry.addVehicle(vehicle2);

        assertTrue(registry.containsVehicle("PQR012"));
    }
}
