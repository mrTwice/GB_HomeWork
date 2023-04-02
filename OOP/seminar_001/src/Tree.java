import java.util.Iterator;
import java.util.TreeMap;
import java.util.function.Consumer;

public class Tree implements Iterable {
    private TreeMap<Integer, Generations> generations = new TreeMap<>();
    private TreeMap<Integer, Nodes> nodes = new TreeMap<>();

    public Tree(Generations generations, Nodes node){
        this.generations.put(generations.getIdGeneration(), generations);
        this.nodes.put(node.getIdNode(), node);
    }

    public TreeMap<Integer, Generations> getGenerations() {
        return generations;
    }

    public void setGenerations(TreeMap<Integer, Generations> generations) {
        this.generations = generations;
    }

    public TreeMap<Integer, Nodes> getNodes() {
        return nodes;
    }

    public void setNodes(TreeMap<Integer, Nodes> nodes) {
        this.nodes = nodes;
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
