package InfoSystem.Personal;

public abstract class Composition implements Comparable{
    private String firstName;
    private String lastName;
    private String birthday;

    private String department;
    private String status;
    private String enrollmentDate;

    public Composition(String firstName, String lastName, String birthday, String department, String status, String enrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.department = department;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStatus() {
        return status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Object personCmpstn) {
        Composition person = (Composition) personCmpstn;
        char[] thisLastName = (this.getLastName().toCharArray());
        char[] objectLastName = (person.getLastName().toCharArray());
        int minLenght = 0;
        if (thisLastName.length < objectLastName.length ){
            minLenght = thisLastName.length;
        }else {
            minLenght = objectLastName.length;
        }
        for (int i = 0; i < minLenght; i++){
            if (thisLastName[i] < objectLastName[i]){
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
