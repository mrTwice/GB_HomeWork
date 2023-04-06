package genealogy.tree;

import genealogy.humans.Person;

import java.util.ArrayList;

public class Nodes {
    private static Integer idNode = 0;
    private Integer husbandID;
    private Integer wifeID;

    private ArrayList<Person> childrens = new ArrayList<>();

    public Nodes(Integer husbandID, Integer wifeID){
        this.husbandID = husbandID;
        this.wifeID = wifeID;
        idNode ++;
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
}
