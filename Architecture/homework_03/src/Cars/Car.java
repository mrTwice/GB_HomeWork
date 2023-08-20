package Cars;

import Fuel.Fuel;

//Спроектировать абстрактный класс «Cars.Car» у которого должны быть
// свойства: марка, модель, цвет, тип кузова, число колёс, тип топлива, тип коробки передач, объём двигателя;
// методы: движение, обслуживание, переключение передач, включение фар, включение дворников.
public abstract class Car {
    private String carBrand;
    private String carModel;
    private String carColor;
    private String carBodyType;
    private int numberOfWheels;

    private Fuel fuelType;
    private String transmissionType;

    private double volEngine;

    public Car(String carBrand, String carModel, String carColor, String carBodyType, int numberOfWheels, Fuel fuelType, String transmissionType, double volEngine) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carBodyType = carBodyType;
        this.numberOfWheels = numberOfWheels;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.volEngine = volEngine;
    }

    public String toDrive(){
        return "Поехали";
    }

    public String toService(String toDo){
        return toDo;
    }

    public int toGearShift(){
        return 1;
    }

    public String enableHeadlights(boolean headlightState){
        if (headlightState) return "Фары включениы";
        return "Фары выключениы";
    }

    public String enableWindshieldWipers(boolean windshieldWipersState){
        if (windshieldWipersState) return "Дворники включениы";
        return "Дворники выключениы";
    }

    public String getCarBrand() {
        return carBrand;
    }


    public String getCarModel() {
        return carModel;
    }


    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarBodyType() {
        return carBodyType;
    }


    public int getNumberOfWheels() {
        return numberOfWheels;
    }


    public Fuel getFuelType() {
        return fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }


    public double getVolEngine() {
        return volEngine;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carBodyType='" + carBodyType + '\'' +
                '}';
    }
}
