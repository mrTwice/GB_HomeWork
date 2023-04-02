import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

public class Generations implements Iterable {
    private Integer idGeneration;
    private HashMap<Integer, Nodes> nodes;
    private HashMap<Integer , Person> persons;

    public Generations(HashMap<Integer, Nodes> nodes, HashMap<Integer , Person> persons){
        this.nodes = nodes;
        this.persons = persons;
        idGeneration ++;
    }

    public Integer getIdGeneration() {
        return idGeneration;
    }

    public HashMap<Integer, Nodes> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, Nodes> nodes) {
        this.nodes = nodes;
    }

    public HashMap<Integer, Person> getPersons() {
        return persons;
    }

    public void setPersons(HashMap<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }
}
