package com.dsProblems;

import com.core.structure.Queue;

public class CheckMotherVertex {

    public static void main(String[] args) {

        Graph g = new Graph(3);
       /* g.adjacencyList[0].insertAtEnd(1);
        g.adjacencyList[0].insertAtEnd(2);
        g.adjacencyList[3].insertAtEnd(0);
        g.adjacencyList[3].insertAtEnd(1);*/
/*        g.adjacencyList[0].insertAtEnd(1);
        g.adjacencyList[1].insertAtEnd(2);
        g.adjacencyList[3].insertAtEnd(0);
        g.adjacencyList[3].insertAtEnd(1);*/
        /*Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);*/
   /*     g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(3,0);
        g.addEdge(3,1);*/
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.printGraph();

        System.out.print(findMotherVertex(g));

    }

    public static int findMotherVertex(Graph g){

        int totalVertices = g.vertices;

        for(int i = 0 ; i < totalVertices ; i++){

            int uniqueNodes = bfs(g,i);

            if(uniqueNodes == totalVertices)
                return i;

        }
        return -1;
    }

    public static int bfs(Graph g, int source){

        int uniqueNodes = 1;
        Queue<Integer> queue = new Queue<>(g.vertices);
        boolean[] visited = new boolean[g.vertices];

        queue.enqueue(source);
        visited[source] = true;
        while(!queue.isEmpty()){

            int v = queue.dequeue();


            DoublyLinkedList<Integer> dl = g.adjacencyList[v];
            DoublyLinkedList<Integer>.Node n = dl.headNode;

            while(n !=null){

                if(!visited[n.data]){
                    queue.enqueue(n.data);
                    visited[n.data] = true;
                    uniqueNodes++;
                }
                n = n.nextNode;

            }

        }

        return uniqueNodes;
    }


}
