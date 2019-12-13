package com.dsProblems;

public class CheckRotateArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        rotateArray(arr);
        System.out.print(arr.toString());

    }

    public static void rotateArray(int[] arr) {

        int length = arr.length;
        int last = arr[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }

        arr[0] = last;


    }

}
