package Factory;

import Vehicles.Car;
import Vehicles.GasCar;

public class GasCarFactory implements CarFactory{
    @Override
    public Car CreateCar() {
        return new GasCar();
    }
}
