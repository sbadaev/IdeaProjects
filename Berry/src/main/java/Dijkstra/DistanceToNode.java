package Dijkstra;

public class DistanceToNode {
    String fromNodeKey;
    int distance;

    public DistanceToNode(String fromNodeKey, int distance) {
        this.fromNodeKey = fromNodeKey;
        this.distance = distance;
    }

    public String getFromNodeKey() {
        return fromNodeKey;
    }

    public void setFromNodeKey(String fromNodeKey) {
        this.fromNodeKey = fromNodeKey;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "DistanceToNode{" +
                "fromNodeKey='" + fromNodeKey + '\'' +
                ", distance=" + distance +
                '}';
    }
}
