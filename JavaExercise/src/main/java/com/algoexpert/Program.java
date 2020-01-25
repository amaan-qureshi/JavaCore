package com.algoexpert;// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Program p = new Program();
        p.insert(5);
        System.out.println(p.getMedian());
        p.insert(10);
        System.out.println(p.getMedian());
        p.insert(100);
        System.out.println(p.getMedian());
        p.insert(200);
        System.out.println(p.getMedian());
        p.insert(6);
        System.out.println(p.getMedian());
        p.insert(13);
        System.out.println(p.getMedian());


    }

    List<Integer> maxHeap = new ArrayList<>();
    List<Integer> minHeap = new ArrayList<>();

    public double getMedian() {

        if (minHeap.size() - maxHeap.size() == 1) {
            return minHeap.get(0);
        } else if (maxHeap.size() - minHeap.size() == 1) {
            return maxHeap.get(0);
        } else if (minHeap.size() == maxHeap.size()) {
            if (maxHeap.size() == 0) {
                return -1;
            }
            return (double) ((minHeap.get(0) + maxHeap.get(0)) / (double) 2);
        } else {
            return -1;
        }
    }

    public void insert(int number) {
        // Write your code here.
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.add(number);
            return;
        }

        if (number >= maxHeap.get(0)) {
            insertIntoMin(number);

        } else {
            insertIntoMax(number);
        }

        balanceHeaps();

    }

    public void balanceHeaps() {

        if (maxHeap.size() - minHeap.size() > 1) {

            int number = maxHeap.get(0);
            insertIntoMin(number);
            removeFromMax();

        } else if (minHeap.size() - maxHeap.size() > 1) {

            int number = minHeap.get(0);
            insertIntoMax(number);
            removeFromMin();
        }

    }

    public void removeFromMax() {

        int number = maxHeap.get(0);
        swap(maxHeap, 0, maxHeap.size() - 1);
        maxHeap.remove(maxHeap.size() - 1);
        siftDownMax(0, maxHeap.size() - 1, maxHeap);
    }

    public void removeFromMin() {

        int number = minHeap.get(0);
        swap(minHeap, 0, minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);
        siftDownMin(0, minHeap.size() - 1, minHeap);
    }


    public void siftDownMax(int currentIdx, int endIdx, List<Integer> heap) {
        // Write your code here.

        int largest = currentIdx;

        while (largest < heap.size() / 2) {

            int left = (2 * currentIdx) + 1;
            int right = (2 * currentIdx) + 2;

            if (left < heap.size() && heap.get(currentIdx) < heap.get(left)) {
                largest = left;
            }
            if (right < heap.size() && heap.get(largest) < heap.get(right)) {
                largest = right;
            }
            if (largest != currentIdx) {
                swap(heap, largest, currentIdx);
                currentIdx = largest;
            } else {
                break;
            }
        }
    }

    public void siftDownMin(int currentIdx, int endIdx, List<Integer> heap) {
        // Write your code here.

        int smallest = currentIdx;

        while (smallest < heap.size() / 2) {

            int left = (2 * currentIdx) + 1;
            int right = (2 * currentIdx) + 2;

            if (left < heap.size() && heap.get(currentIdx) > heap.get(left)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(smallest) > heap.get(right)) {
                smallest = right;
            }
            if (smallest != currentIdx) {
                swap(heap, smallest, currentIdx);
                currentIdx = smallest;
            } else {
                break;
            }
        }
    }

    public void insertIntoMax(int number) {
        maxHeap.add(number);
        siftUpMax(maxHeap.size() - 1, maxHeap);
    }

    public void siftUpMax(int currentIdx, List<Integer> heap) {

        int parent = (currentIdx - 1) / 2;
        if (parent >= 0 && heap.get(parent) < heap.get(currentIdx)) {
            swap(heap, parent, currentIdx);
            siftUpMax(parent, heap);
        }
    }

    public void insertIntoMin(int number) {
        minHeap.add(number);
        siftUpMin(minHeap.size() - 1, minHeap);
    }

    public void siftUpMin(int currentIdx, List<Integer> heap) {

        int parent = (currentIdx - 1) / 2;
        if (parent >= 0 && heap.get(parent) > heap.get(currentIdx)) {
            swap(heap, parent, currentIdx);
            siftUpMin(parent, heap);
        }

    }

    public void swap(List<Integer> array, int p, int q) {
        int temp = array.get(p);
        array.set(p, array.get(q));
        array.set(q, temp);
    }

}