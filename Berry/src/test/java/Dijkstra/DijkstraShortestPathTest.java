package Dijkstra;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DijkstraShortestPathTest {

    @Test
    public void testFindPathWithPriorityQueue() throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addNeighbor(nodeB, 6);
        nodeA.addNeighbor(nodeD, 1);

        nodeB.addNeighbor(nodeD, 2);
        nodeB.addNeighbor(nodeE, 2);
        nodeB.addNeighbor(nodeC, 5);

        nodeC.addNeighbor(nodeE, 5);

        nodeD.addNeighbor(nodeE, 1);

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        String path = shortestPath.findShortestPathWithPriorityQueue(nodeA, nodeC);

        Assert.assertEquals("Expected path", "[A, D, E, C]", path);
    }

    @Test
    public void testFindPath() throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addNeighbor(nodeB, 6);
        nodeA.addNeighbor(nodeD, 1);

        nodeB.addNeighbor(nodeD, 2);
        nodeB.addNeighbor(nodeE, 2);
        nodeB.addNeighbor(nodeC, 5);

        nodeC.addNeighbor(nodeE, 5);

        nodeD.addNeighbor(nodeE, 1);

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        String path = shortestPath.findShortestPath(nodeA, nodeC);

        Assert.assertEquals("Expected path", "[A, D, E, C]", path);
    }

}
