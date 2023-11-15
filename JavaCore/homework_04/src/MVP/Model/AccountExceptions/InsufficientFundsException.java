package MVP.Model.AccountExceptions;

public class InsufficientFundsException extends RuntimeException{

    private double balance;

    private double requestedAmount;

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Класс исключений выбрасываемый при запросе денежных средст сверх доступной величины
     * @param message выводимое соодщение
     * @param balance текущий баланс
     * @param requestedAmount запрашиваемые средства
     */
    public InsufficientFundsException(String message, double balance, double requestedAmount){
        super(message);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }
}
