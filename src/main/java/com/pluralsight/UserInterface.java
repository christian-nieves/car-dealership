package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner myScanner = new Scanner(System.in);

    public void display() {
        init();

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== " + dealership.getName() + "=====");
            System.out.println("1. Find Vehicles by Price");
            System.out.println("2. Find Vehicles by Make and Model");
            System.out.println("3. Find Vehicles by Year");
            System.out.println("4. Find Vehicles by Color");
            System.out.println("5. Find Vehicles by Mileage");
            System.out.println("6. Find Vehicles by Type");
            System.out.println("7. List all Vehicles");
            System.out.println("8. Add a Vehicle");
            System.out.println("9. Remove a Vehicle");
            System.out.println("0. Quit");
            System.out.println("Your Choice: ");

            if (!myScanner.hasNextInt()) {
                System.err.println("Please enter a valid selection.");
                myScanner.nextLine();
                continue;
            }

            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1 -> ;
                case 2 -> ;
                case 3 -> ;
                case 4 -> ;
                case 5 -> ;
                case 6 -> ;
                case 7 -> ;
                case 8 -> ;
                case 9 -> ;
                case 0 -> System.out.println("Thank you for visiting " + dealership.getName() + "!");
                default -> System.err.println("Invalid choice!");
            }
        }
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }
}
