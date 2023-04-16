package MyPhoneBook;

public class Contact implements Comparable<Contact> {
    String firstName;
    String lastName;
    String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Contact t = (Contact)obj;
        return this.firstName == t.firstName
                && this.lastName == t.lastName
                && this.phoneNumber == t.phoneNumber;
    }

    @Override
    public int compareTo(Contact o) {
        char[] thisLastName = (this.lastName.toCharArray());
        char[] objectLastName = (o.lastName.toCharArray());
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
