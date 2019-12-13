package com.dsProblems;

public class CheckSecondMax {

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 0};
        System.out.print(findSecondMaximum(arr));
    }

    public static int findSecondMaximum(int[] arr) {

        int largest = 0;
        int second = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {
                // if(i!=0){
                second = largest;
                //  }
                largest = arr[i];

            } else if (largest > arr[i] && arr[i] > second) {
                second = arr[i];
            }
        }
        return second;
    }

}
