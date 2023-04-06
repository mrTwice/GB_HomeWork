package genealogy;

import genealogy.humans.Female;
import genealogy.humans.Male;
import genealogy.humans.Person;
import genealogy.tree.FamilyTree;
import genealogy.tree.Generations;
import genealogy.tree.Nodes;


public class Main {
    public static void main(String[] args) {

        Person female1 = new Female("Петрова", "Анна", "Николаевна", "10-10-2001");
        System.out.println(female1);
        Person male1 = new Male("Иванов", "Виталий", "Иванович", "11-11-2000");
        System.out.println(male1);
        Person male2 = new Male("Сидоров", "Олег", "Васильевич", "05-01-1999");
        System.out.println(male2);

        Generations generation1 = new Generations(female1);
        generation1.addPersonToGeneration(male1);

        Nodes node1 = new Nodes(male1.getId(), female1.getId());
        generation1.addNodesToGenerations(node1);

        FamilyTree family1 = new FamilyTree(generation1, node1);
        family1.printOutAllNodesInGeneration();
        family1.printOutAllPersonInGeneration();


    }
}
