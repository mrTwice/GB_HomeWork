package genealogy.humans;

import java.util.HashMap;

public class Person {
    private static int id = 0;
    private int idPerson;
    private String surname;
    private String name;
    private String patronym;
    private String birthday;
    private String deathday;
    private Integer matherId;
    private Integer fatherID;

    public Person(String surname, String name, String patronym, String birthday) {
        this.idPerson = id;
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.birthday = birthday;
        id++;
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

    public int getIdPerson() {return idPerson;}

    public String toString(){
        return String.format("\tidPerson = %d\n\t\t%s %s %s %s г.р.",idPerson, surname, name, patronym, birthday);
    }
}
