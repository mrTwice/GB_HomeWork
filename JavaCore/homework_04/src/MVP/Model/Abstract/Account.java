package MVP.Model.Abstract;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Account {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int number=1;
    private double balance;

    protected Account(double balance) {
        this.number = count.incrementAndGet();
        this.balance = balance;
    }

    /**
     * Возвращает номер счета объекта
     * @return номер счета
     */
    public int getNumber() {
        return number;
    }

    /**
     * Возвращает текущий баланс по счету
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счета в указанное значение
     * @param balance требуемое значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Абстрактный метод внесения денежных средств на счет
     * @param cashAmount размер вносимой суммы
     * @return true в случае успешного исхода
     */
    public abstract boolean addFunds(double cashAmount);

    /**
     * Абстрактный метод снятия денежных средств со счета
     * @param cashAmount размер снимаемых средств
     * @return true в случае успешного исхода
     */
    public abstract boolean withdrawFunds(double cashAmount);

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
