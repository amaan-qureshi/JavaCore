package com.algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {


        int[] distances = new int[n];

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < flights.length ; i++){
            graph[flights[i][0]].add(flights[i][1]);
        }

        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        q.add(new int[]{src,0,0});

        return -1;
    }

}
