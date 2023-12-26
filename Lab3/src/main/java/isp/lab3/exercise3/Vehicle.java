package isp.lab3.exercise3;


public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    private static int count = 0;

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        count++;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public static int getCount() {
        return count;
    }

    public static void displayCount() {
        System.out.println("Number of Vehicle objects created: " + count);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle v = (Vehicle) o;
        return this.model.equals(v.getModel()) && this.type.equals(v.getType()) && this.speed == v.getSpeed() && this.fuelType == v.getFuelType();
    }

    @Override
    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Dacia", "Sandero", 150 , 'B');
        Vehicle vehicle2 = new Vehicle("Volkswagen","Passat", 200, 'D');
        Vehicle vehicle3 = new Vehicle("Dacia", "Sandero", 150 , 'B');

        System.out.println(vehicle1.getModel());
        System.out.println(vehicle1.getSpeed());
        System.out.println(vehicle1.getType());
        System.out.println(vehicle1.getFuelType());

        System.out.println(vehicle2.getModel());
        System.out.println(vehicle2.getSpeed());
        System.out.println(vehicle2.getType());
        System.out.println(vehicle2.getFuelType());

        System.out.println(vehicle1.equals(vehicle3));

        System.out.println(getCount());
    }
}
