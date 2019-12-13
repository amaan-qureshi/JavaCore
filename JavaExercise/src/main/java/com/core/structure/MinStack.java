package com.core.structure;

public class MinStack {

    int maxSize;
    int[] stack;
    int[] minstack;
    int p;
    int mp;

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        stack = new int[maxSize];
        minstack = new int[maxSize];
        p = -1;
        mp = -1;
    }

    //removes and returns value from stack
    public Integer pop() {
        // Write -- Your -- Code
        if (isEmpty()) {
            System.err.println("Stack is Empty");
        }

        int val = stack[p];
        p--;
        return val;
    }

    //pushes value into the stack
    public void push(Integer value) {
        // Write -- Your -- Code
        if (isFull()) {
            System.err.println("Stack is Full");
        }
       // System.out.println("Item : " + value);
        if (p == -1) {
            p++;
            stack[p] = value;
            minstack[p] = value;
        } else {
            if (minstack[p] < value) {
                int tmp = minstack[p];
                p++;
                stack[p] = value;
                minstack[p] = tmp;

            } else {
                p++;
                stack[p] = value;
                minstack[p] = value;
            }

        }

    }

    //returns minimum value in O(1)
    public int min() {
        // Write -- Your -- Code
        return minstack[p];
    }

    private boolean isEmpty() {
        return p == -1;
    }

    private boolean isFull() {
        return p == (maxSize - 1);
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack(5);
        minStack.push(5);
        System.out.println(minStack.min());
        minStack.push(7);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(10);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());


    }

}
