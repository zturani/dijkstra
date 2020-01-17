package dijkstra;

import graph.Graph;
import graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Graph graph = new Graph("Test", false, true);
        graph.addNode(new Node("a"));
        graph.addNode(new Node("b"));
        graph.addNode(new Node("c"));
        graph.addNode(new Node("d"));
        graph.addNode(new Node("e"));
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 4);

        int startId = 0;
        int endId = 4;

        System.out.println(graph.hasEdge(1, 3));
        System.out.print(graph.toString());

        graph.runDijkstra(graph.getNodeByName("a"), graph.getNodeByName("e"));
    }
}
