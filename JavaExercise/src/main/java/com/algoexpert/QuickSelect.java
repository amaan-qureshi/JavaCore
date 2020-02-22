package com.algoexpert;

public class QuickSelect {

    public static void main(String[] args) {
        System.out.println(quickselect(new int[]{8,5,2,9,7,6,3}, 3));
    }

    public static int quickselect(int[] array, int k) {
        // Write your code here.
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
                if (array[left] <= array[pivot]){
                    left++;
                }
                if(array[right]>= array[pivot]){
                    right--;
                }
            }
            swap(array,pivot,right);

            if(right == position){
                return array[right];
            }
            if(position > right){
                startIdx = right+1;
            }
            else{
                endIdx = right-1;
            }
        }

    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
