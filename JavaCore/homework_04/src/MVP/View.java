package MVP;

import MVP.Model.Abstract.Account;
import MVP.Model.Abstract.Client;
import MVP.Model.Entity.CreditAccount;
import MVP.Model.Entity.DebitAccount;

import java.util.HashMap;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводит в консоль основное меню. Возвращает выбранный пункт.
     * @return Выбранный пункт меню
     */
    public int printMainMenu(){
        System.out.println("1. Получить список всех клиентов банка.\n" +
                "2. Получить список счетов клиента.\n" +
                "3. Открыть новый счет.\n" +
                "4. Внести средства на счет.\n" +
                "5. Снять средства со счета.\n" +
                "6. Перевести между счетами.\n");
        System.out.print("Выберете пункт меню: ");
        return scanner.nextInt();

    }

    /**
     * Метож распечатывает счета клиента
     * @param client объект чьи счета будет выведены в консоль
     */
    public void printClientAccounts(Client client){
        for (Account account: client.getClientAccounts()) {
            System.out.println(account.toString());
        }
    }

    /**
     * Метод распечатывает список всех клиентов банка
     * @param clients список клиентов банка
     */
    public void printBankClients (HashMap<String, Client> clients) {
        for (Client client: clients.values()) {
            System.out.println(client.toString());
        }
    }

    /**
     * Метод возвращающий выбранный id клиента банка
     * @param clients список клиентов банка
     * @return id
     */
    public int choiceClient(HashMap<String, Client> clients){
        printBankClients(clients);
        System.out.print("Выберете id клиента: ");
        return scanner.nextInt();
    }

    /**
     * Метод возвращающий выбранный номер счета клиента
     * @param client клиент
     * @return выбранный номер счета
     */
    public int choiceClientAccountNumber(Client client){
        printClientAccounts(client);
        System.out.print("Выберете счет: ");
        return scanner.nextInt();
    }

    public boolean exit() {
        System.out.print("Желаете выйти? y/n");
        return scanner.next().equalsIgnoreCase("y")?  true : false;
    }

    /**
     * Метод возвращает вновь созданный счет (Кредитный или Дебетовый)
     * @return вновь созданный счет
     */
    public Account choiceAccountType(){
        System.out.println("Какой тип счета желаете открыть? Debit/Credit");
        Account newAccout = null;
        if (scanner.next().equalsIgnoreCase("debit"))
            newAccout = DebitAccount.createNewDebitAccount(initDebitBalance());
        if (scanner.next().equalsIgnoreCase("сredit"))
            newAccout = CreditAccount.createNewCreditAccount(initCreditBalance());
        return newAccout;
    }

    /**
     * Метод возвращающий указанный размер начального баланса при создании нового счета
     * @return размер начального депозита
     */
    private double initDebitBalance(){
        System.out.print("Какой начальный баланс желаете установить: ");
        double initDebitBalance = scanner.nextDouble();
        return  initDebitBalance;
    }

    /**
     * Метод возвращающий указанный размер кредитного лимита по счету при его создании
     * @return размер кредитного лимита
     */
    private double initCreditBalance(){
        System.out.print("Укажите размер кредитного лимита: ");
        return scanner.nextDouble();
    }

    /**
     * Метод возвращающий величину пополнения счета
     * @return величина пополнения
     */
    public double increaseAccountBalance(){
        System.out.print("Введите сумму для пополнения счета: ");
        return scanner.nextDouble();
    }

    /**
     * Метод возвращающий размер снимаемых денежных средств
     * @return размер запрашиваемых средств
     */
    public double deincreaseAccountBalance(){
        System.out.print("Введите сумму для для снятия со счета: ");
        return scanner.nextDouble();
    }

    /**
     * Метод возвращающий размер первода денежных средсив
     * @return размер запрашиваемых средств
     */
    public double amountTransaction(){
        System.out.print("Введите размер перевода: ");
        return scanner.nextDouble();
    }

}
