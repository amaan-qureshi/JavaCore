package com.algoexpert;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {8,5,2,9,5,6,3};
        int[] res = mergeSort(arr);
        for(int i : res){
            System.out.print( i+" ");
        }
    }

    public static int[] mergeSort(int[] array) {
        // Write your code here.

        if(array.length <= 1){
            return array;
        }

        int[] halfOne = Arrays.copyOfRange(array,0,array.length/2);
        int[] halfTwo = Arrays.copyOfRange(array,array.length/2,array.length);
        return doMerge(mergeSort(halfOne),mergeSort(halfTwo));
    }

    private static int[] doMerge(int[] halfOne, int[] halfTwo) {

        int[] sortedArray = new int[halfOne.length+halfTwo.length];
        int p1 = 0;
        int p2 = 0;
        int c = 0;
        while(p1 < halfOne.length && p2 < halfTwo.length){
            if(halfOne[p1] <= halfTwo[p2]){
                sortedArray[c++] = halfOne[p1++];
            }
            else{
                sortedArray[c++] = halfTwo[p2++];
            }
        }

        while(p1 < halfOne.length) {
            sortedArray[c++] = halfOne[p1++];
        }
        while(p2 < halfTwo.length) {
            sortedArray[c++] = halfTwo[p2++];
        }

        return sortedArray;
    }

}
