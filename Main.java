/* Ryan Lee
 * CPSC-39-12704
 * 03-03-2026
 */

public class Main {
	public static void main(String[] args) {
		Car defaultCar = new Car();
		Car testCar = new Car(10982, "Toyota", "Prius", 2016, "CNG", "Blue", 12);
		
        System.out.println("Default Car Print Test:");
		System.out.println(defaultCar);
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Test Car Print Test:");
        System.out.println(testCar);
	}
}
