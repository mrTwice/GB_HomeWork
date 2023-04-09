package genealogy.tree;

import java.util.TreeMap;

public class FamilyTree implements BaseTree{
    private TreeMap<Integer, Generations> generations = new TreeMap<>();
    private TreeMap<Integer, Nodes> nodes = new TreeMap<>();

    public FamilyTree(Generations generation, Nodes node){
        this.generations.put(generation.getIdGeneration(), generation);
        this.nodes.put(node.getIdNode(), node);
    }

    public FamilyTree(Generations generation){
        this.generations.put(generation.getIdGeneration(), generation);
    }

    public TreeMap<Integer, Generations> getGenerations() { return generations; }

    public TreeMap<Integer, Nodes> getNodes() {
        return nodes;
    }

    @Override
    public void printOutAllPersonInGeneration() {
        System.out.println(generations);
    }

    @Override
    public void printOutAllNodesInGeneration() {
        System.out.println(nodes);
    }

}
