/* Ryan Lee
 * CPSC-39-12704
 * 03-03-2026
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        // Methods to load and display car data.
        CarDataManager dataManager = new CarDataManager();
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the number of car entries to load (1-50000): ");
        int numEntries = scnr.nextInt();
        dataManager.loadCars("Car_Data.csv", numEntries);

        // Verification of loaded data.
        dataManager.displayCarCount();

        // Display average mileage of loaded cars.
        System.out.println("---------------------------------------");
        dataManager.averageMileage();

        // Display first 10 entries of loaded car data.
        System.out.println("---------------------------------------");
        System.out.println("First 10 entries:");
        dataManager.displayCars(10);
        
        // Search for cars with CNG fuel type and display matching entries. (Project A)
        System.out.println("---------------------------------------");
        System.out.println("Cars with CNG fuel:");
        dataManager.fuelSearch("CNG");

        scnr.close();
        }
}