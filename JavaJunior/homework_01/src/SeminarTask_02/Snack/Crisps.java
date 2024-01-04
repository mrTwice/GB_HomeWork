package SeminarTask_02.Snack;

import SeminarTask_02.Interfaces.Snack;

/**
 * Чипсы
 */
public class Crisps implements Snack {
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
        return "Чипсы";
    }
}
