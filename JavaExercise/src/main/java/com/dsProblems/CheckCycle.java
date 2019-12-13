package com.dsProblems;

class CheckCycle {

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.adjacencyList[0].insertAtEnd(1);
        g.adjacencyList[1].insertAtEnd(2);
        g.adjacencyList[2].insertAtEnd(3);
        g.adjacencyList[3].insertAtEnd(1);
        g.adjacencyList[4].insertAtEnd(2);


        System.out.print(detectCycle(g));

    }

    public static boolean detectCycle(Graph g){
        // Write -- Your -- Code
        int noOfVertices = g.vertices;



        for(int v = 0 ; v < noOfVertices ; v++){
            System.out.print(v);
            if(dfsLoop(g,v)){
                return true;
            }
        }
        return false;
    }

    public static boolean dfsLoop(Graph g, int source){

        Stack<Integer> stack = new Stack<>(g.vertices);
        boolean[] visited = new boolean[g.vertices];
        boolean[] onStack = new boolean[g.vertices];
        stack.push(source);

        while(!stack.isEmpty()){

            int v = stack.pop();
            onStack[v] = false;
            visited[v] = true;


            DoublyLinkedList<Integer> children =  g.adjacencyList[v];

            if(children != null){
                DoublyLinkedList<Integer>.Node n = children.headNode;
                while(n!=null){

                    if(onStack[n.data]){
                        return true;
                    }

                    if(!visited[n.data]) {
                        stack.push(n.data);
                        onStack[n.data] = true;
                    }
                    n = n.nextNode;
                }
            }

        }


        return false;
    }

}
