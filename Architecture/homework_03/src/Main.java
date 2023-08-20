import Cars.Car;
import Cars.SweepingCar;
import Cars.TruckCar;
import Fuel.Diesel;
import Fuel.Petrol;

public class Main {
    public static void main(String[] args) {
        Car ford = new TruckCar("Ford", "Truck", "Orange", "Cамосвал", 6, new Diesel(), "Автоматическая", 6.3);
        Car GMC = new SweepingCar("GMC", "SweepingCar", "Orange", "Подметалка", 6, new Petrol(), "Автоматическая", 5.7);
        System.out.println(ford);
        System.out.println(ford.toService("Обслуживание началось " + ford.getCarModel()));
        ford.getFuelType();
        ((TruckCar) ford).fueling();
        ((TruckCar) ford).wipeTheWindshield();
        ((TruckCar) ford).wipeHeadlights();
        ((TruckCar) ford).wipeMirrorы();
        System.out.println(ford.toService("Обслуживание закончено "+ ford.getCarModel()));
        ((TruckCar) ford).toCarryCargo();
        ((TruckCar) ford).enableFogLights(true);
        ford.enableHeadlights(true);
        ford.enableWindshieldWipers(true);
        System.out.println("Включена передача " + ford.toGearShift());
        System.out.println(ford.toDrive());

        System.out.println();
        System.out.println();

        System.out.println(GMC);
        System.out.println(ford.toService("Обслуживание началось " + GMC.getCarModel()));
        GMC.getFuelType();
        ((SweepingCar) GMC).fueling();
        System.out.println(GMC.toService("Обслуживание закончено " + GMC.getCarModel()));
        ((SweepingCar) GMC).toSweepStreet();
        GMC.enableHeadlights(true);
        GMC.enableWindshieldWipers(true);
        System.out.println("Включена передача " + GMC.toGearShift());
        System.out.println(GMC.toDrive());
    }
}