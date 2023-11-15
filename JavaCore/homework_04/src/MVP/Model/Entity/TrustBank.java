package MVP.Model.Entity;

import MVP.Model.Abstract.Bank;
import MVP.Model.Abstract.Client;
import MVP.Model.Abstract.Transaction;

public class TrustBank extends Bank {

    public TrustBank(String title) {
        super(title, new BankTransaction());
    }

    /**
     * Добавляет нового клиента в список клиентов банка
     * @param client запрашиваемый клиент
     * @return возвращает true в случае успешного добавления нового клиента
     * @throws RuntimeException в случае пустого списка
     */
    @Override
    public boolean addClient(Client client) {
        if(this.getListClients() == null)
            throw new RuntimeException("Список клиентов пуст");
        this.getListClients().put(client.getPhoneNumber(), client);
        return true;
    }

    /**
     * Находит клиента в списке клиентов банка по номеру телефона
     * @param phoneNumber
     * @return запрашиваемый клиент
     * @throws RuntimeException в случае отсутствия клиента с указанным номером телефона
     */
    @Override
    public Client findClientByPhoneNumber(String phoneNumber) {
        Client client = null;
        if(!this.getListClients().containsKey(phoneNumber))
            throw new RuntimeException("Клиента с таким номером не существует");
        client = getListClients().get(phoneNumber);
        return client;
    }

    /**
     * Возвращает клиента по его id
     * @param id номер запрашиваемого клиента
     * @return запрашиваемый клиент
     * @throws  RuntimeException в случае осутствия клиента с указанным id
     */
    @Override
    public Client findClientByid(int id) {
        Client client = null;
        for (Client found: this.getListClients().values()) {
            if(found.getId() == id)
                client = found;
        }
        if(client == null)
            throw new RuntimeException("Клиента с таким id не существует");
        return client;
    }
}
