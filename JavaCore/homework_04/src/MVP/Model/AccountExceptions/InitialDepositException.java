package MVP.Model.AccountExceptions;

public class InitialDepositException extends IllegalArgumentException{
    private double balance;

    public double getBalance(){
        return  balance;
    }

    /**
     * Класс исключений выбрасываемый при попытке создать счет с отрицательным начальным балансом.
     * @param message Сообщение, ввыводимое при попытке создать счет с отрицательным начальным балансом.
     * @param balance передаваемое значение баланса.
     */
    public InitialDepositException(String message, double balance){
        super(message);
        this.balance = balance;
    }
    
}
