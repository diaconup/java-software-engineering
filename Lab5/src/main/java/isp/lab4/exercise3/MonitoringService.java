package isp.lab4.exercise3;

import java.util.ArrayList;
import java.util.List;

public class MonitoringService {
    private TemperatureSensor temperatureSensor;
    private PressureSensor pressureSensor;
    List<Sensor> sensors = new ArrayList<Sensor>();

    public MonitoringService(List<Sensor> sensors) {
        this.sensors = sensors;
    }
    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public double getAverageTemperatureSensors(){
        double sum = 0;
        int count = 0;
        for(Sensor sensor : sensors){
            if(sensor instanceof TemperatureSensor){
                sum += ((TemperatureSensor) sensor).getTemperature();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    public double getAverageAllSensors(){
        double sum = 0;
        int count = 0;
        for(Sensor sensor : sensors){
            if(sensor instanceof TemperatureSensor){
                sum += ((TemperatureSensor) sensor).getTemperature();
                count++;
            }
            else{
                sum += ((PressureSensor) sensor).getPressure();
                count++;
            }}
        return count > 0 ? sum / count : 0;
    }
}
