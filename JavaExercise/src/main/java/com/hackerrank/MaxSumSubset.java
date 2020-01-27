package com.hackerrank;

import java.util.Arrays;

public class MaxSumSubset {

    public static void main(String[] args) {
        int[] arr = {3,5,-7,8,10};
        System.out.print(maxSubsetSum(arr));
    }

    static int maxSubsetSum(int[] arr) {

        if(arr.length == 0){
            return -1;
        }
        else if(arr.length == 1){
            return arr[0];
        }
        else if(arr.length == 2){
            return arr[0] > arr[1] ? arr[0] : arr[1];
        }

        int[] maxSumArray = new int[arr.length];
        //Arrays.fill(maxSumArray, Integer.MIN_VALUE);

        maxSumArray[0] = arr[0];
        maxSumArray[1] = arr[0] > arr[1] ? arr[0] : arr[1];

        for(int i = 2 ; i < maxSumArray.length ; i++){

            if(arr[i] + maxSumArray[i-2] > maxSumArray[i-1]){
                maxSumArray[i] = arr[i] + maxSumArray[i-2];
            }
            else{
                maxSumArray[i] = maxSumArray[i-1];
            }

        }

        return maxSumArray[maxSumArray.length - 1];
    }

}
