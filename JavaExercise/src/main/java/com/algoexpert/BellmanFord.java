package com.algoexpert;

import java.util.*;

public class BellmanFord {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length == 0) return -1;

        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {

            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<int[]>());
            }

            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }


        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> (a.cost - b.cost));

        q.add(new Node(src, 0, -1));

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr.city == dst) {
                return curr.cost;
            }

            if (curr.stop < K) {
                List<int[]> nexts = graph.getOrDefault(curr.city, new ArrayList<int[]>());

                for (int[] next : nexts) {
                    q.add(new Node(next[0], curr.cost + next[1], curr.stop + 1));
                }
            }
        }

        return -1;
    }
}


class Node {
    int city;
    int cost;
    int stop;

    public Node(int city, int cost, int stop) {
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }

    public int findCheapestPriceDijikstra(int n, int[][] flights, int src, int dst, int K) {

        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == K + 1) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    } else if (stops < currentStops[nei]) {

                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        currentStops[nei] = stops;
                    }
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[] dis = new int[n];
        for (int i = 0; i < n; i++)
            dis[i] = Integer.MAX_VALUE;

        dis[src] = 0;

        for (int i = 0; i < K + 1; i++) {

            for (int j = 0; j < flights.length; j++) {

                if (dis[flights[j][0]] + flights[j][2] < dis[flights[j][1]])

                    dis[flights[j][1]] = dis[flights[j][0]] + flights[j][2];

            }
        }

        return dis[dst] < Integer.MAX_VALUE ? dis[dst] : -1;
    }

    static void BellmanFord(int graph[][], int V, int E, int src) {

        // Initialize distance of all vertices as infinite.
        int[] dis = new int[V];
        for (int i = 0; i < V; i++)
            dis[i] = Integer.MAX_VALUE;

        // initialize distance of source as 0
        dis[src] = 0;

        // Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other
        // vertex can have at-most |V| - 1 edges

        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < E; j++) {

                if (dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]])

                    dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2];

            }
        }

        // check for negative-weight cycles.
        // The above step guarantees shortest
        // distances if graph doesn't contain
        // negative weight cycle. If we get a
        // shorter path, then there is a cycle.
        for (int i = 0; i < E; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            int weight = graph[i][2];
            if (dis[x] != Integer.MAX_VALUE && dis[x] + weight < dis[y])
                System.out.println("Graph contains negative weight cycle");
        }

        System.out.println("Vertex Distance from Source");

        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dis[i]);

    }
}
