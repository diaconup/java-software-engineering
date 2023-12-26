package isp.lab4.exercise3;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MonitoringServiceTest extends TestCase {

    public void testGetAverageTemperatureSensors() {
        List<Sensor> sensors = new ArrayList<Sensor>();

        sensors.add(new TemperatureSensor("Acasa", "Sensor1",12));
        sensors.add(new TemperatureSensor("Nu acasa", "Sensor2",8));

        MonitoringService monitoringService = new MonitoringService(sensors);
        double averageTemperature = monitoringService.getAverageTemperatureSensors();
        assertEquals(10.0, averageTemperature);
    }

    public void testGetAverageAllSensors() {
        List<Sensor> sensors = new ArrayList<Sensor>();

        sensors.add(new TemperatureSensor("Acasa", "Sensor1",12));
        sensors.add(new TemperatureSensor("Nu acasa", "Sensor2",8));
        sensors.add(new PressureSensor("Rosa", "Sensor3",10));
        sensors.add(new PressureSensor("Sora", "Sensor4",6));

        MonitoringService monitoringService = new MonitoringService(sensors);
        double averageAll = monitoringService.getAverageAllSensors();
        assertEquals(9.0,averageAll);
    }
}