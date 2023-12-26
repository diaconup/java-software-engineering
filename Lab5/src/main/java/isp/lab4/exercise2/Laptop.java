package isp.lab4.exercise2;


public class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge(int duration) {
        int battery = batteryLevel;
        for(int i=0; i<=duration; i++){
            if (batteryLevel < 100) batteryLevel += 2;
            System.out.print(batteryLevel + "%..");
        }
        battery = batteryLevel - battery;
        System.out.println('\n' + "The device has charged with:" + battery);
    }

    @Override
    public int getBatteryLevel() {
       return batteryLevel;
    }
}
