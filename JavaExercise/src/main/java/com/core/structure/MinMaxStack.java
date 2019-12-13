package com.core.structure;

import java.util.LinkedList;

public class MinMaxStack {


    private LinkedList<Integer> mainStack = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();
    private LinkedList<Integer> maxStack = new LinkedList<>();

    public Integer peek() {
        // Write your code here.
        return mainStack.peek();
    }

    public Integer pop() {
        // Write your code here.
        mainStack.pop();
        maxStack.pop();
        return mainStack.pop();
    }

    public void push(Integer number) {
        // Write your code here.

        if(mainStack.isEmpty()){
            mainStack.push(number);
            minStack.push(number);
            maxStack.push(number);
            return;
        }

        mainStack.push(number);

        if(number < minStack.peek()){
            minStack.push(number);
        }
        else{
            minStack.push(minStack.peek());
        }

        if(number > maxStack.peek()){
            maxStack.push(number);
        }
        else{
            maxStack.push(maxStack.peek());
        }


    }

    public Integer getMin() {
        // Write your code here.
        return minStack.peek();
    }

    public Integer getMax() {
        // Write your code here.
        return maxStack.peek();
    }


    public static void main(String[] args) {

        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(2);
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.push(7);
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.push(1);
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.push(8);
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.push(3);
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.push(9);
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        System.out.println("------------------------------------");


        minMaxStack.pop();
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.pop();
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.pop();
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.pop();
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.pop();
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

        minMaxStack.pop();
        System.out.print(minMaxStack.getMin()+" ");
        System.out.print(minMaxStack.getMax()+" ");
        System.out.print(minMaxStack.peek()+" ");
        System.out.println();

    }
}