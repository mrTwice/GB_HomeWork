package genealogy.tree;

import genealogy.humans.Person;
import java.util.HashMap;

public class Generations {
    private static Integer idGeneration = 0;
    private HashMap<Integer, Nodes> nodes = new HashMap<>();
    private HashMap<Integer , Person> persons = new HashMap<>();

    public Generations(Nodes node){
        this.nodes.put(node.getIdNode(), node);
    }
    public Generations(Person person){
        this.persons.put(person.getId(), person);
    }
    public Integer getIdGeneration() {return idGeneration;}

    public HashMap<Integer, Nodes> getNodes() {return nodes;}

    public HashMap<Integer, Person> getPersons() {return persons;}

    public void addPersonToGeneration(Person person){
        this.persons.put(person.getId(), person);
    }
    public void addNodesToGenerations(Nodes node){
        this.nodes.put(node.getIdNode(), node);
    }

}
