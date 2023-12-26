package isp.lab4.exercise3;

public class PressureSensor extends Sensor{
    private double Pressure;

    public PressureSensor(String installLocation, String name, double pressure) {
        super(installLocation, name);
        Pressure = pressure;
    }

    public void setPressure(double pressure) {
        Pressure = pressure;
    }

    public double getPressure() {
        return Pressure;
    }
}
