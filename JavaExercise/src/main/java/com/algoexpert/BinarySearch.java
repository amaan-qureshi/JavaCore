package com.algoexpert;

public class BinarySearch {

    public static void main(String[] args) {
        int result = binarySearch(new int[]{1, 5, 23, 111}, 35);
        System.out.println(result);
    }

    public static int binarySearch(int[] array, int target) {
        // Write your code here.

        return binarySearch(array, target, 0, array.length - 1);


    }

    public static int binarySearch(int[] array, int target, int start, int end) {


        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }

    }
}
