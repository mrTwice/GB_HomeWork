package genealogy.tree;
import genealogy.humans.Person;
import java.util.ArrayList;
import java.util.HashMap;

public class Generations {
    private static int id = 0;
    private int idGeneration;
    private HashMap<Integer, Nodes> nodes = new HashMap<>();
    private HashMap<Integer, Person> persons = new HashMap<>();

    public Generations(Person person){
        this.idGeneration = id;
        this.persons.put(person.getIdPerson(), person);
        id++;
    }
    public Generations(){
        this.idGeneration = id;
        id++;
    }
    public Integer getIdGeneration() {return idGeneration;}

    public HashMap<Integer, Nodes> getNodes() {return nodes;}

    public HashMap<Integer, Person> getPersons() {return persons;}

    public void addPersonToGeneration(Person person){
        this.persons.put(person.getIdPerson(), person);
    }
    public void addNodesToGenerations(Nodes node){
        this.nodes.put(node.getIdNode(), node);
    }

    public void printAllPersonsInGeneration(){
        for (Person person: persons.values()) {
            System.out.println(person.toString());
        }
    }
}
