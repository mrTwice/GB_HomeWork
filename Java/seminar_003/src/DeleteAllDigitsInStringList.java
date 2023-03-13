import java.util.ArrayList;
import java.util.List;

public class DeleteAllDigitsInStringList {
    public static void main(String[] args) {
        // Дан список ArrayList<String>. Удалить из него все строки, которые являются числами
        // Пример: ArrayList<String> list = new ArrayList<>(List.of("string", "s", "5", "10", "-12", "my_value")); ["string", "s", "my_value"]

        ArrayList<String> myList = new ArrayList<>(List.of("string", "s", "5", "10", "-12", "my_value"));
        System.out.println(myList);
        removeAllDigits(myList);
        System.out.println(myList);
    }

    static void removeAllDigits(ArrayList<String> strList){
        for (int i = 0; i < strList.size(); i++){
            if(stringIsDigit(strList.get(i))){
                strList.remove(i--);
            }
        }
    }

    static boolean stringIsDigit(String element){
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
