package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

class Monotonic {

    public static void main(String[] args) {

        int arr[] = {-1,-5,-10,-1100,-1100,-1101,-1102,-9001};
        System.out.println(isMonotonic(arr));
    }

    public static boolean isMonotonic(int[] array) {

        if(array.length == 1 ) return true;

        boolean isIncreasing = true;
        for(int i = 0 ; i < array.length - 1 ; i++){

            if(array[i] == array[i+1]) continue;

            if(array[i] < array[i+1]) {isIncreasing = true ; break;}

            if(array[i] > array[i+1]) {isIncreasing = false ; break;}

        }

        for(int i = 0 ; i < array.length - 1 ; i++){

            if(isIncreasing) {
                if (!(array[i + 1] >= array[i])) {
                    return false;
                }
            }
            else{
                if (!(array[i] >= array[i+1])) {
                    return false;
                }
            }
        }

        return true;
    }

}
