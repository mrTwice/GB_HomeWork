package MVP;

import Base.Actions;
import Base.ListsVault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model;

    @BeforeEach
    public void setUp(){
        model = new Model();
    }
    @Test
    void getActions() {
        assertInstanceOf(Actions.class, model.getActions());
    }

    @Test
    void getListsVault() {
        assertInstanceOf(ListsVault.class, model.getListsVault());
    }
}