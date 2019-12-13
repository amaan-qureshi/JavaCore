package com.algoexpert;

import java.util.*;

public class DFS {

    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            List<String> visited = new ArrayList<>();
            LinkedList<Node> stack = new LinkedList<>();
            stack.push(this);

            while(!stack.isEmpty()){

                Node n = stack.pop();
                visited.add(n.name);
                array.add(n.name);

                Collections.reverse(n.children);
                for(Node c : n.children){

                    if(!visited.contains(c.name)){
                        visited.add(c.name);
                        stack.push(c);
                    }
                }

            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
