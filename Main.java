/* Ryan Lee
 * CPSC-39-12704
 * 03-03-2026
 */

public class Main {
	public static void main(String[] args) {
        // Methods to load and display car data.
        CarDataManager dataManager = new CarDataManager();
        dataManager.loadCars("Car_Data.csv");

        // Verification of loaded data.
        dataManager.displayCarCount();

        // Displays the first 100 entries.
        dataManager.displayCars(100);


        
	}
}
