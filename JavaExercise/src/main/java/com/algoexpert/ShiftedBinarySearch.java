package com.algoexpert;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        System.out.println(shiftedBinarySearch(new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 45}, 33));
    }


    public static int shiftedBinarySearch(int[] array, int target) {


        int left = 0;
        int right = array.length - 1;


        while (left < right) {

            int middle = (left + right) / 2;

            if (target == array[middle])
                return middle;

            else if (array[left] <= array[middle]){

                if(array[middle] > target && array[left] <= target){
                    right = middle-1;
                }
                else{
                    left = middle+1;
                }

            } else {
                if(array[middle] < target && array[right] >= target){
                    left= middle+1;
                }
                else{
                    right = middle-1;
                }


            }


        }


        // Write your code here.
        return -1;
    }

}
