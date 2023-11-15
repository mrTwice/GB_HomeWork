package MVP.Model.AccountExceptions;

public class NegativeDepositException extends IllegalArgumentException{
    private double cash;

    public double getCash(){
        return cash;
    }

    /**
     * Класс исключений выбрасываемый при попытке передать в метод отрицательную сумму.
     * @param message Сообщение, выводимое при попытке передать в метод отрицательную величину для вносимых денежных средств
     * @param cash передаваемое значение вносимых денежных средств
     */
    public NegativeDepositException(String message, double cash){
        super(message);
        this.cash = cash;
    }
}
