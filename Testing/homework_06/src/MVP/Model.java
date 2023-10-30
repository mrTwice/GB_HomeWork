package MVP;

import Base.Actions;
import Base.ListsVault;

public class Model {
    private Actions actions;
    private ListsVault listsVault;

    public Model(){
        this.actions = new Actions();
        this.listsVault = new ListsVault();
    }

    public Actions getActions() {
        return actions;
    }

    public ListsVault getListsVault() {
        return listsVault;
    }
}
