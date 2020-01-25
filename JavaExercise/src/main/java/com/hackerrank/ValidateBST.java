package com.hackerrank;

import java.util.Stack;

public class ValidateBST {

    public static boolean validateBst(BST tree) {

     /*return validateBst(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);*/
    Stack<BST> stack = new Stack<>();
    BST current = tree;

    while(current !=null || stack.size() !=0){

        while(current !=null){

            stack.push(current);
            current = current.left;

        }

        current = stack.pop();

        if(stack.size()>0 && current.value > stack.peek().value){
            return false;
        }

        if(current.right !=null && current.right.value <= current.value){
            return false;
        }

        current = current.right;

    }

    return true;

    }

    public static boolean validateBst(BST tree, int min ,int max) {

        if(tree.value < min || tree.value >= max ){
            return false;
        }

        if(tree.left!=null && !validateBst(tree.left,min,tree.value)){
            return false;
        }

        if(tree.right!=null && !validateBst(tree.right,tree.value,max)){
            return false;
        }
        return true;
    }



    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

