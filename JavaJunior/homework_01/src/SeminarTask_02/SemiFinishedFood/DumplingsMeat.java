package SeminarTask_02.SemiFinishedFood;

import SeminarTask_02.Interfaces.SemiFinishedFood;

/**
 * Пельмени
 */
public class DumplingsMeat implements SemiFinishedFood {
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
        return "Пельмени";
    }
}
