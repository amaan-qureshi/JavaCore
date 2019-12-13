package com.dsProblems;

import com.core.structure.Stack;

class QueueWithStack <V> {

    Stack<V> s1;
    Stack<V> s2;
    boolean isLastOpEnqueue;

    public QueueWithStack(int maxSize){
        // Write -- Your -- Code
        s1 = new Stack<>(maxSize);
        s2 = new Stack<>(maxSize);
    }

    public void enqueue(V value){
        // Write -- Your -- Code
        s1.push(value);
    }
    public V dequeue(){
        // Write -- Your -- Code

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        V val = s2.pop();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }
    public boolean isEmpty(){
        //Write -- Your -- Code
        return s1.isEmpty();
    }

    public static void main(String[] args) {




    }

}