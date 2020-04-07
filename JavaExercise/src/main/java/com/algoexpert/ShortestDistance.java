package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistance {

    public static void main(String[] args) {

    }



    static class Graph{

        List<Node> nodes = new ArrayList<>();

        public void addNode(Node n){
            this.nodes.add(n);
        }
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        Node(String name){
            this.name = name;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
