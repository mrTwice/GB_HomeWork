package MyPhoneBook;

public class Controler {
    private Model model;
    private View view;

    public Controler(View view, String pathDB) {
        this.view = view;
        model = new Model(pathDB);
    }

    public void LoadFromFile() {
        model.load();

        if (model.getCurrentPhoneBook().count() >0) {
            model.setCurrentIndex(0);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhoneNumber(contact.phoneNumber);
        }
    }

    public  void add() {
        model.getCurrentPhoneBook().add(
                new Contact(view.getFirstName(), view.getLastName(), view.getPhoneNumber()));
    }

    public void remove() {
        Contact contact = model.currentContact();
        model.getCurrentPhoneBook().remove(contact);
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.getCurrentPhoneBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.getCurrentPhoneBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex()+1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setPhoneNumber(contact.phoneNumber);
            }
        }
    }

    public void prev() {
        if (model.getCurrentPhoneBook().count() > 0) {
            if (model.getCurrentIndex() -1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() -1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setPhoneNumber(contact.phoneNumber);
            }
        }
    }
}
