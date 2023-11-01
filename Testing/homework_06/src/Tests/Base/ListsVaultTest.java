package Base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListsVaultTest {

    @Test
    void getFirstList() {
        List<Integer> listFirst = Arrays.asList(1,2,3,4);
        ListsVault listsVault = new ListsVault();
        listsVault.setFirstList(listFirst);
        assertEquals(listFirst, listsVault.getFirstList());
    }

    @Test
    void getSecondList() {
        List<Integer> listSecond = Arrays.asList(5,6,7,8);
        ListsVault listsVault = new ListsVault();
        listsVault.setSecondList(listSecond);
        assertEquals(listSecond, listsVault.getSecondList());
    }

    @Test
    void setFirstList() {
        List<Integer> listFirst = Arrays.asList(1,2,3,4);
        ListsVault listsVault = new ListsVault();
        listsVault.setFirstList(listFirst);
        assertEquals(listFirst, listsVault.getFirstList());
    }

    @Test
    void setSecondList() {
        List<Integer> listSecond = Arrays.asList(5,6,7,8);
        ListsVault listsVault = new ListsVault();
        listsVault.setSecondList(listSecond);
        assertEquals(listSecond, listsVault.getSecondList());
    }
}