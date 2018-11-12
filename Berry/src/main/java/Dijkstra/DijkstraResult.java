package Dijkstra;

/**
 * Represents a row from the results table of running Dijkstra's shortest path algorithm.
 */
public class DijkstraResult {
    private String key;
    private int distance;
    private String fromNodeKey;

    public DijkstraResult(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getFromNodeKey() {
        return fromNodeKey;
    }

    public void setFromNodeKey(String fromNodeKey) {
        this.fromNodeKey = fromNodeKey;
    }
}
