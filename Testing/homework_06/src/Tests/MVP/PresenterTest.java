package MVP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PresenterTest {
    private Presenter presenter;

    @BeforeEach
    public void setUp(){
        presenter = new Presenter();
    }

    @Test
    void compareListsEqual() {
        presenter.getModel().getListsVault().setFirstList(Arrays.asList(1,2,3,4));
        presenter.getModel().getListsVault().setSecondList(Arrays.asList(1,2,3,4));
        assertEquals(presenter.compareLists(), "Средние значения равны");
    }

    @Test
    void compareListsFirsMoreThenSecond() {
        presenter.getModel().getListsVault().setFirstList(Arrays.asList(1,2,3,5));
        presenter.getModel().getListsVault().setSecondList(Arrays.asList(1,2,3,4));
        assertEquals(presenter.compareLists(), "Первый список имеет большее среднее значение");
    }

    @Test
    void compareListsSecondMoreThenFirst() {
        presenter.getModel().getListsVault().setFirstList(Arrays.asList(1,2,3,4));
        presenter.getModel().getListsVault().setSecondList(Arrays.asList(1,2,3,5));
        assertEquals(presenter.compareLists(), "Второй список имеет большее среднее значение");
    }
}