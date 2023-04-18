package InfoSystem.Personal;

public class Staff extends Composition{

    private static int id = 0;
    private int staffID;
    private String position;
    private String subject;

    public Staff(String firstName, String lastName, String birthday, String department,
                 String status, String enrollmentDate, String position, String subject) {

        super(firstName, lastName, birthday, department, status, enrollmentDate);
        this.position = position;
        this.subject = subject;
        this.staffID = id;
    }

    public String getPosition() {
        return position;
    }

    public String getSubject() {
        return subject;
    }

    public int getStaffID() {
        return staffID;
    }

    @Override
    public boolean equals(Object obj) {
        Staff object = (Staff)obj;
        return this.getFirstName() == object.getFirstName()
                && this.getLastName() == object.getLastName()
                && this.getBirthday() == object.getBirthday();
    }

    @Override
    public int compareTo(Object personStf) {
        Staff person = (Staff) personStf;
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
        return "Staff{" +
                "staffID=" + staffID +
                this.getFirstName() +
                this.getLastName() +
                '}';
    }
}
