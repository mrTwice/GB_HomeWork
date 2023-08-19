import Vehicles.CarCreate;
import Vehicles.ElectroCar;
import Vehicles.GasCar;

public class Main {
    public static void main(String[] args) {
        CarCreate car = new ElectroCar();
        car = new GasCar();
    }
}