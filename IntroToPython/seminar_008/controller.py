import view
import db_manager
db_manager.open_db()

def enter():
    while True:
        user_select = view.print_menu()
        match user_select:
            case 1:
                phone_book = db_manager.get_phone_book()
                view.print_contacts(phone_book)
            case 2:
                new_contact = view.create_new_contact()
                db_manager.add_new_contact(new_contact)
            case 3:
                pb = db_manager.get_phone_book()
                view.print_contacts(pb)
                id = view.get_id()
                contact = view.create_new_contact()
                db_manager.change_info(id, contact)
            case 4:
                find = view.any_find()
                result = db_manager.find(find)
                view.print_contacts(result)
            case 5:
                phone_book = db_manager.get_phone_book()
                view.print_contacts(phone_book)
                id = view.get_id()
                name = db_manager.get_person(id)
                if view.confirm('удалить', name):
                    db_manager.delete_contact(id)
            case 6:
                db_manager.save_db()
            case 7:
                break