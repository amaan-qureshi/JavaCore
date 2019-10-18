package com.hackerrank.array;

public class SolutionLeftRotation {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        System.out.print(rotLeftInPlace(arr,4));

    }

/*    1 2 3 4 5 6 7
    4

    5 2 3 4 1 6 7

    5 6 3 4 1 2 7

    5 6 7 4 1 2 3
    */

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int[] result = new int[a.length];

        int i = d;
        int counter = 0;
        while(i < a.length){
            result[counter] = a[i];
            i++;
            counter ++;
        }

        i = 0;
        while(i<d){
            result[counter] = a[i];
            i++;
            counter ++;
        }

        return result;

    }

    static int[] rotLeftInPlace(int[] a, int d) {

        int size = a.length;
        int start = d;
        int counter = 0;

        while(start<size) {
            int temp = a[counter];
            a[counter] = a[start];
            a[start] = temp;
            counter++;
            start++;
        }


        return  a;



    }
}
