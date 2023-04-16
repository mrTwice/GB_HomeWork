package MyPhoneBook;

import java.io.*;

public class Model {
    PhoneBook currentPhoneBook;
    private int currentIndex;
    private  String path;

    public Model(String path) {
        currentPhoneBook = new PhoneBook();
        currentIndex = 0;
        this.path = path;
    }

    public  Contact currentContact() {
        if (currentIndex >= 0) {
            return  currentPhoneBook.getContact(currentIndex);
        } else {
            return null;
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fName = bufferedReader.readLine();
            while (fName != null) {
                String lName = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();
                this.currentPhoneBook.add(new Contact(fName, lName, phoneNumber));
                fName = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (FileWriter fileWriter = new FileWriter(path, false)) {
            for (int i = 0; i < currentPhoneBook.count(); i++) {
                Contact contact = currentPhoneBook.getContact(i);
                fileWriter.append(String.format("%s\n", contact.firstName));
                fileWriter.append(String.format("%s\n", contact.lastName));
                fileWriter.append(String.format("%s\n", contact.phoneNumber));
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public PhoneBook getCurrentPhoneBook() {
        return this.currentPhoneBook;
    }

    public  int getCurrentIndex() {
        return  this.currentIndex;
    }

    public void setCurrentIndex(int index) {
        this.currentIndex = index;
    }


}
