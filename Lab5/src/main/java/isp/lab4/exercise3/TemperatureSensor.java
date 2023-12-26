package isp.lab4.exercise3;

public class TemperatureSensor extends Sensor{
    private double Temperature;

    public TemperatureSensor(String installLocation, String name, double temperature) {
        super(installLocation, name);
        Temperature = temperature;
    }

    public void setTemperature(double temperature) {
        Temperature = temperature;
    }

    public double getTemperature() {
        return Temperature;
    }
}
