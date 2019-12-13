package com.dsProblems;

class CheckDFS {

    //Depth First Traversal of Graph g from source vertex
    public static String dfsTraversal(Graph g, int source) {
        String result = "";
        int num_of_vertices = g.vertices;
        boolean[] visited = new boolean[num_of_vertices];
        Stack<Integer> stack = new Stack<>(num_of_vertices);

        stack.push(source);


        while(!stack.isEmpty()){

            Integer vertex = stack.pop();
            visited[vertex] = true;
            result = result+vertex;

            DoublyLinkedList<Integer> list = g.adjacencyList[vertex];

            DoublyLinkedList<Integer>.Node node = list.headNode;

            while(node != null){

                if(!visited[node.data]){
                    stack.push(node.data);
                }
                node = node.nextNode;

            }


        }


        // Write - Your - Code
        return result; //For the above graph, it should return "01342" or "02143"
    }
}