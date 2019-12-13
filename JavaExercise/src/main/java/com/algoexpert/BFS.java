package com.algoexpert;

import java.util.*;

class BFS {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {

            List<String> visited = new ArrayList<>();
            LinkedList<Node> queue = new LinkedList<>();

            queue.add(this); //add remove
            visited.add(this.name);
            array.add(this.name);

            while (!queue.isEmpty()) {
                Node n = queue.remove();
                for (Node c : n.children) {
                    if (!visited.contains(c.name)) {
                        visited.add(c.name);
                        array.add(c.name);
                    }
                    queue.add(c);
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