package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YoungestCommonAns {

    public static Node lca(Node root, int v1, int v2) {

        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }

        return root;

    }

    public static Node lca1(Node root, int v1, int v2) {
        // Write your code here.

        List<Node> l1 = find(root, v1);

        List<Node> l2 = find(root, v2);


        List<Node> min;
        List<Node> max;

        if (l1.size() > l2.size()) {
            max = l1;
            min = l2;
        } else {
            max = l2;
            min = l1;
        }

        for(int i = min.size()-1 ; i >=0 ; i--){



            if (max.contains(min.get(i))) {
                return min.get(i);
            }
        }


        return null;
    }

    public static List<Node> find(Node root, int v) {

        List<Node> list = new ArrayList<>();

        Node current = root;
        list.add(current);

        while (current != null) {

            if (current.data == v) {
                return list;
            }
            if (v < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            list.add(current);
        }


        return null;

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        Node root = null;
        root = insert(root, 8);
        root = insert(root, 4);
        root = insert(root, 9);
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 6);
        root = insert(root, 5);

        Node ans = lca(root,1, 2);
        System.out.println(ans.data);
    }

}


class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}