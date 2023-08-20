package Cars;

import Fuel.Fuel;
import Stations.GasStation;

//Расширить абстрактный класс «Cars.Car», добавить метод: подметать улицу.
// Создать конкретный автомобиль путём наследования класса «Cars.Car». Провести проверку принципа SRP
public class SweepingCar extends Car implements GasStation {

    public SweepingCar(String carBrand, String carModel, String carColor, String carBodyType, int numberOfWheels, Fuel fuelType, String transmissionType, double volEngine) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, transmissionType, volEngine);
    }

    public void toSweepStreet(){
        System.out.println("Едем подметать улицы");
    }


    @Override
    public void fueling() {
        Fuel fuel = this.getFuelType();
        System.out.println("Заправили полный бак " + fuel.getInfoOfFuelType());
    }
}
