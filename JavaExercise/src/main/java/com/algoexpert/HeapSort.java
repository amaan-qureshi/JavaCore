package com.algoexpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeapSort {

    public static void main(String[] args) {

        int[] result = heapSort(new int[]{1,2,3});
        List<Integer> l = Arrays.stream(result).boxed().collect(Collectors.toList());
        System.out.println(l);
    }

    public static int[] heapSort(int[] array) {
        // Write your code here.

        buildMaxHeap(array);

        for(int end = array.length-1 ; end > 0 ; end--){

            swap(0,end,array);
            siftDown(0,end,array);


        }

        return array;
    }

    private static void buildMaxHeap(int[] array) {

        int parent =(array.length-1)/2;

        for(int n = parent ; n >=0 ; n--){
            siftDown(n,array.length,array);
        }

    }

    private static void siftDown(int n, int length, int[] array) {

        int largest = n;
        while(largest < length/2){

            int childOne = 2*n + 1;
            int childTwo = 2*n + 2;

            if(childOne < length && array[childOne] > array[n]){
                largest = childOne;
            }
            if (childTwo < length && array[childTwo] > array[largest]){
                largest = childTwo;
            }

            if(largest!=n){
                swap(n,largest,array);
                n= largest;
            }
            else{
                break;
            }
        }

    }

    private static void swap(int n, int largest, int[] array) {

        int temp = array[n];
        array[n] = array[largest];
        array[largest] = temp;

    }

}
