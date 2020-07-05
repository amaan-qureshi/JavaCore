package com.leetcode;

public class FindKLargest {

    public static void main(String[] args) {

        FindKLargest f = new FindKLargest();
    }

    public static int findKthLargest(int[] array, int k) {
        // Write your code here.
        int i = array.length-k;
        return quickselect(array, 0, array.length - 1, k - 1);
    }


    public static int quickselect(int[] array, int startIdx, int endIdx, int position) {

        while (true) {

            int pivot = startIdx;
            int left = startIdx + 1;
            int right = endIdx;

            while (right >= left) {
                if (array[left] > array[pivot] && array[right] < array[pivot]) {
                    swap(array, left, right);
                }
                if (array[left] <= array[pivot]) {
                    left++;
                }
                if (array[right] >= array[pivot]) {
                    right--;
                }
            }
            swap(array, pivot, right);

            if (right == position) {
                return array[right];
            }
            if (position > right) {
                startIdx = right + 1;
            } else {
                endIdx = right - 1;
            }
        }



    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
