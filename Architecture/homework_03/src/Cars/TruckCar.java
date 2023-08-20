package Cars;//Расширить абстрактный класс «Cars.Car», добавить метод: включение противотуманных фар, перевозка груза.
// Провести проверку принципа OCP.

import Fuel.Fuel;
import Stations.GasStation;
import Stations.WashStation;

public class TruckCar extends Car implements GasStation, WashStation {

    public TruckCar(String carBrand, String carModel, String carColor, String carBodyType, int numberOfWheels, Fuel fuelType, String transmissionType, double volEngine) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, transmissionType, volEngine);
    }

    public String enableFogLights(boolean fogLightsState){
        if(fogLightsState) return "Противотуманки включены";
        return "Противотуманки выключены";
    }

    public void toCarryCargo(){
        System.out.println("Товар погружен. В путь!");
    }

    @Override
    public void fueling() {
        Fuel fuel = this.getFuelType();
        System.out.println("Заправили полный бак " + fuel.getInfoOfFuelType());
    }

    @Override
    public void wipeTheWindshield() {
        System.out.println("Помыли стекло");
    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Протерли фары");
    }

    @Override
    public void wipeMirrorы() {
        System.out.println("Протерли зеркала");
    }
}
