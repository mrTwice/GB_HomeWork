package Base;

import java.util.ArrayList;
import java.util.List;

public class ListsVault {
    private List<Integer> firstList;
    private List<Integer> secondList;

    public ListsVault(){
        this.firstList = new ArrayList<>();
        this.secondList = new ArrayList<>();
    }

    public List<Integer> getFirstList() {
        return firstList;
    }

    public List<Integer> getSecondList() {
        return secondList;
    }

    public void setFirstList(List<Integer> firstList) {
        this.firstList = firstList;
    }

    public void setSecondList(List<Integer> secondList) {
        this.secondList = secondList;
    }
}
