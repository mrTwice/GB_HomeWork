package Vehicles;

import Engines.ElectroEngine;

public class ElectroCar implements Car {
    public ElectroCar() {
        ElectroEngine engine = new ElectroEngine();
        engine.information();
        getEnergy();
    }

    @Override
    public void getEnergy() {
        System.out.println("Батарея заряжена");
    }
}
