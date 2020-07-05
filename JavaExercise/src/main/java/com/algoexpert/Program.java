package com.algoexpert;// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BiFunction;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {

    public static void main(String[] args) {

        LinkedList<Integer> stack = new LinkedList<>();

    }

    static class ContinuousMedianHandler {

        Heap lowers = new Heap((a, b) -> a > b, new ArrayList<>());
        Heap greaters = new Heap((a, b) -> a < b, new ArrayList<>());
        double median = 0;
        BiFunction<Integer,Integer, Boolean> comp = (a, b) -> a < b;

        public void insert(int number) {
            // Write your code here.
            if (lowers.length == 0 || number < lowers.peek()) {
                lowers.insert(number);
            } else {
                greaters.insert(number);
            }
            rebalance();
            updateMedian();
        }

        public double getMedian() {
            return median;
        }


        public void rebalance() {
            if (lowers.length - greaters.length == 2) {
                greaters.insert(lowers.remove());

            } else if (lowers.length - greaters.length == -2) {
                lowers.insert(greaters.remove());
            }


        }

        public void updateMedian() {

            if (lowers.length == greaters.length) {
                median = ((double) lowers.peek() + (double) greaters.peek()) / 2;
            } else if (lowers.length > greaters.length) {
                median = lowers.peek();
            } else {
                median = greaters.peek();
            }

        }

        static class Heap {

            private BiFunction<Integer, Integer, Boolean> comparisonFunc;
            private List<Integer> heap = new ArrayList<Integer>();
            private int length = 0;

            public Heap(BiFunction<Integer, Integer, Boolean> comparisonFunc, List<Integer> array) {

                this.comparisonFunc = comparisonFunc;
                this.heap = buildHeap(array);
                this.length = heap.size();
            }

            public int peek() {
                return heap.get(0);
            }

            public void insert(int value) {
                heap.add(value);
                siftUp(heap.size() - 1, heap);
                length++;
            }

            public int remove() {
                swap(0, heap.size() - 1, heap);
                int value = heap.get(heap.size() - 1);
                heap.remove(heap.size() - 1);
                siftDown(0, heap.size() - 1, heap);
                length--;
                return value;
            }

            public List<Integer> buildHeap(List<Integer> array) {
                int parent = (array.size() - 2) / 2;
                for (int i = parent; i >= 0; i--) {
                    siftDown(i, array.size() - 1, array);
                }
                return array;
            }

            private void swap(int s, int d, List<Integer> array) {
                int val1 = array.get(s);
                array.set(s, array.get(d));
                array.set(d, val1);
            }

            public void siftUp(int idx, List<Integer> array) {

                int parentIdx = (idx - 1) / 2;

                while (parentIdx > 0) {

                    if (comparisonFunc.apply(array.get(idx), array.get(parentIdx))) {
                        swap(idx, parentIdx, array);
                        idx = parentIdx;
                        parentIdx = (idx - 1) / 2;
                    } else {
                        return;
                    }

                }

            }

            public void siftDown(int idx, int endIdx, List<Integer> array) {

                int child1Idx = (idx * 2) + 1;

                while (child1Idx <= endIdx) {

                    int child2Idx = (idx * 2) + 2 <= endIdx ? (idx * 2) + 2 : -1;
                    int swapIdx;
                    if (child2Idx != -1) {

                        if (comparisonFunc.apply(array.get(child2Idx), array.get(child1Idx))) {
                            swapIdx = child2Idx;
                        } else {
                            swapIdx = child1Idx;
                        }

                    } else {
                        swapIdx = child1Idx;
                    }

                    if (comparisonFunc.apply(array.get(swapIdx), array.get(idx))) {
                        swap(swapIdx, idx, array);
                        idx = swapIdx;
                        child1Idx = (idx * 2) + 1;
                    } else {
                        return;
                    }

                }
            }
        }

    }
}