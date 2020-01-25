package com.core.structure;

public class BST {

    private BSTNode root;

    public boolean isEmpty() {
        return root == null;
    }

    public void addNode(int value) {

        this.root = recursiveInsert(value, root);

    }

    private BSTNode recursiveInsert(int value, BSTNode current) {

        if (current == null) {
            return new BSTNode(value);
        }

        if (value < current.getData()) {
            current.setLeftChild(recursiveInsert(value, current.getLeftChild()));
        } else if (value > current.getData()) {
            current.setRightChild(recursiveInsert(value, current.getRightChild()));
        } else {
            return current;
        }

        return current;
    }

    public boolean deleteNode(int value, BSTNode current) {

        if (isEmpty()) {
            return false;
        }

        BSTNode parent = null;

        while (current != null && current.getData() != value) {

            parent = current;

            if (value < parent.getData()) {
                current = parent.getLeftChild();
            } else {
                current = parent.getRightChild();
            }

        }

        if (current == null) {
            return false;
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {

            if (root.getData() == current.getData()) {
                setRoot(null);
                return true;
            } else if (value < parent.getData()) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
            return true;
        } else if (current.getLeftChild() != null && current.getRightChild() == null) {

            if (root.getData() == current.getData()) {
                setRoot(null);
                return true;
            } else if (value < parent.getData()) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
            return true;
        } else if (current.getLeftChild() == null && current.getRightChild() != null) {

            if (value < parent.getData()) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
            return true;

        } else {

            BSTNode leastNode = findLeastNode(current.getRightChild());
            int temp = leastNode.getData();
            deleteNode(temp, current);
            current.setData(value);
            return true;


        }

    }

    private BSTNode findLeastNode(BSTNode current) {

        BSTNode temp = current;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    public BSTNode searchNode(int value) {

        if (this.root == null) {
            return null;
        }

        BSTNode node = this.root;

        while (node != null) {

            if (node.getData() == value) {
                return node;
            }

            if (value < node.getData()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }

        }

        return null;

    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }
}
