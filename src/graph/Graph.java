package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private String name;
    private boolean directed;
    private boolean weighted;
    private int numNodes;
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

    public Node getNodeByName (String name) {
        Node node = null;
        for (Node n : nodes) {
            if (n.getName().equalsIgnoreCase(name)) {
                node = n;
            }
        }
        return node;
    }

    public Node getNodeByIndex (int index) {
        Node node = null;
        for (Node n : nodes) {
            if (n.getIndex()==index) {
                node = n;
            }
        }
        return node;
    }

    public void runDijkstra(Node start, Node dest) {

        DijkstraTable dkt = new DijkstraTable();
        dkt.distance[start.getIndex()] = 0;
        dkt.previous[start.getIndex()] = start;
        Node currentNode;

        while  (dkt.unvisited.size()>0) {
            currentNode = dkt.getShortestDstNode();
            for (Edge edge : currentNode.getEdges()) {
                float dist = dkt.distance[currentNode.getIndex()] + edge.getDistance(); //current node distance + edge distance
                int index = edge.getEnd().getIndex();
                if (dist<dkt.distance[index]) { //if distance is shorter, update distance and previous node
                    dkt.distance[index] = dist;
                    dkt.previous[index] = currentNode;
                }
            }
            dkt.unvisited.remove(currentNode);
            dkt.visited.add(currentNode);
        }

        for (int i = 0; i < dkt.vertex.length; i++) {
            System.out.println(dkt.vertex[i].getName()+"("+i+") "+dkt.distance[i]+" - "+dkt.previous[i].getName());
        }
    }



    private class DijkstraTable {
        protected Node[] vertex, previous;
        protected float[] distance;
        protected List<Node> visited, unvisited;
        protected int index;

        public DijkstraTable() {
            vertex = new Node[getNumNodes()];
            previous = new Node[getNumNodes()];
            distance = new float[getNumNodes()];
            visited = new ArrayList<>();
            unvisited = getNodes();

            for (int i = 0; i < vertex.length; i++) {
                vertex[i] = unvisited.get(i);
                vertex[i].setIndex(i); //making sure indexes correspond
                distance[i] = INF;
            }
        }

        protected Node getShortestDstNode() {
            Node node = null;
            float min = INF;

            for (Node n : unvisited) {
                if (distance[n.getIndex()] < min) {
                    node = n;
                    min = distance[n.getIndex()];
                }
            }
            return node;
        }
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
        s.append("}");
        return s.toString();
    }
}
