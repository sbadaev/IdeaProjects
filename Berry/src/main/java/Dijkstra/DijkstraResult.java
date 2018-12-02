package Dijkstra;

/**
 * Represents a row from the results table of running Dijkstra's shortest path algorithm.
 */
public class DijkstraResult {
    private Node node;
    private int distanceFromPrevious;
    private Node fromNode;
    private double distanceToEnd;

    public DijkstraResult(Node node){
        this.node = node;
        this.distanceFromPrevious = Integer.MAX_VALUE;
        this.fromNode = null;
        this.distanceToEnd = 0;
    }

    public Node getNode() {
        return node;
    }

    public int getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public void setDistanceFromPrevious(int distanceFromPrevious) {
        this.distanceFromPrevious = distanceFromPrevious;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node fromNode) {
        this.fromNode = fromNode;
    }

    public double getDistanceToEnd() {
        return distanceToEnd;
    }

    public void setDistanceToEnd(double distanceToEnd) {
        this.distanceToEnd = distanceToEnd;
    }

    public double getWeight(){
        return getDistanceFromPrevious() + getDistanceToEnd();
    }
}
