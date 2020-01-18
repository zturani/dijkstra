package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int index;
    private String name;
    private List<Edge> edges;
    private float distance;
    private Node previous;

    public Node() {
    }

    public Node (String name) {
        this.name = name;
        this.index = -1;
        this.edges = new ArrayList<>();
    }

    public void addVector (Node node){ //directional edge
        edges.add(new Edge(this,node));
    }

    public void addVector (Node node, float weight){ //directional edge
        edges.add(new Edge(this,node,weight));
    }

    public void addEdge (Node node){ //undirectional edge
        edges.add(new Edge(this,node));
        node.getEdges().add(new Edge(node,this));
    }

    public void addEdge (Node node, float weight){ //undirectional edge
        edges.add(new Edge(this,node,weight));
        node.getEdges().add(new Edge(node,this,weight));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int id) {
        this.index = id;
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(name + "(" + index + ") ");
        for (Edge e : edges) {
            s.append(" >").append(e.getEnd().getIndex()).append("[").append(e.getDistance()).append("]");
        }
        return s.toString();
    }
}
