package com.leetcode2;

import java.util.*;

public class CriticalConnections {

    public static void main(String[] args) {

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        criticalConnections(4,connections);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adjencyList = preadjenyList(n, connections);
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> connection : connections) {

            //remove connections
            int startNode = connection.get(0);
            int endNode = connection.get(1);

            adjencyList.get(startNode).remove((Integer) endNode);
            adjencyList.get(endNode).remove((Integer) startNode);

            //dfs and find no of visited nodes
            boolean[] visitedNodes = new boolean[n];
            Integer noOfVisitedNodes = 0;
            int no = dfs(0,adjencyList, visitedNodes, 0);

            //if no of visited nodes < n add to result
            if (no < n)
                result.add(connection);


            //add the connection back
            adjencyList.get(startNode).add(endNode);
            adjencyList.get(endNode).add(startNode);

        }

        return result;

    }

    public static int dfs(int root,List<List<Integer>> adjencyList, boolean[] visitedNodes, int noOfVisitedNodes) {

        if(visitedNodes[root]) return noOfVisitedNodes;

        visitedNodes[root] = true;
        noOfVisitedNodes++;

        for( int neighbour : adjencyList.get(root)) {
            noOfVisitedNodes = dfs(neighbour,adjencyList, visitedNodes, noOfVisitedNodes);
        }

        return noOfVisitedNodes;

    }


    public static List<List<Integer>> preadjenyList(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int startNode = connections.get(i).get(0);
            int endNode = connections.get(i).get(1);
            adjencyList.get(startNode).add(endNode);
            adjencyList.get(endNode).add(startNode);

        }
        return adjencyList;
    }

}
