package genealogy.humans;

public class Male extends Person{
    private Integer WifeID;

    public Male(String surname, String name, String patronym, String birthday) {
        super(surname, name, patronym, birthday);
    }

    public void setWifeID(Integer hasbandID) {
        this.WifeID = hasbandID;
    }

    public Integer getWifeID() {
        return WifeID;
    }
}
