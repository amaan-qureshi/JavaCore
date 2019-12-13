package com.dsProblems;

import com.core.structure.Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CheckMin {

    public static void main(String[] args) {

        Graph g = new Graph(8);
        g.adjacencyList[0].insertAtEnd(1);
        g.adjacencyList[1].insertAtEnd(2);
        g.adjacencyList[1].insertAtEnd(5);
        g.adjacencyList[2].insertAtEnd(3);
        g.adjacencyList[3].insertAtEnd(4);
        g.adjacencyList[4].insertAtEnd(7);
        g.adjacencyList[5].insertAtEnd(6);
        g.adjacencyList[6].insertAtEnd(7);

        System.out.println(findMin(g, 1, 7));
    }


    public static int findMin(Graph g, int source, int destination) {

        int numOfVertices = g.vertices;
        Queue<Integer> queue = new Queue<>(numOfVertices);
        boolean[] visited = new boolean[numOfVertices];

        queue.enqueue(source);
        visited[source] = true;

        int[] distance = new int[numOfVertices];


        while (!queue.isEmpty()) {

            int v = queue.dequeue();
            DoublyLinkedList<Integer>.Node node = g.adjacencyList[v].headNode;


            while (node != null) {

                if (!visited[node.data]) {

                    queue.enqueue(node.data);
                    visited[node.data] = true;
                    distance[node.data] = distance[v] + 1;

                }
                if (node.data == destination) {
                    return distance[destination];
                }
                node = node.nextNode;
            }

        }


        return -1;
    }
}