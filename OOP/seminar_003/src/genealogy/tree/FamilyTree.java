package genealogy.tree;

import genealogy.humans.Person;

import java.util.HashMap;
import java.util.TreeMap;

public class FamilyTree implements BaseTree{
    private HashMap<Integer, Generations> generations = new HashMap<>();
    private static HashMap<Integer, Person> allPersons = new HashMap<>();
    public HashMap<Integer, Generations> getGenerations() { return generations; }

    public void addGenerationToTree(Generations generation) {
        this.generations.put(generation.getIdGeneration(), generation);
    }

    public void addPerson(Person person){
        allPersons.put(person.getIdPerson(), person);
    }
    @Override
    public void printPersonForAllGenerations() {
        for (Generations generation: generations.values()) {
            System.out.println();
            System.out.printf("Поколение №%d\n",generation.getIdGeneration());
            generation.printAllPersonsInGeneration();
        }
    }

}
