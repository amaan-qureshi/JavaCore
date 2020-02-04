package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumPathBinary {

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(BinaryTree tree){

        return findMaxPathSum(tree).get(1);



    }

    public static List<Integer> findMaxPathSum(BinaryTree tree){

        if(tree == null)
            return Arrays.asList(0,0);

        List<Integer> leftMaxPathSums = findMaxPathSum(tree.left);
        int leftBranchSum = leftMaxPathSums.get(0);
        int leftPathSums = leftMaxPathSums.get(1);

        List<Integer> rightMaxPathSums = findMaxPathSum(tree.right);
        int rightBranchSum = rightMaxPathSums.get(0);
        int rightPathSums = rightMaxPathSums.get(1);

        int maxBranch = Math.max(leftBranchSum,rightBranchSum);
        int maxBranchSum = Math.max(maxBranch+tree.value,tree.value);

        int maxPathSumAtRoot = Math.max(leftBranchSum+tree.value+rightBranchSum,maxBranchSum);
        int maxPathSum = Math.max(maxPathSumAtRoot,Math.max(leftPathSums,rightPathSums));

        return Arrays.asList(maxBranchSum,maxPathSum);

    }


    public static int maxPathSum(BinaryTree tree,BinaryTree root) {
        // Write your code here.

        if(tree == null) return 0;

        int l = maxPathSum(tree.left,root);
        int r = maxPathSum(tree.right,root);

        if(tree == root)
            return Math.max(l+r+tree.value,Math.max(r+tree.value,Math.max(tree.value,l+tree.value)));

        return l>r? l + tree.value: r+tree.value;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
