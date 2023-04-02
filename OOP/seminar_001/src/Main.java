import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<Integer, Person> personInGeneration = new HashMap<>();
        HashMap<Integer, Nodes> nodesInGeneration = new HashMap<>();

        Person person1 = new Person("мужской", "Иван", "Петров", "Викторович", "10-10-2000");
        Person person2 = new Person("женский", "Ульяна", "Петрова", "Сергеевна", "11-11-2000");
        Integer idFather = person1.getIdPerson();
        Integer idMather = person2.getIdPerson();
        personInGeneration.put(person1.getIdPerson(), person1);
        personInGeneration.put(person2.getIdPerson(), person2);

        Nodes node1 = new Nodes(person1, person2);
        Integer idNode = node1.getIdNode();
        nodesInGeneration.put(node1.getIdNode(), node1);
        ArrayList<Person> childrens = new ArrayList<>();

        Childrens person3 = new Childrens("мужской", "Виктор", "Петров", "Иванович", "01-01-2018");
        person3.setIdNode(idNode);
        person3.setIdFather(idFather);
        person3.setIdMather(idMather);
        childrens.add(person3);
        personInGeneration.put(person3.getIdPerson(), person3);

        Childrens person4 = new Childrens("женский", "Юлия", "Петрова", "Ивановна", "12-09-2019");
        person4.setIdNode(idNode);
        person4.setIdFather(idFather);
        person4.setIdMather(idMather);
        childrens.add(person4);
        personInGeneration.put(person4.getIdPerson(), person4);

        Childrens person5 = new Childrens("мужской", "Юрий", "Петров", "Иванович", "01-10-2020");
        person5.setIdNode(idNode);
        person5.setIdFather(idFather);
        person5.setIdMather(idMather);
        childrens.add(person5);
        personInGeneration.put(person5.getIdPerson(), person5);

        Childrens person6 = new Childrens("женский", "Евгения", "Петрова", "Ивановна", "05-03-2023");
        person6.setIdNode(idNode);
        person6.setIdFather(idFather);
        person6.setIdMather(idMather);
        childrens.add(person6);
        personInGeneration.put(person6.getIdPerson(), person6);

        node1.addChildrens(childrens);

        Generations generation1 = new Generations(nodesInGeneration, personInGeneration);

        Tree familyTree = new Tree(generation1, node1);
    }
}
