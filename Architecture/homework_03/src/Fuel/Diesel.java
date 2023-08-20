package Fuel;

public class Diesel extends Fuel{
    private static final String fuelType = "Diesel";
    @Override
    public String getInfoOfFuelType() {
        return this.fuelType;
    }
}
