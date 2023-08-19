package Vehicles;

import Engines.GasEngine;

public class GasCar extends CarCreate {

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
