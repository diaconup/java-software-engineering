package isp.lab4.exercise2;

public class SmartPhone implements Chargeable{
    private int batteryLevel;

    public SmartPhone(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge(int duration) {
        int battery = batteryLevel;
        for(int i=0; i<=duration; i++){
            if (batteryLevel < 100) batteryLevel += 7;
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
