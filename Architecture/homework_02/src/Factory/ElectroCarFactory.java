package Factory;

import Vehicles.Car;
import Vehicles.ElectroCar;

public class ElectroCarFactory implements CarFactory{
    @Override
    public Car CreateCar() {
        return new ElectroCar();
    }
}
