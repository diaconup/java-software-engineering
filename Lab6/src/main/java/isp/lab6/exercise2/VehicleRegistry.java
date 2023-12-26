package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
    private Set<Vehicle> vehicles = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean removeVehicle(String vin) {
        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vin)) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            vehicles.remove(vehicleToRemove);
            return true;
        } else {
            return false;
        }
    }

    public boolean containsVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vin)) {
                return true;
            }
        }

        return false;
    }

    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVin() + " " + vehicle.getLicensePlate() + " " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
        }
    }
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

}
