package dijkstra;

import graph.Graph;
import graph.Node;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph("Test");
        Node nodeA = new Node(1,"a");
        Node nodeB = new Node(2,"b");
        Node nodeC = new Node(3,"c");
        Node nodeD = new Node(4,"d");
        Node nodeE = new Node(5,"e");
        nodeA.addEdge(nodeB,7);
        nodeA.addEdge(nodeC,3);
        nodeB.addEdge(nodeC,1);
        nodeB.addEdge(nodeD,2);
        nodeB.addEdge(nodeE,6);
        nodeC.addEdge(nodeD,2);
        nodeD.addEdge(nodeE,4);

    }
}
