package com.algoexpert;

import java.lang.reflect.Array;
import java.util.*;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {//10,70,20,30,50,11,30
        System.out.println(maxSumIncreasingSubsequence(new int[]{10,15,4,5,11,14,31,25,31,23,25,31,50}));
    }


    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        Map<Integer,List<Integer>> sumMap = new HashMap<>();
        int[] sums = array.clone();
        sums[0] = array[0];
        sumMap.put(sums[0],new ArrayList<>(Arrays.asList(sums[0])));
        int maxSums = sums[0];

        for(int i = 1 ; i < array.length ; i++){


            int currentSum = 0;
            int previousNum = Integer.MIN_VALUE;
            List<Integer> l = new ArrayList<>();

            for(int j = 0 ; j <= i ; j++){
                if(array[j] > previousNum && array[j] <= array[i]){
                    l.add(array[j]);
                    currentSum +=array[j];
                    previousNum = array[j];
                }

            }

            if(currentSum<sums[i]){
                currentSum = sums[i];
                sumMap.put(sums[i],new ArrayList<>(Arrays.asList(sums[i])));
            }
            else {
                sumMap.put(currentSum, l);
                sums[i] = currentSum;
            }

            if (maxSums < currentSum) {
                maxSums = currentSum;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(maxSums);
        result.add(l1);
        result.add(sumMap.get(maxSums));

        return result;
    }

}
