package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    String fileName = "dealership.csv"; // storing csv file name

    // method that gets information from dealership and stores it
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)); // Buffered Reader that reads the dealership.csv

            // this is to store the dealership information
            String firstLine = bufferedReader.readLine(); // Only reads first line
            String[] firstLineParts = firstLine.split("\\|"); // splits first line into parts
            dealership = new Dealership(firstLineParts[0], firstLineParts[1], firstLineParts[2]); // stores parts

            // this is to store vehicles
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|"); // splits vehicle specs into parts
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                // adds new vehicle using split parts
                dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odometer, price));
            } bufferedReader.close();

        } catch (Exception e) {
            System.err.println("An error has occured: " + e.getMessage());
        }
        return dealership;
    }

    // method that saves dealership
    public void saveDealership(Dealership dealership) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName)); // writes in dealership

            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone()); //

            for (Vehicle vehicle : dealership.getAllVehicles()) { // prints vehicles in dealership
                writer.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
            writer.close(); // closes writer
            System.out.println("Dealership saved successfully!");

        } catch (Exception e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }


}

