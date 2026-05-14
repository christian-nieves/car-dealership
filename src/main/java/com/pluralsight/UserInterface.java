package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner myScanner = new Scanner(System.in);

    public void display() {
        init();

        int choice = -1;
        while (choice != 99) { // main menu
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

            choice = myScanner.nextInt(); // stores user input
            myScanner.nextLine();

            switch (choice) { // does method depending on what the user inputted
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

    // method that displays all vehicles
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.err.println("No Vehicles Found.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle); // prints every vehicle
        }

    }

    // method that gets all vehicles
    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles()); // prints all vehicles
    }

    // method that sorts vehicles by price
    public void processGetByPriceRequest() {

        System.out.print("Enter Minimum price: ");
        double min = myScanner.nextDouble();

        System.out.print("Enter Maximum price: ");
        double max = myScanner.nextDouble();
        myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min, max)); // prints vehicles that are in between the min and max
    }

    // method that sorts vehicles by make and model
    public void processGetByMakeModelRequest() {

        System.out.print("Enter Make: ");
        String make = myScanner.nextLine();

        System.out.print("Enter Model: ");
        String model = myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model)); // prints vehicle by make and model
    }

    // method that sorts vehicles by year
    public void processGetByYearRequest() {

        System.out.print("Enter Minimum Year: ");
        int min = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Maximum Year: ");
        int max = myScanner.nextInt();
        myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max)); // prints vehicle in the years provided
    }

    // method that sorts vehicles by color
    public void processGetByColorRequest() {

        System.out.print("Enter Color: ");
        String color = myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color)); // prints vehicle by color that user selected
    }

    // method that sorts vehicles by mileage
    public void processGetByMileageRequest() {

        System.out.print("Enter Minimum Mileage: ");
        int min = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Maximum Mileage: ");
        int max = myScanner.nextInt();
        myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max)); // prints vehicle in between min and max miles
    }

    // method that sorts vehicles by type
    public void processGetByVehicleTypeRequest() {

        System.out.print("Enter Vehicle Type (Car | Truck | SUV | Van): ");
        String type = myScanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type)); // prints vehicle type only
    }

    // method that adds vehicle
    public void processAddVehicleRequest(){

        System.out.print("Enter VIN: ");
        int vin = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Year: ");
        int year = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Make: ");
        String make = myScanner.nextLine();

        System.out.print("Enter Model: ");
        String model = myScanner.nextLine();

        System.out.print("Enter Vehicle Type (car, truck, SUV, van): ");
        String type = myScanner.nextLine();

        System.out.print("Enter Color: ");
        String color = myScanner.nextLine();

        System.out.print("Enter Odometer: ");
        int odometer = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("Enter Price: ");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price); // creates new vehicles
        dealership.addVehicle(vehicle); // adds vehicle to dealership
        new DealershipFileManager().saveDealership(dealership); // writes new vehicle in file
        System.out.println("Vehicle added successfully!"); // tells user that all went well
    }

    // method that removes vehicles
    public void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = myScanner.nextInt();
        myScanner.nextLine();

        for (Vehicle vehicle : dealership.getAllVehicles()) { // looks through list of vehicles
            if (vehicle.getVin() == vin) { // finds vin that matches user input
                dealership.removeVehicle(vehicle); // removes vehicle from dealership
                new DealershipFileManager().saveDealership(dealership); // deletes writing from file
                System.out.println("Vehicle removed successfully!"); // tells user it worked
                return;
            }
        }
        System.out.println("Vehicle with VIN " + vin + " not found.");
    }
}

