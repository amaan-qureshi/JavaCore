package com.algoexpert;

import java.util.Arrays;

public class MinNoOfJumps {

    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        System.out.println(minJumpsOn2(arr));
    }

    public static int minJumpsOn2(int[] arr) {

        int[] minJumps = new int[arr.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;

        for (int i = 1; i < arr.length; i++) {

            int j = 0;
            while (j < i) {

                if (i <= arr[j] + j) {
                    minJumps[i] = Math.min(minJumps[i], 1 + minJumps[j]);
                }
                j++;
            }
        }


        return minJumps[arr.length - 1];
    }


    public static int minJumpsOn(int[] array) {

        if (array.length == 1) {
            return 0;
        }

        int maxReach = array[0];
        int steps = array[0];
        int jumps = 0;

        for (int i = 1; i < array.length; i++) {

            maxReach = Math.max(maxReach, array[i] + 1);
            steps--;

            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }

        }

        return jumps + 1;
    }
}
