package graph;

import java.util.List;

public class Graph {

    private String name;
    private int numNodes;
    private List<Node> nodes;

    public Graph() {
    }

    public Graph(String name) {
        this.name = name;
    }

    public Graph(String name, List<Node> nodes) {
        this.name = name;
        this.nodes = nodes;
        this.numNodes = nodes.size();
    }

    public void add(Node node) {
        nodes.add(node);
        numNodes++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
