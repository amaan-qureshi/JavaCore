package com.core.structure;

import org.junit.jupiter.api.Test;

public class Stack<T> {


    private T[] arr;

    private int pointer = -1;

    private int maxSize;

    public Stack(int size) {
        this.maxSize = size;
        arr = (T[]) new Object[size];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void push(T t) {

        if (!isFull()) {
            arr[++pointer] = t;
        } else {
            System.err.println("Stack is Full");
        }
    }

    public T pop() {

        if (!isEmpty()) {
            return arr[pointer--];
        } else {
            System.err.println("Stack is Empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public boolean isFull() {
        return pointer == arr.length - 1;
    }

    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<Integer>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }


}
