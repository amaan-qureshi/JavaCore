package com;
import java.util.*;

class Program {

    public static void main(String[] args) {

        System.out.println(minHeightBst(Arrays.asList(1,2,5,7,10,13,14,15,22)));

    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.

        int middle = array.size()/2;
        BST root = new BST(array.get(middle));
        minHeightBst(root,array.subList(0,middle),array.subList(middle+1,array.size()));
        return root;
    }

    public static void minHeightBst(BST root,List<Integer> firstArray,List<Integer> secondArray) {

        if(firstArray.size()!=0){
            int middle = firstArray.size()/2;
            root.insert(firstArray.get(middle));
            minHeightBst(root,firstArray.subList(0,middle),firstArray.subList(middle+1,firstArray.size()));
        }
        if(secondArray.size()!=0){
            int middle = secondArray.size()/2;
            root.insert(secondArray.get(middle));
            minHeightBst(root,secondArray.subList(0,middle),secondArray.subList(middle+1,secondArray.size()));
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
