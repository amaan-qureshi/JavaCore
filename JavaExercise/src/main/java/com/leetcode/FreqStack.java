package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class FreqStack {

    public static void main(String[] args) {

        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        PriorityQueue<Integer> startHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        PriorityQueue<Integer> endHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1,o2));

    }

    Map<Integer,Stack<Integer>> freqStackMap;
    Map<Integer,Integer> freqMap;
    int maxFrequency;

    public FreqStack() {
        freqStackMap = new HashMap<>();
        freqMap = new HashMap<>();
        maxFrequency = Integer.MIN_VALUE;
    }

    public void push(int x) {

        int freq = freqMap.getOrDefault(x,0)+1;
        freqMap.put(x,freq);
        if(freq > maxFrequency)
            maxFrequency = freq;

        freqStackMap.computeIfAbsent(freq,z -> new Stack<>()).push(x);

    }

    public int pop() {

        int maxFrequencyEle = freqStackMap.get(maxFrequency).pop();
        freqMap.put(maxFrequencyEle,freqMap.get(maxFrequencyEle) - 1);

        if(freqStackMap.get(maxFrequency).size()==0){
            maxFrequency--;
        }

        return maxFrequencyEle;
    }
}
