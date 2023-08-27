import Factory.CarFactory;
import Factory.ElectroCarFactory;
import Factory.GasCarFactory;
import Vehicles.Car;
import Vehicles.ElectroCar;
import Vehicles.GasCar;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = createCarFactory("gas");
        Car car1 = carFactory.CreateCar();
    }

    static  CarFactory createCarFactory(String type){
        if(type.equalsIgnoreCase("Gas")){
            return new GasCarFactory();
        } else if(type.equalsIgnoreCase("Electro")){
            return  new ElectroCarFactory();
        } else throw new RuntimeException(type + "не реализован");
    }
}