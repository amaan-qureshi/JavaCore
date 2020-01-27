package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ContinuosMedian {

    static class ContinuousMedianHandler {

        double median = 0;
        List<Integer> maxHeap = new ArrayList<>();
        List<Integer> minHeap = new ArrayList<>();

        public void insert(int number) {

            if(maxHeap.size()==0){
                maxHeap.add(number);
                calculateMedian();
                return;
            }



        }

        private void calculateMedian() {

            if(maxHeap.size() - minHeap.size() == 1){
                median = maxHeap.get(0);
            }
            else if(minHeap.size() - maxHeap.size() == 1){
                median = minHeap.get(0);
            }
            else if(minHeap.size() == maxHeap.size()){
                median = ( (double)maxHeap.get(0) + (double)minHeap.get(0) ) / (double)2;
            }
            else{
                throw new IllegalStateException("Method not allowed");
            }

        }

        public double getMedian() {
            return median;
        }

        void insertIntoMinHeap(int i){

        }

        void insertIntoMaxHeap(int i){

        }

        void removeFromMinHeap(int i){

        }

        void removeFromMaxHeap(int i){

        }
    }

}
