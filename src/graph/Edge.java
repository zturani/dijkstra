package graph;

public class Edge {
    private Node start;
    private Node end;
    private float distance;

    public Edge() {
    }

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.distance = -1;
    }

    public Edge(Node start, Node end, float distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "{" + start.getIndex() + ">" + end.getIndex() +
                "(" + distance + ")}";
    }
}
