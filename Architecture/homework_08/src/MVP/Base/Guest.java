package MVP.Base;

public class Guest {
    private static int id =0;
    private String name;
    private String phoneNumber;

    public Guest(String name, String phoneNumber) {
        this.id++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
