package Base;

public class Validation {
    public boolean checkInput(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
