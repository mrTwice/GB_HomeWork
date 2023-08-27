package Vehicles;

import Engines.GasEngine;

public class GasCar implements Car {

    public GasCar() {
        GasEngine engine = new GasEngine();
        engine.information();
        getEnergy();
    }

    @Override
    public void getEnergy() {
        System.out.println("Бак заправлен");
    }
}
