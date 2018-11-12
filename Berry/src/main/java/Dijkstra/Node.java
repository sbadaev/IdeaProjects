package Dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private String key;
    private List<Node> neighbors = new ArrayList<>();
    private List<Integer> distanceToNeighbors = new ArrayList<>();

    public Node(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public List<Integer> getDistanceToNeighbors(){
        return distanceToNeighbors;
    }

    public void addNeighbor(Node neighbor, int distanceToNeighbor){
        if(neighbors.contains(neighbor)){
            return;
        }

        neighbors.add(neighbor);
        distanceToNeighbors.add(distanceToNeighbor);

        neighbor.addNeighbor(this, distanceToNeighbor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(key, node.key) &&
                Objects.equals(neighbors, node.neighbors) &&
                Objects.equals(distanceToNeighbors, node.distanceToNeighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}


