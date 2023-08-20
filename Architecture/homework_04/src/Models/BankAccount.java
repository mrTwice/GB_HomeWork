package Models;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {

    private int balance;
    private long card;
    private long oldCard;



    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }


    public long getCard() {
        return card;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance){
        this.balance =balance;
    }
}
