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
        path = shortestPath.findShortestPath(nodeA, nodeE);
        Assert.assertEquals("Expected path", "[A, D, E]", path);
        path = shortestPath.findShortestPath(nodeA, nodeB);
        Assert.assertEquals("Expected path", "[A, D, B]", path);
    }

    @Test
    public void testFindPath() {
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
        path = shortestPath.findShortestPath(nodeA, nodeE);
        Assert.assertEquals("Expected path", "[A, D, E]", path);
        path = shortestPath.findShortestPath(nodeA, nodeB);
        Assert.assertEquals("Expected path", "[A, D, B]", path);
    }

    @Test
    public void testAStar(){
        Node nodeA = new Node("A", 1, 2);
        Node nodeB = new Node("B", 2, 10);
        Node nodeC = new Node("C", 3, 10);
        Node nodeD = new Node("D", 4, 6);
        Node nodeE = new Node("E", 5, 5);

        nodeA.addNeighbor(nodeB, 6);
        nodeA.addNeighbor(nodeD, 1);

        nodeB.addNeighbor(nodeD, 2);
        nodeB.addNeighbor(nodeE, 2);
        nodeB.addNeighbor(nodeC, 5);

        nodeC.addNeighbor(nodeE, 5);

        nodeD.addNeighbor(nodeE, 1);


        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        String path = shortestPath.findShortestPathWithPriorityQueue(nodeA, nodeC);
        Assert.assertEquals("Expected path", "[A, B, C]", path);
        path = shortestPath.findShortestPath(nodeA, nodeE);
        Assert.assertEquals("Expected path", "[A, D, E]", path);
        path = shortestPath.findShortestPath(nodeA, nodeB);
        Assert.assertEquals("Expected path", "[A, D, B]", path);
    }

}
