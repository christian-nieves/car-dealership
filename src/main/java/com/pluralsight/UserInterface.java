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
                case 0 -> System.out.println("Thank you for visiting " + dealership.getName() + "!");
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

    }
    public void processGetByMakeModelRequest() {

    }
    public void processGetByYearRequest() {

    }
    public void processGetByColorRequest() {

    }
    public void processGetByMileageRequest() {

    }
    public void processGetByVehicleTypeRequest() {

    }
    public void processAddVehicleRequest() {

    }
    public void processRemoveVehicleRequest() {

    }
}

