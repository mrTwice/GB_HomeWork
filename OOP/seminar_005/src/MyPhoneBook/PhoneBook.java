package MyPhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public boolean add(Contact newContact) {
        boolean flag = false;
        if (!contacts.contains(newContact)) {
            contacts.add(newContact);
            flag = true;
        }
        return flag;
    }

    public boolean remove(Contact contact) {
        boolean flag = false;
        if (contacts.indexOf(contact) != -1) {
            contacts.remove(contact);
            flag = true;
        }
        return  flag;
    }

    public Contact getContact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    private boolean contains(int index) {
        return  contacts != null
                && contacts.size() > index;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public  int count() {
        return  contacts.size();
    }
}
