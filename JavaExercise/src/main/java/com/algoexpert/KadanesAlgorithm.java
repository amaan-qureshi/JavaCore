package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        System.out.println(kadanesAlgorithm(new int[]{3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4}));
    }

    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.

        int[] maxSums = new int[array.length];
        maxSums[0] = array[0];
        int largest = array[0];

        for(int i=1 ;i < array.length ; i++){

            maxSums[i] = Math.max(maxSums[i-1] + array[i],array[i]);
            largest = Math.max(largest,maxSums[i]);

            List<Integer> n = new ArrayList<>();

        }

        return largest;
    }
}
