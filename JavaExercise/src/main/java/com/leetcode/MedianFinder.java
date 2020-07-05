package com.leetcode;
import java.util.*;


public class MedianFinder {

    public static void main(String[] args) {

        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        System.out.println(m.findMedian());
        m.addNum(-2);
        System.out.println(m.findMedian());
        m.addNum(-3);
        System.out.println(m.findMedian());
        m.addNum(-4);
        System.out.println(m.findMedian());
        m.addNum(-5);
        System.out.println(m.findMedian());
    }

    PriorityQueue<Integer> startHeap;
    PriorityQueue<Integer> endHeap;

    public MedianFinder() {

        startHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        endHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1,o2));

    }

    public void addNum(int num) {

        if(startHeap.isEmpty() || num < startHeap.peek()){
            startHeap.offer(num);
        }
        else{
            endHeap.offer(num);
        }
        balanceHeap();
    }

    public void balanceHeap(){

        if(startHeap.size()-endHeap.size()>1){
            endHeap.offer(startHeap.poll());

        }
        else if(endHeap.size()-startHeap.size()>1){
            startHeap.offer(endHeap.poll());
        }

    }

    public double findMedian() {
        if(startHeap.size() == endHeap.size()) {
            return (double)(startHeap.peek()+endHeap.peek())/2;

        }
        else if(startHeap.size() > endHeap.size()){
            return startHeap.peek();
        }
        else{
            return endHeap.peek();
        }

    }
}
