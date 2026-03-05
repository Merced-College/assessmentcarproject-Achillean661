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

    // Data Loader and aggregator for car data from CSV file for n number of entries.
    public void loadCars(String filename, int maxEntries) {
        try {
            int count = 0;
            // Setup for file reading and parsing.
            File dataFile = new File(filename);
            Scanner scnr = new Scanner(dataFile);
            if (scnr.hasNextLine()) scnr.nextLine();

            // File reading process.
            while (count < maxEntries && scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] parts = line.split(",");

                // Parsing data fields from cars.
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
                    count++;
                }
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Finds average mileage of cars in carData.
    public void averageMileage() {
        // Check if car data is empty before calculating for average to avoid errors.
        if (carData.isEmpty()) {
            System.out.println("No car data available to calculate average mileage.");
            return;
        }

        // Holder for total mileage to calculate average later.
        double totalMileage = 0;

        // Iterate through carData to summate mileage for average calculation.
        for (Car car : carData) {
            totalMileage += car.getMileage();
        }

        // Divides by total size of carData to calculate average and prints to 2 decimal places.
        double average = totalMileage / carData.size();
        System.out.printf("Average mileage of loaded cars: %.2f miles%n", average);
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

    // Insertion sort by fuel for use in fuelSearch method.
    private void sortByFuel(ArrayList<Car> list) {
        for (int i = 1; i < list.size(); i++) {
            Car key = list.get(i);
            String kfuel = key.getFuel().toLowerCase();
            int j = i - 1;
            while (j >= 0 && list.get(j).getFuel().toLowerCase().compareTo(kfuel) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Searches for fuel type using binary search on the loaded dataset.
    // Returns a list of all matching cars (empty list if none found), and prints them.
    public ArrayList<Car> fuelSearch(String fuel) {
        ArrayList<Car> results = new ArrayList<>();
        // work with a sorted copy so original order is preserved
        ArrayList<Car> list = new ArrayList<>(carData);
        sortByFuel(list);

        // binary search for one occurrence
        int left = 0, right = list.size() - 1;
        fuel = fuel.toLowerCase();
        int foundIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midFuel = list.get(mid).getFuel().toLowerCase();
            if (midFuel.equals(fuel)) {
                foundIdx = mid;
                break;
            } else if (midFuel.compareTo(fuel) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (foundIdx < 0) {
            System.out.println("No cars found for fuel type: " + fuel);
            return results;
        }

        // collect all matching entries around the found index
        int start = foundIdx;
        while (start > 0 && list.get(start - 1).getFuel().equalsIgnoreCase(fuel)) {
            start--;
        }
        int end = foundIdx;
        while (end + 1 < list.size() && list.get(end + 1).getFuel().equalsIgnoreCase(fuel)) {
            end++;
        }
        for (int i = start; i <= end; i++) {
            Car c = list.get(i);
            results.add(c);
            System.out.println(c);
        }
        return results;
    }


    // Test method to verify results.
    /*
    public static void main(String[] args) {
        CarDataManager loader = new CarDataManager();
        loader.loadCars("Car_Data.csv");
        System.out.println("Total cars loaded: " + carData.size());
        for (int i = 0; i < Math.min(200, carData.size()); i++) {
            System.out.println(carData.get(i));
        }
    }
    */
}
