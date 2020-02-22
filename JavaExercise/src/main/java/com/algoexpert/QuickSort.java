package com.algoexpert;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{8,5,2,9,5,6,3};
        int[] result = quickSort(arr);
        Arrays.stream(result).forEach(a-> System.out.println(a+" "));
    }


    public static int[] quickSort(int[] array) {
        // Write your code here.
        quickSort(array,0,array.length-1);
        return array;
    }

    public static void quickSort(int[] array,int startIdx,int endIdx) {
        // Write your code here.

        if(startIdx>=endIdx){
            return;
        }

        int pivot = startIdx;
        int left = startIdx+1;
        int right = endIdx;

        while(right>=left){
            if(array[left] > array[pivot] && array[right]<array[pivot]) {
                swap(array, left, right);
            }
            if(array[left]<=array[pivot]){
                left++;
            }
            if(array[right]>=array[pivot]){
                right--;
            }
        }
        swap(array, pivot, right);



        quickSort(array,startIdx,right-1);
        quickSort(array,right+1,endIdx);
    }

    private static void swap(int[] array, int left, int right) {
        array[left] = array[left] + array[right];
        array[right] = array[left] - array[right];
        array[left] = array[left] - array[right];
    }

}
