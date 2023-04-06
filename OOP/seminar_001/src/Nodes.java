import java.util.ArrayList;

public class Nodes {
    private static int idNode = 0;
    private Person husband;
    private Person wife;

    private ArrayList<Person> childrens = new ArrayList<>();

    public Nodes(Person husband, Person wife){
        this.husband = husband;
        this.wife = wife;
        idNode ++;

    }

    public int getIdNode() {
        return idNode;
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public void addChildrens(ArrayList<Person> kids){
        childrens.addAll(kids);
    }

}
