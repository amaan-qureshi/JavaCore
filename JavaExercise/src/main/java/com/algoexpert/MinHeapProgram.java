package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapProgram {

    public static void main(String[] args) {


        MinHeapProgram.MinHeap m = new MinHeap(Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41));
        System.out.print(m);

    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }


        public List<Integer> buildHeap(List<Integer> array) {

            int n = (array.size() - 1) / 2;

            for (int i = n; n >= 0; n--) {
                siftDown(n, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
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

        public void siftUp(int currentIdx, List<Integer> heap) {

            int parent = (currentIdx - 1) / 2;
            if (parent > 0 && heap.get(parent) > heap.get(currentIdx)) {
                swap(heap, parent, currentIdx);
                siftUp(parent, heap);
            }

        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            int removed = heap.get(0);
            swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);

            return removed;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(List<Integer> array, int p, int q) {
            int temp = array.get(p);
            array.set(p, array.get(q));
            array.set(q, temp);
        }
    }
}
