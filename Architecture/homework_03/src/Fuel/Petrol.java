package Fuel;

public class Petrol extends Fuel{
    private static final String fuelType = "Petrol";
    @Override
    public String getInfoOfFuelType() {
        return this.fuelType;
    }
}
