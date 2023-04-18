package InfoSystem.Personal;

public class Students extends Composition {

    private static int id = 0;
    private int studentID;
    private String specialization;
    private String group;

    public Students(String firstName, String lastName, String birthday, String department,
                    String status,String enrollmentDate, String specialization, String group) {

        super(firstName, lastName, birthday, department, status, enrollmentDate);
        this.specialization = specialization;
        this.group = group;
        this.studentID = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getGroup() {
        return group;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public boolean equals(Object obj) {
        Students object = (Students)obj;
        return this.getFirstName() == object.getFirstName()
                && this.getLastName() == object.getLastName()
                && this.getBirthday() == object.getBirthday();
    }

    @Override
    public int compareTo(Object personObj) {
        Students person = (Students) personObj;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                this.getFirstName() +
                this.getLastName() +
                '}';
    }

}
