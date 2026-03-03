/* Ryan Lee
 * CPSC-39-12704
 * 03-03-2026
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CarDataManager {
    static ArrayList<Car> carData = new ArrayList<Car>();

    // Data Loader and aggregator for car data from CSV file.
    public void loadCars(String filename) {
        try {

            // Setup for file reading and parsing.
            File dataFile = new File(filename);
            Scanner scnr = new Scanner(dataFile);
            if (scnr.hasNextLine()) scnr.nextLine();

            // File reading process.
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    String rawId = parts[0];
                    int id = Integer.parseInt(rawId.replaceAll("[^0-9]", ""));
                    String brand = parts[1];
                    String model = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    String fuel = parts[4];
                    String color = parts[5];
                    double mileage = Double.parseDouble(parts[6]);
                    carData.add(new Car(id, brand, model, year, fuel, color, mileage));
                }
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Displays car data with a limit on the number of entries shown.
    public void displayCars(int limit) {
        int count = 0;
        for (Car car : carData) {
            if (count >= limit) break;
                System.out.println(car);
                count++;
        }
    }

    // Method to display total count of loaded cars.
    public void displayCarCount() {
        System.out.println("Total cars loaded: " + carData.size());
    }

    // Searches for cars by brand and returns matching entries.
    public void brandSearch(String brand) {
        boolean found = false;
        for (Car car : carData) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars found for brand: " + brand);
        }
    }

    // Searches for cars by fuel type and returns matching entries.
    public void fuelSearch(String fuelType) {
        boolean found = false;
        for (Car car : carData) {
            if (car.getFuel().equalsIgnoreCase(fuelType)) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars found for fuel type: " + fuelType);
        }
    }


    // Test method to verify results.
    /*
    public static void main(String[] args) {
        CarDataManagerAi loader = new CarDataManagerAi();
        loader.loadCars("Car_Data.csv");
        System.out.println("Total cars loaded: " + carData.size());
        for (int i = 0; i < Math.min(200, carData.size()); i++) {
            System.out.println(carData.get(i));
        }
    }
    */
}
