package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner myScanner = new Scanner(System.in);

    public void display() {
        init();

        int choice = -1;
        while (choice != 99) {
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
            System.out.println("99. Quit");
            System.out.println("Your Choice: ");

            if (!myScanner.hasNextInt()) {
                System.err.println("Please enter a valid selection.");
                myScanner.nextLine();
                continue;
            }

            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Thank you for visiting " + dealership.getName() + "!");
                default -> System.err.println("Invalid choice!");
            }
        } myScanner.close();
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.err.println("No Vehicles Found.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processGetByPriceRequest() {

        System.out.print("Enter Minimum price: ");
        double min = myScanner.nextDouble();

        System.out.print("Enter Maximum price: ");
        double max = myScanner.nextDouble();
        myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {

        System.out.print("Enter Make: ");
        String make = myScanner.nextLine();

        System.out.print("Enter Model: ");
        String model = myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {

        System.out.print("Enter Minimum Year: ");
        int min = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Maximum Year: ");
        int max = myScanner.nextInt();
        myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest() {

        System.out.print("Enter Color: ");
        String color = myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {

        System.out.print("Enter Minimum Mileage: ");
        int min = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Maximum Mileage: ");
        int max = myScanner.nextInt();
        myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {

        System.out.print("Enter Vehicle Type (Car | Truck | SUV | Van): ");
        String type = myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }
}

