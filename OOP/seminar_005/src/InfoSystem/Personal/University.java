package InfoSystem.Personal;

import java.util.ArrayList;
import java.util.List;

public class University {
    private  List<Composition> community;

    public University () {
        community = new ArrayList<>();
    }

    public List<Composition> getCommunity() {
        return community;
    }

    public void addPersonToCommunity(Composition person) {
        this.community.add(person);
    }
}
