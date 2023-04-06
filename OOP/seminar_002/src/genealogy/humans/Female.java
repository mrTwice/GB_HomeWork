package genealogy.humans;

public class Female extends Person{
    protected Integer hasbandID;

    public Female(String surname, String name, String patronym, String birthday) {
        super(surname, name, patronym, birthday);
    }

    public void setHasbandID(Integer hasbandID) {
        this.hasbandID = hasbandID;
    }

    public Integer getHasbandID() {
        return hasbandID;
    }
}
