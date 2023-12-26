package isp.lab8.airways;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AirwaysTest {

    @Test
    public void TestCalculateDistance(){
        Exercise exercise = new Exercise();
        List<Waypoint> waypoints = new ArrayList<>();
        waypoints.add(new Waypoint(1, "LRCL", 46.7852, 23.6862, 415));
        waypoints.add(new Waypoint(2, "TASOD", 47.0548, 23.9212, 10460));
        waypoints.add(new Waypoint(3, "SOPAV", 46.9804, 24.7365, 10900));
        waypoints.add(new Waypoint(4, "BIRGU", 45.9467, 26.0217, 10200));
        waypoints.add(new Waypoint(5, "LROP", 44.5711, 26.0858, 106));

        assertEquals(308.78, Exercise.calculateDistance(waypoints.get(0).getLatitude(),waypoints.get(0).getLongitude(),waypoints.get(4).getLatitude(),waypoints.get(4).getLongitude()),309);
    }

}
