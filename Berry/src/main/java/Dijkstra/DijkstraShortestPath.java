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

        return path.toString();
    }

    public HashMap<String, DistanceToNode> populateMap(Node weighedGraph){

        // Get the list of unique node values
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
//        Map<Integer, String> priorityQueue
        PriorityQueue<DijkstraResult> priorityQueue = new PriorityQueue<>(Comparator.comparing(x -> x.getDistance()));
        for(String key : keys){
            result.put(key, new DistanceToNode(null, Integer.MAX_VALUE));
        }

        while(!unvisitedNodes.isEmpty()){

        }


//        populateMap(weighedGraph, result, visitedNodes, unvisitedNodes);

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

}
