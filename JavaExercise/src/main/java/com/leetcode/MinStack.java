package com.leetcode;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        /*
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
         */
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-1);
        System.out.println(m.getMin());
        System.out.println(m.top());
        m.pop();
        System.out.println(m.getMin());;
    }

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {

        if(stack.isEmpty() || x < min.peek()){
            min.push(x);
        }
        else{
            min.push(min.peek());
        }
        stack.push(x);


    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
