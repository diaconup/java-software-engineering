package isp.lab3.exercise5;
import java.util.Scanner;


public class VendingMachine {
    private String[] products = {"Cola","Chips","Burger","Cookie"};
    private int credit;


    // Displays the available products and their IDs
    public String displayProducts() {
        for (int i = 0; i<=3; i++){
            return products[i];
        }
        return null;
    }

    // Adds the value of the coin to the current vending machine credit
    public int insertCoin(int value) {
        credit += value;
        System.out.println("Credit: " + credit);
        return credit;
    }

    // Returns the name of the selected product or an error message if the selection is invalid
    public String selectProduct(int id) {
        if (products[id] != null) {
            String product = products[id];
            if (credit >= 100) {
                credit -= 100;
                return product;
            } else {
                return "Insufficient credit. Please insert more coins.";
            }
        } else {
            return "Invalid selection. Please select a valid product ID.";
        }
    }

    // Displays the current available credit
    public void displayCredit() {
        System.out.println("Credit: " + credit);
    }

    // Provides a text based menu for interacting with the vending machine
    public void userMenu() {

        System.out.println("Please select an option:");
        boolean quit = false;
        while(!quit) {
            System.out.println("1: Display available products");
            System.out.println("2: Insert coin");
            System.out.println("3: Select product");
            System.out.println("4: Display credit");
            System.out.println("5: Exit");

            Scanner sc=new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    userMenu();
                    break;
                case 2:
                    System.out.println("Enter coin value: ");
                    int value = sc.nextInt();
                    insertCoin(value);
                    userMenu();
                    break;
                case 3:
                    System.out.println("Enter product selection:");
                    int id = sc.nextInt();
                    String message = selectProduct(id);
                    System.out.println(message);
                    userMenu();
                    break;
                case 4:
                    displayCredit();
                    userMenu();
                    break;
                case 5:
                    System.out.println("Thank you for using the Vending Machine!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    userMenu();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the vending machine!");

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(200);
        vendingMachine.displayProducts();
        vendingMachine.userMenu();
    }
}
