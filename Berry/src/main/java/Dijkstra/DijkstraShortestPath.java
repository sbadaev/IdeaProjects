package Dijkstra;

import java.util.*;

public class DijkstraShortestPath {

    public String findShortestPath(Node source, Node destination){
        HashMap<String, DistanceToNode> map = populateMap(source);

        List<String> path = new ArrayList<>();
        path.add(destination.getKey());
        DistanceToNode previousNode = map.get(destination.getKey());
        while(previousNode.getFromNodeKey() != null && !source.getKey().equals(previousNode.getFromNodeKey())){
            path.add(previousNode.getFromNodeKey());
            previousNode = map.get(previousNode.getFromNodeKey());
        }
        path.add(source.getKey());

        // Reverse the path so that
        Collections.reverse(path);

        return path.toString();
    }

    private HashMap<String, DistanceToNode> populateMap(Node weighedGraph){
        Set<String> keys = new HashSet<>();
        populateKeys(weighedGraph, keys);

        // initialize the map
        HashMap<String, DistanceToNode> result = new HashMap<>();
        for(String key : keys){
            result.put(key, new DistanceToNode(null, Integer.MAX_VALUE));
        }
        // Set the distance away from the starting node as 0
        result.get(weighedGraph.getKey()).setDistance(0);

        Set<String> visitedNodes = new HashSet<>();
        Set<String> unvisitedNodes = new HashSet<>(keys);
        populateMap(weighedGraph, result, visitedNodes, unvisitedNodes);

        return result;
    }

    private void populateMap(Node node, HashMap<String, DistanceToNode> map, Set<String> visitedNodes, Set<String> unvisitedNodes){
        if(node == null){
            return;
        }

        if(visitedNodes.contains(node.getKey())){
            // If we have already been to this node skip it.
            return;
        }

        DistanceToNode distanceToNode = map.get(node.getKey());
        Node closestNeighbor = null;
        int distanceToClosestNeighbor = Integer.MAX_VALUE;
        for(int i = 0; i < node.getNeighbors().size(); i++){
            Node neighbor = node.getNeighbors().get(i);
            int distanceToNeighbor = node.getDistanceToNeighbors().get(i);

            int distanceFromStart = distanceToNode.getDistance() + distanceToNeighbor;
            DistanceToNode currDistanceToNeighbor = map.get(neighbor.getKey());
            if(distanceFromStart < currDistanceToNeighbor.getDistance()){
                currDistanceToNeighbor.setDistance(distanceFromStart);
                currDistanceToNeighbor.setFromNodeKey(node.getKey());
            }

            if(!visitedNodes.contains(neighbor.getKey()) && distanceFromStart < distanceToClosestNeighbor){
                distanceToClosestNeighbor = distanceFromStart;
                closestNeighbor = neighbor;
            }
        }

        visitedNodes.add(node.getKey());
        unvisitedNodes.remove(node.getKey());

        populateMap(closestNeighbor, map, visitedNodes, unvisitedNodes);
    }

    private void populateKeys(Node node, Set<String> keys){
        if(node == null){
            // Nothing to do here.
            return;
        }

        if(keys.contains(node.getKey())){
            // If we have already been to this node skip it.
            return;
        }

        // add the node's key to the set of keys
        keys.add(node.getKey());

        // Get the keys of the neighboring nodes
        for(Node neighbor : node.getNeighbors()){
            populateKeys(neighbor, keys);
        }
    }



    public String findShortestPathWithPriorityQueue(Node source, Node destination){
        HashMap<String, DijkstraResult> map = populateMapWithPriorityQueue(source, destination.getKey());

        List<String> path = new ArrayList<>();
        path.add(destination.getKey());
        DijkstraResult previousNode = map.get(destination.getKey());
        while(previousNode.getFromNode() != null && !source.getKey().equals(previousNode.getFromNode().getKey())){
            path.add(previousNode.getFromNode().getKey());
            previousNode = map.get(previousNode.getFromNode().getKey());
        }
        path.add(source.getKey());

        // Reverse the path so that it starts from the beginning.
        Collections.reverse(path);

        return path.toString();
    }

    /**
     *
     *
     * @param weighedGraph
     *          A graph which represents the connections between the nodes and the cost of traveling
     *          between the nodes.
     * @param destinationKey
     *          Key of the destination node.
     * @return
     */
    private HashMap<String, DijkstraResult> populateMapWithPriorityQueue(Node weighedGraph, String destinationKey){
        Map<String, Node> flatGraph = new HashMap<>();
        populateKeys(weighedGraph, flatGraph);

        HashMap<String, DijkstraResult> result = new HashMap<>();
        Set<String> visitedNodes = new HashSet<>();
        Set<String> unvisitedNodes = new HashSet<>(flatGraph.keySet());
        PriorityQueue<DijkstraResult> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(x -> x.getWeight()));
        Node destinationNode = flatGraph.get(destinationKey);
        for(String key : flatGraph.keySet()){
            Node node = flatGraph.get(key);
            DijkstraResult resultRow = new DijkstraResult(node);
            resultRow.setDistanceToEnd(node.getDistanceToNode(destinationNode));
            if(key.equals(weighedGraph.getKey())){
                resultRow.setDistanceFromPrevious(0);
            }
            priorityQueue.add(resultRow);
            result.put(key, resultRow);
        }

        DijkstraResult resultRow = priorityQueue.poll();
        while(!unvisitedNodes.isEmpty() && !destinationKey.equals(resultRow.getNode().getKey())){
            Node node = resultRow.getNode();
            String key = node.getKey();

            int distanceToNode = resultRow.getDistanceFromPrevious();
            for(int i = 0; i < node.getNeighbors().size(); i++){
                Node neighbor = node.getNeighbors().get(i);
                DijkstraResult neighborResultRow = result.get(neighbor.getKey());
                double currDistanceToNeighbor = neighborResultRow.getWeight();
                double propDistanceToNeighbor = distanceToNode + node.getDistanceToNeighbors().get(i) + node.getDistanceToNode(destinationNode);
                if(propDistanceToNeighbor < currDistanceToNeighbor){
                    neighborResultRow.setDistanceFromPrevious(distanceToNode + node.getDistanceToNeighbors().get(i));
                    neighborResultRow.setFromNode(node);
                    priorityQueue.remove(neighborResultRow);
                    priorityQueue.add(neighborResultRow);
                }
            }

            visitedNodes.add(key);
            unvisitedNodes.remove(key);
            resultRow = priorityQueue.poll();
        }

        return result;
    }

    private void populateKeys(Node node, Map<String, Node> keys){
        if(node == null){
            // Nothing to do here.
            return;
        }

        if(keys.keySet().contains(node.getKey())){
            // If we have already been to this node skip it.
            return;
        }

        // add the node's key to the set of keys
        keys.put(node.getKey(), node);

        // Get the keys of the neighboring nodes
        for(Node neighbor : node.getNeighbors()){
            populateKeys(neighbor, keys);
        }
    }

}
