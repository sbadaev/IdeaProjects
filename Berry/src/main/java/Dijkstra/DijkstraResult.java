package Dijkstra;

/**
 * Represents a row from the results table of running Dijkstra's shortest path algorithm.
 */
public class DijkstraResult {
    private Node node;
    private int distance;
    private Node fromNode;

    public DijkstraResult(Node node){
        this.node = node;
        this.distance = Integer.MAX_VALUE;
        this.fromNode = null;
    }

    public Node getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node fromNode) {
        this.fromNode = fromNode;
    }
}
