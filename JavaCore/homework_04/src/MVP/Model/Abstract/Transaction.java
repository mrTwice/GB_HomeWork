package MVP.Model.Abstract;

import java.util.HashMap;

public abstract class Transaction {
    /**
     * Абстрактный метод класса. Отвечает за перевод денежных средств между счетов
     * @param funds рамер перевода
     * @param senderAccount номер счета отправителя
     * @param receiverAccount номер счета получателя
     * @param clients список клиентов
     * @return true в случае успешного выполнения
     */
    public abstract boolean sendMoneyToOtherClient(double funds, int senderAccount, int receiverAccount, HashMap<String, Client> clients);
}
