package graph;

import java.util.List;

public class Node {
    int id;
    String name;
    List<Edge> edges;

    public Node() {
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node(int id, String name, List<Edge> edges) {
        this.id = id;
        this.name = name;
        this.edges = edges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
