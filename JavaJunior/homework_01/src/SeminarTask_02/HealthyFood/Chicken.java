package SeminarTask_02.HealthyFood;

import SeminarTask_02.Interfaces.HealthyFood;

/**
 * Курица
 */
public class Chicken implements HealthyFood {
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
}
