package MVP.Model.Entity;

import MVP.Model.AccountExceptions.InitialDepositException;
import MVP.Model.AccountExceptions.InsufficientFundsException;
import MVP.Model.AccountExceptions.NegativeDepositException;
import MVP.Model.Abstract.Account;

public class CreditAccount extends Account {
    private double limit;
    private double creditDebt;

    private CreditAccount(double balance, double limit) {
        super(balance);
        this.limit = limit;
        this.creditDebt = 0;
    }

    private CreditAccount(double limit) {
        this(limit, limit);
    }

    /**
     * Статический метод класса. Отвечает за создание объекта с начальными заданными параметрами
     * @param limit размер кредитного лимита по счету
     * @return объект класса
     * @throws  InitialDepositException в случае попытки создать счет с отрицательным начальным лимитом по счету
     */
    public static CreditAccount createNewCreditAccount(double limit) {
        if (limit < 0)
            throw new InitialDepositException("Невозможно создать кредитный счет с отрицательным лимитом", limit);
        return new CreditAccount(limit);
    }

    public double getLimit() {
        return limit;
    }

    public double getCreditDebt() {
        return creditDebt;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setCreditDebt(double creditDebt) {
        this.creditDebt = creditDebt;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
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
            throw new NegativeDepositException("Сумма вносимого депозита на кредитный счет не может быть отрицательной", cashAmount);
        super.setBalance(super.getBalance() + cashAmount);
        this.setCreditDebt(this.getCreditDebt() - cashAmount);
        return true;
    }

    /**
     * Публичный метод класса. Отвечает за снятие средст со счета
     * @param cashAmount размер снимаемой суммы
     * @return true в случае успеха
     * @throws NegativeDepositException  в случае отрицательной величины запрашиваемых средств
     * @throws InsufficientFundsException в случае недостатка денежных средств на счете или если лимит исчерпан.
     */
    @Override
    public boolean withdrawFunds(double cashAmount) {
        if (cashAmount < 0)
            throw new NegativeDepositException("Сумма снимаемых средств не может быть отрицательной", cashAmount);
        if (cashAmount > this.getBalance())
            throw new InsufficientFundsException("Недостаточно средств", super.getBalance(), cashAmount);
        if ( this.creditDebt == this.limit)
            throw  new InsufficientFundsException("Лимит средств исчерпан", this.getLimit() - this.getCreditDebt(), cashAmount);
        super.setBalance(super.getBalance() - cashAmount);
        this.setCreditDebt(this.getCreditDebt() + cashAmount);
        return true;
    }
}
