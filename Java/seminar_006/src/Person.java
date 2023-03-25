import java.util.Objects;

public class Person {
    String firstName;
    String lastName;
    int age;
    String gender;
    String birthday;
    String familyStatus;

    public Person(String firstName,
                  String lastName,
                  int age,
                  String gender,
                  String birthday,
                  String familyStatus){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.familyStatus = familyStatus;
    }

    public Person(String firstName, String lastName, int age){
        this(firstName, lastName, age, null, null, null);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public String getBirthday(){
        return birthday;
    }

    public String getFamilyStatus(){
        return familyStatus;
    }

    @Override
    public  String toString(){
        return String.format("%s %s %d лет %s %s %s", lastName, firstName, age, gender, familyStatus, birthday);
    }

    @Override
    public int hashCode(){
        return Objects.hash(lastName, firstName, age, gender, familyStatus, birthday);
    }

    @Override
    public  boolean equals(Object person){
        if(person == null){
            return false;
        }
        if(! (person instanceof Person)){
            return false;
        }

        Person newPerson = (Person) person;
        return Objects.equals(firstName, newPerson.firstName) && Objects.equals(lastName, newPerson.lastName);
    }
}
