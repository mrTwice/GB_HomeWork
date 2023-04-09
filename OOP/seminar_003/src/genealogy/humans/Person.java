package genealogy.humans;

public class Person {
    private static Integer id = 0;
    private String surname;
    private String name;
    private String patronym;
    private String birthday;
    private String deathday;
    private Integer matherId;
    private Integer fatherID;

    public Person(String surname, String name, String patronym, String birthday) {
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.birthday = birthday;
        id ++;
    }

    public void setMatherId(Integer matherId) {
        this.matherId = matherId;
    }

    public void setFatherID(Integer fatherID) {
        this.fatherID = fatherID;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public Integer getMatherId() {
        return matherId;
    }

    public Integer getFatherID() {return fatherID;}

    public int getId() {return id;}

    public String toString(){
        return String.format("%d %s %s %s %s", id, surname, name, patronym, birthday);
    }
}
