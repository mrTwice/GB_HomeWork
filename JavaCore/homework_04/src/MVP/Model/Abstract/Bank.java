package MVP.Model.Abstract;

import java.util.HashMap;

public abstract class Bank {
    private String title;

    private Transaction transaction;
    private HashMap<String, Client> clients;

    protected Bank(String title, Transaction transaction) {
        this.title = title;
        this.transaction = transaction;
        clients = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public HashMap<String, Client> getListClients() {
        return clients;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Абстрактный метод добавления нового клиента
     * @param client новый клиент
     * @return true в случае успешного добавления нового клиента
     */
    public abstract boolean addClient(Client client);

    /**
     * Абстрактный метод поиска клиента по его номеру мобильного телефона
     * @param phoneNumber номер телефона
     * @return искомый клиент
     */
    public abstract Client findClientByPhoneNumber(String phoneNumber);

    /**
     * Абстрактный метод поиска клиента по его id
     * @param id номер клиента
     * @return искомый клиент
     */
    public abstract Client findClientByid(int id);
}
