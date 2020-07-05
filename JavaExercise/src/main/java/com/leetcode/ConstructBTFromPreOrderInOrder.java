package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBTFromPreOrderInOrder {

    public static void main(int[] args) {
        new ConstructBTFromPreOrderInOrder().buildTree(new int[]{3,9,8,11,20,15,4,7},new int[]{8,9,11,3,4,15,20,7});

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }


        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    int i,j;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof ConstructBTFromPreOrderInOrder)) return false;
        ConstructBTFromPreOrderInOrder that = (ConstructBTFromPreOrderInOrder) o;
        return i == that.i &&
                j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}


