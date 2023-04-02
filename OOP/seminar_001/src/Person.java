import java.util.ArrayList;

public class Person implements Comparable{
    private Integer idPerson = 0;
    private String gender;
    private String name;
    private String surname;
    private String patronym;
    private String birthday;
    private String deathday;
    private ArrayList <Person> parents;
    private ArrayList<Person> siblings;

    public Person(String gender, String name, String surname, String patronym, String birthday) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.birthday = birthday;
        idPerson ++;

    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronym() {
        return patronym;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public void setParents(ArrayList<Person> parents) {
        this.parents = parents;
    }

    public void setSiblings(ArrayList<Person> siblings) {
        this.siblings = siblings;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronym='" + patronym + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
