/* Ryan Lee
 * CPSC-39-12704
 * 03-03-2026
 */


public class Car {
	
	// Data Fields for Car specifications.
	private int id;
	private String brand;
	private String model;
	private int year;
	private String fuel;
	private String color;
	private double mileage;
	
	// Default Constructor.
	public Car() {
		id = 00000;
		brand = "N/A";
		model = "N/A";
		year = 0000;
		fuel = "N/A";
		color = "N/A";
		mileage = 0.0;
	}
	
	// Parameterized Constructor.
	public Car(int id, String brand, String model, int year, String fuel, String color, double mileage) {
		this.id = id;
		this.brand = brand;
		this.model= model;
		this.year = year;
		this.fuel = fuel;
		this.color = color;
		this.mileage = mileage;
	}
	
	// Setters for car data fields.
	public void setId(int id) {
		this.id = id;
	}

    public void setBrand(String brand) {
        this.brand = brand;
    }

	public void setModel(String model) {
		this.model = model;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setmileage(int mileage) {
		this.mileage = mileage;
	}
	
	// Getters for car data fields.
	public int getId() {
		return id;
	}

    public String getBrand() {
        return brand;
    }
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getFuel() {
		return fuel;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getMileage() {
		return mileage;
	}
	
    // toString printing car specifications.
	@Override
	public String toString() {
		return ("ID: " + id + " | Brand: " + brand + " | Model: " + model + " | Year: " + year + " | Fuel: " + fuel + " | Color: " + color + " | Mileage: " + mileage);
	}
	
}
