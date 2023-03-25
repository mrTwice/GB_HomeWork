import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> friendsList = new ArrayList<>();
        Scanner consoleInput = new Scanner(System.in);
        while (true){

            System.out.print("Желаете добавить друга (y|n): ");
            String answer = consoleInput.nextLine();
            if(answer.equals("y")){
                System.out.print("Введите имя: ");
                String inputFirstName = consoleInput.nextLine();
                System.out.print("Введите фамилию: ");
                String inputLastName = consoleInput.nextLine();
                System.out.print("Введите возраст: ");
                int inputAge = Integer.parseInt(consoleInput.nextLine());
                System.out.print("Введите пол: ");
                String inputGender = consoleInput.nextLine();
                System.out.print("Введите Дату рождения: ");
                String inputBirthday = consoleInput.nextLine();
                System.out.print("Введите семейное положение: ");
                String inputFamilyStatus = consoleInput.nextLine();
                Person newFriend = new Person(inputFirstName, inputLastName, inputAge, inputGender, inputBirthday, inputFamilyStatus);
                friendsList.add(newFriend);
            } else {
                break;
            }

        }

        printFriendsList(friendsList);
    }

    static void printFriendsList(ArrayList<Person> friendsList){
        System.out.println("--------------------------------------------------------------");
        for(Person person: friendsList){
            if( person.getAge() > 20) {
                System.out.println(person);
            }
        }
    }
}
