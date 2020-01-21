package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private String name;
    private boolean directed;
    private boolean weighted;
    private int numNodes;
    private Node startNode;
    private List<Node> nodes;
    public static float INF = Float.POSITIVE_INFINITY;

    public Graph() {
    }

    public Graph(String name) {
        this.name = name;
        this.directed = false;
        this.weighted = false;
        this.numNodes = 0;
        this.nodes = new ArrayList<>();
    }

    public Graph(String name, boolean directed, boolean weighted) {
        this.name = name;
        this.directed = directed;
        this.weighted = weighted;
        this.numNodes = 0;
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        node.setIndex(numNodes);
        nodes.add(node);
        numNodes++;
    }

    public void addEdge(int start, int dest) {
        Node startNode = nodes.get(start);
        Node destNode = nodes.get(dest);
        if (directed) {
            startNode.addVector(destNode);
        } else {
            startNode.addEdge(destNode);
        }
    }

    public void addEdge(int start, int dest, int weight) {
        Node startNode = nodes.get(start);
        Node destNode = nodes.get(dest);
        if (directed) {
            startNode.addVector(destNode, weight);
        } else {
            startNode.addEdge(destNode, weight);
        }
    }

    public boolean hasEdge(int start, int dest) {
        boolean has = false;
        for (Edge e : nodes.get(start).getEdges()) {
            if (e.getEnd().getIndex() == dest) {
                has = true;
                break;
            }
        }
        if (!has && directed) {
            for (Edge e : nodes.get(dest).getEdges()) {
                if (e.getEnd().getIndex() == start) {
                    has = true;
                    break;
                }
            }
        }
        return has;
    }

    public Node getNodeByName(String name) {
        Node node = null;
        for (Node n : nodes) {
            if (n.getName().equalsIgnoreCase(name)) {
                node = n;
            }
        }
        return node;
    }

    public Node getNodeByIndex(int index) {
        Node node = null;
        for (Node n : nodes) {
            if (n.getIndex() == index) {
                node = n;
            }
        }
        return node;
    }

    public void dijkstra(Node start) {

        startNode = start;
        List<Node> visited = new ArrayList<>();
        List<Node> unvisited = new ArrayList<>(nodes);

        for (Node n : nodes) {
            n.setDistance(INF);
        }

        startNode.setPrevious(start);
        startNode.setDistance(0);
        Node currentNode = start;

        while (unvisited.size() > 0) {
            float min = INF;

            for (Node n : unvisited) { //get closest node
                if (n.getDistance() < min) {
                    currentNode = n;
                    min = n.getDistance();
                }
            }

            for (Edge e : currentNode.getEdges()) {
                float dist = currentNode.getDistance() + e.getDistance(); //current node distance + edge distance
                Node endNode = e.getEnd();
                if (dist < endNode.getDistance()) {
                    endNode.setDistance(dist);
                    endNode.setPrevious(currentNode);
                }
            }
            unvisited.remove(currentNode);
            visited.add(currentNode);
        }
    }

    public void printDistanceTable() {
        System.out.println("Start node: "+startNode.getName());
        System.out.println("node|dist|prev");
        for (Node n : nodes) {
            System.out.println(n.getName() + "(" + n.getIndex() + ") " + n.getDistance() + "  " + n.getPrevious().getName());
        }
    }

    public String getRoute(Node node) {
        List<Node> route = new ArrayList<>();
        while (node != startNode) {
            route.add(node);
            node = node.getPrevious();
        }
        StringBuilder s = new StringBuilder();
        s.append(startNode.getName());
        for (int i = route.size() - 1; i >= 0; i--) {
            s.append("-").append(route.get(i).getName());
        }
        return s.toString();
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

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(name + " {\n");
        for (Node n : nodes) {
            s.append(n.toString()).append("\n");
        }
        s.append("}\n");
        return s.toString();
    }
}
