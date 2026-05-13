package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DealershipFileManager {

    String fileName = "dealership.csv";

    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split("\\|");
            dealership = new Dealership(firstLineParts[0], firstLineParts[1], firstLineParts[2]);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odometer, price));
            } bufferedReader.close();

        } catch (Exception e) {
            System.err.println("An error has occured: " + e.getMessage());
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {

    }
}
