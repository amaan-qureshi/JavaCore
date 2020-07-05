package com.algoexpert;

public class BSTImp {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
            }

            return this;
        }

        public boolean contains(int value) {

            if (this.value < value) {
                if (this.left == null) {
                    return false;
                } else {
                    return this.left.contains(value);
                }
            } else if (this.value > value) {
                if (this.right == null) {
                    return false;
                } else {
                    return this.right.contains(value);
                }
            } else {
                return true;
            }
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (value < this.value) {
                if (this.left != null) {
                    this.left.remove(value, this);
                }
            } else if (value > this.value) {
                if (this.right != null) {
                    this.right.remove(value, this);
                }
            } else {
                if (left != null && right != null) {
                    this.value = this.right.getMinValue();
                    this.right.remove(this.value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        this.right = left.right;
                        this.left = left.left;
                    } else if (this.right != null) {
                        this.value = right.value;
                        this.left = right.left;
                        this.right = right.right;
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
        }

        public int getMinValue() {
            if (this.left == null) {
                return this.value;
            } else {
                return this.left.getMinValue();
            }
        }

    }
}