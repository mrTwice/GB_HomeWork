package genealogy.tree;

import genealogy.humans.Person;

import java.util.ArrayList;

public class Nodes {
    private static Integer id = 0;
    private int idNode;
    private Integer husbandID;
    private Integer wifeID;

    private ArrayList<Person> childrens = new ArrayList<>();

    public Nodes(Integer husbandID, Integer wifeID){
        this.idNode = id;
        this.husbandID = husbandID;
        this.wifeID = wifeID;
        id ++;
    }

    public int getIdNode() {
        return idNode;
    }

    public Integer getHusband() {
        return husbandID;
    }

    public Integer getWife() {
        return wifeID;
    }

    public void addChildrens(Person person){
        childrens.add(person);
    }
}
