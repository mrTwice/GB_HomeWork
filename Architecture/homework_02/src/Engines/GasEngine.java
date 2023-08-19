package Engines;

public class GasEngine implements EngineType{

    @Override
    public void information() {
        System.out.println("Бензиновый двигатель установлен");
    }
}
