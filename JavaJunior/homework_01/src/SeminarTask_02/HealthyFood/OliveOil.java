package SeminarTask_02.HealthyFood;

import SeminarTask_02.Interfaces.HealthyFood;

/**
 * Оливковое масло
 */
public class OliveOil implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Оливковое масло";
    }
}
