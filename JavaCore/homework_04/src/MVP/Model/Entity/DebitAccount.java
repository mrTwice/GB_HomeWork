package MVP.Model.Entity;

import MVP.Model.AccountExceptions.InitialDepositException;
import MVP.Model.AccountExceptions.InsufficientFundsException;
import MVP.Model.AccountExceptions.NegativeDepositException;
import MVP.Model.Abstract.Account;

public class DebitAccount extends Account {

    private DebitAccount(double balance) {
        super(balance);
    }

    /**
     * Статический метод класса. Создает новый дебетовый счет
     * @param balance начальный баланс счета
     * @return вновь созданный счет
     * @throws InitialDepositException в случае попытки создать счет с отрицательным начальным балансом
     */
    public static DebitAccount createNewDebitAccount(double balance) {
        if (balance < 0)
            throw new InitialDepositException("Невозможно создать счет с отрицательным балансом", balance);
        return new DebitAccount(balance);
    }

    /**
     * Публичный метод класса. Отвечает за внесение денежных средств на счет
     * @param cashAmount размер вносимой суммы
     * @return true в случае успешного внесения средств
     * @throws NegativeDepositException при отрицательном размере вносимого депозита
     */
    @Override
    public boolean addFunds(double cashAmount) {
        if (cashAmount < 0)
            throw new NegativeDepositException("Сумма вносимого депозита не может быть отрицательной", cashAmount);
        super.setBalance(super.getBalance() + cashAmount);
        return true;
    }

    /**
     * Публичный метод класса. Отвечает за снятие средст со счета
     * @param cashAmount размер снимаемой суммы
     * @return true в случае успеха
     * @throws NegativeDepositException  в случае отрицательной величины запрашиваемых средств
     * @throws InsufficientFundsException в случае недостатка денежных средств на счете
     */
    @Override
    public boolean withdrawFunds(double cashAmount) {
        if (cashAmount < 0)
            throw new NegativeDepositException("Сумма снимаемых средств не может быть отрицательной", cashAmount);
        if (cashAmount > super.getBalance())
            throw new InsufficientFundsException("На счете не достаточно средств", super.getBalance(), cashAmount);
        super.setBalance(super.getBalance() - cashAmount);
        return true;
    }
}
