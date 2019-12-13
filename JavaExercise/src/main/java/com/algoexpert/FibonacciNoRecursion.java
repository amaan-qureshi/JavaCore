package com.algoexpert;

public class FibonacciNoRecursion {

    public static void main(String[] args) {
        System.out.print(getFib(4));
    }

    public static int getFib(int n) {


        int[] arr = {0, 1};

        if (n > 3) {

            int counter = 2;
            while (counter < n) {

                int newVal = arr[0] + arr[1];
                arr[0] = arr[1];
                arr[1] = newVal;
                counter++;
            }
        }

        return (n == 1 || n == 0) ? arr[0] : arr[1];
    }

}
