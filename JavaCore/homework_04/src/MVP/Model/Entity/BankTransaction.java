package MVP.Model.Entity;
import MVP.Model.Abstract.Account;
import MVP.Model.Abstract.Client;
import MVP.Model.Abstract.Transaction;
import MVP.Model.AccountExceptions.IncorrectAccountTransactionException;
import MVP.Model.AccountExceptions.IncorrectAmountTransactionException;
import MVP.Model.AccountExceptions.NullPointerClientHashMapException;

import java.util.HashMap;

public class BankTransaction extends Transaction {

    /**
     * Публичный метод класса. Отчевечает за перевод денежных средств между счетами
     * @param funds размер денежного перевода
     * @param senderAccount Номер счета списания
     * @param receiverAccount номер счета получателя
     * @param clients список клиентов
     * @return true в случае успешного выполнения
     * @throws IncorrectAmountTransactionException в случае указания некорректной величины
     * @throws IncorrectAccountTransactionException в случае ошибки в номере счета
     * @throws NullPointerClientHashMapException в случае отсутствия списка получателей
     */
    @Override
    public boolean sendMoneyToOtherClient(double funds, int senderAccount, int receiverAccount, HashMap<String, Client> clients) {
        if(funds == 0) throw new IncorrectAmountTransactionException("Введите корректную сумму для отправки", funds);
        if(senderAccount == 0) throw new IncorrectAccountTransactionException("Укажите номер счета списания денежных средств", senderAccount);
        if(receiverAccount == 0) throw new IncorrectAccountTransactionException("Укажите номер счета получателя ", receiverAccount);
        if(clients == null) throw new NullPointerClientHashMapException("Список адресатов не доступен", clients);
        Account sender = null;
        Account receiver = null;
        for (Client client: clients.values()) {
            for (Account account: client.getClientAccounts()) {
                if(account.getNumber() == senderAccount)
                    sender = account;
                if(account.getNumber() == receiverAccount)
                    receiver = account;
            }
        }
        if (sender == null || receiver == null)
            throw new RuntimeException("Проверьте реквизиты");
        sender.withdrawFunds(funds);
        receiver.addFunds(funds);
        return true;
    }
}
