package com.algoexpert;

public class BinarySearchForRange {

    public static void main(String[] args) {
//0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73 [45]
        int arr[] = new int[]{5, 7, 7, 8, 8, 10};

        int[] result = searchForRange(arr, 8);
        System.out.println(result[0] + " " + result[1]);
    }


    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.

        int leftRange = -1;
        int rightRange = -1;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            if (array[middle] < target) {
                left = middle + 1;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {

                if (middle == 0 || array[middle - 1] != target) {
                    leftRange = middle;
                    break;
                } else {
                    right = middle - 1;
                }

            }

        }

        left = 0;
        right = array.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            if (array[middle] < target) {
                left = middle + 1;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {

                if (middle == array.length - 1 || array[middle + 1] != target) {
                    rightRange = middle;
                    break;
                } else {
                    left = middle + 1;
                }

            }

        }

        return new int[]{leftRange, rightRange};
    }
}
