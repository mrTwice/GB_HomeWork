package MVP;

import MVP.Model.Abstract.Account;
import MVP.Model.Abstract.Bank;
import MVP.Model.Abstract.Client;
import MVP.Model.AccountExceptions.*;
import MVP.Model.Entity.BankClient;
import MVP.Model.Entity.CreditAccount;
import MVP.Model.Entity.DebitAccount;
import MVP.Model.Entity.TrustBank;

import java.util.InputMismatchException;
import java.util.Random;

public class Presenter {
    private Random random = new Random();
    private Bank bank;
    private  View view;

    private Presenter ( Bank bank, View view) {
        this.bank = bank;
        this.view = view;
    }

    public static Presenter createPresenter () {
        return new Presenter(new TrustBank("ООО Рога и Копыта"), new View());
    }

    /**
     * Метод начальной инициализации данных. Запускает основное меню
     */
    public void init() {
        this.bank.addClient(BankClient.createNewClient("Василий", "Петров", "23/12/1999", "79111234567", "qwerty"));
        this.bank.addClient(BankClient.createNewClient("Олег", "Иванов", "05/03/1987", "79110987654", "poiuyt"));
        for (Client client: this.bank.getListClients().values()) {
            client.openNewAccount(DebitAccount.createNewDebitAccount(random.nextDouble(0.0, 10000.0)));
            client.openNewAccount(CreditAccount.createNewCreditAccount(random.nextDouble(0.0, 500000.0)));
        }
        mainMenu();
    }

    /**
     *  Основное меню приложения
     */
    private void mainMenu() {
        boolean flag = false;
        while (!flag) {
            int idClient;
            Client client;
            int clientAccountNumber;
            Account clientAccount;
            switch (view.printMainMenu()) {
                case 1:
                    // 1. Получить список всех клиентов банка.
                    view.printBankClients(bank.getListClients());
                    break;
                case 2:
                    // 2. Получить список счетов клиента.
                    idClient = view.choiceClient(bank.getListClients());
                    client = bank.findClientByid(idClient);
                    view.printClientAccounts(client);
                    break;
                case 3:
                    // 3. Открыть новый счет.
                    idClient = view.choiceClient(bank.getListClients());
                    client = bank.findClientByid(idClient);
                    try {
                        client.openNewAccount(view.choiceAccountType());
                    } catch (InitialDepositException e) {
                        System.out.printf("Сообщение: %s\nВеличина баланса: %f\n", e.getMessage(), e.getBalance());
                    } catch (InputMismatchException e){
                        System.out.println("Вместо точки поставьте запятую!!!!");
                    }

                    break;
                case 4:
                    // 4. Внести средства на счет.
                    idClient = view.choiceClient(bank.getListClients());
                    client = bank.findClientByid(idClient);
                    clientAccountNumber = view.choiceClientAccountNumber(client);
                    clientAccount = client.getClientAccountByNumber(clientAccountNumber);
                    try {
                        clientAccount.addFunds(view.increaseAccountBalance());
                    } catch (NegativeDepositException e) {
                        System.out.printf("Сообщение: %s\nВеличина вносимых средств: %f\n", e.getMessage(), e.getCash());
                    }
                    catch (InputMismatchException e){
                        System.out.println("Вместо точки поставьте запятую!!!!");
                    }

                    break;
                case 5:
                    // 5. Снять средства со счета.
                    idClient = view.choiceClient(bank.getListClients());
                    client = bank.findClientByid(idClient);
                    clientAccountNumber = view.choiceClientAccountNumber(client);
                    clientAccount = client.getClientAccountByNumber(clientAccountNumber);
                    try {
                        clientAccount.withdrawFunds(view.deincreaseAccountBalance());
                    } catch (InsufficientFundsException e) {
                        System.out.printf("Сообщение: %s\nСредств на счету: %f\nРазмер запрашиваемых средств: %f\n", e.getMessage(), e.getBalance(), e.getRequestedAmount());
                    }
                    catch (InputMismatchException e){
                        System.out.println("Вместо точки поставьте запятую!!!!");
                    }
                    break;
                case 6:
                    // перевод между счетами
                    int senderId = view.choiceClient(bank.getListClients());
                    Client sender = bank.findClientByid(senderId);
                    int senderAccountNumber = view.choiceClientAccountNumber(sender);

                    int receiverId = view.choiceClient(bank.getListClients());
                    Client receiver = bank.findClientByid(senderId);
                    int receiverAccountNumber = view.choiceClientAccountNumber(receiver);
                    try {
                        bank.getTransaction().sendMoneyToOtherClient(view.amountTransaction(), senderAccountNumber, receiverAccountNumber, bank.getListClients());
                    } catch (IncorrectAccountTransactionException e) {
                        System.out.printf("Сообщение: %s\nHомер счета: %d\n", e.getMessage(), e.getAccountNumber());
                    } catch (IncorrectAmountTransactionException e) {
                        System.out.printf("Сообщение: %s\nВеличина вносимых средств: %f\n", e.getMessage(), e.getAmount());
                    } catch (NullPointerClientHashMapException e){
                        System.out.printf("Сообщение: %s\nПередаваемый список: %s\n", e.getMessage(), e.getClients());
                    }

                    break;
                default:
                    flag = view.exit();
            }
        }

    }
}
