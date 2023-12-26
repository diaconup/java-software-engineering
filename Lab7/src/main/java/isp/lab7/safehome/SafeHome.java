package isp.lab7.safehome;

import java.util.Scanner;

public class SafeHome {

    private static DoorLockController doorLockController;

    public static void main(String[] args) {
        doorLockController = new DoorLockController();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to SafeHome! Please select your user type:");
            System.out.println("1. Admin");
            System.out.println("2. Tenant");

            int userTypeSelection = scanner.nextInt();

            if (userTypeSelection == 1) {
                handleAdminUser(scanner);
            } else if (userTypeSelection == 2) {
                handleTenantUser(scanner);
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void handleAdminUser(Scanner scanner) {
        System.out.println("Please enter your admin pin:");

        String adminPin = scanner.next();

        if (doorLockController.getMasterKey().getPin().equals(adminPin)) {
            while (true) {
                System.out.println("Welcome, admin! Please select an option:");
                System.out.println("1. Add tenant");
                System.out.println("2. Remove tenant");
                System.out.println("3. View access logs");
                System.out.println("4. Exit admin mode");

                int adminOptionSelection = scanner.nextInt();

                if (adminOptionSelection == 1) {
                    handleAddTenant(scanner);
                } else if (adminOptionSelection == 2) {
                    handleRemoveTenant(scanner);
                } else if (adminOptionSelection == 3) {
                    handleViewAccessLogs();
                } else if (adminOptionSelection == 4) {
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid admin pin. Please try again.");
        }
    }

    private static void handleTenantUser(Scanner scanner) {
        System.out.println("Please enter your pin:");

        String tenantPin = scanner.next();

        try {
            DoorStatus doorStatus = doorLockController.enterPin(tenantPin);

            System.out.println("Door is now " + doorStatus);
        } catch (InvalidPinException e) {
            System.out.println(e.getMessage());
        } catch (TooManyAttemptsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleAddTenant(Scanner scanner) {
        System.out.println("Please enter the new tenant's name:");

        String tenantName = scanner.next();

        System.out.println("Please enter the new tenant's pin:");

        String tenantPin = scanner.next();

        try {
            doorLockController.addTenant(tenantPin, tenantName);

            System.out.println("Tenant added successfully.");
        } catch (TenantAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleRemoveTenant(Scanner scanner) {
        System.out.println("Please enter the name of the tenant to remove:");

        String tenantName = scanner.next();

        try {
            doorLockController.removeTenant(tenantName);

            System.out.println("Tenant removed successfully.");
        } catch (TenantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleViewAccessLogs() {
        System.out.println("Access logs:");

        doorLockController.getAccessLogs();
    }
}

