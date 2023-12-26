package isp.lab4.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {

        List<Sensor> sensors = new ArrayList<Sensor>();

        sensors.add(new TemperatureSensor("Acasa", "Sensor1",12));
        sensors.add(new TemperatureSensor("Nu acasa", "Sensor2",8));
        sensors.add(new PressureSensor("Rosa", "Sensor3",10));
        sensors.add(new PressureSensor("Sora", "Sensor4",6));

        MonitoringService monitoringService = new MonitoringService(sensors);
        double averageTemperature = monitoringService.getAverageTemperatureSensors();
        System.out.println("Average temperature: " + averageTemperature);

        double averageAll = monitoringService.getAverageAllSensors();
        System.out.println("Average all : " + averageAll);
    }
}
