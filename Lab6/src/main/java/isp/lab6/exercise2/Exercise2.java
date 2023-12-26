package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();

        registry.addVehicle(new Vehicle("ABC123", "XYZ789", "Toyota", "Corolla", 2010));
        registry.addVehicle(new Vehicle("DEF456", "JKL012", "Honda", "Civic", 2015));
        registry.addVehicle(new Vehicle("GHI789", "MNO345", "Ford", "Fusion", 2020));
        registry.addVehicle(new Vehicle("ABC123", "PQR456", "Nissan", "Sentra", 2012));

        System.out.println(registry.containsVehicle("ABC123"));
        System.out.println(registry.containsVehicle("XYZ789"));

        registry.displayVehicles();
        registry.removeVehicle("DEF456");
        registry.displayVehicles();
    }
}
