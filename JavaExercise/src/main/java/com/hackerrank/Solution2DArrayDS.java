package com.hackerrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import static java.util.Arrays.*;

public class Solution2DArrayDS {

    private static List<List<Integer>> hourGlass = new ArrayList<>();

    static {
        hourGlass.add(asList(0, 0));
        hourGlass.add(asList(0, 1));
        hourGlass.add(asList(0, 2));
        hourGlass.add(asList(1, 1));
        hourGlass.add(asList(2, 0));
        hourGlass.add(asList(2, 1));
        hourGlass.add(asList(2, 2));
    }

    public static void main(String[] args) {

        int [][] arr = new int[6][6];
        arr[0][0] = 1 ; arr[0][1] = 1 ; arr[0][2] = 1 ; arr[0][3] = 0 ; arr[0][4] = 0 ; arr[0][5] = 0;
        arr[1][0] = 0 ; arr[1][1] = 1 ; arr[1][2] = 0 ; arr[1][3] = 0 ; arr[1][4] = 0 ; arr[1][5] = 0;
        arr[2][0] = 1 ; arr[2][1] = 1 ; arr[2][2] = 1 ; arr[2][3] = 0 ; arr[2][4] = 0 ; arr[2][5] = 0;
        arr[3][0] = 0 ; arr[3][1] = 0 ; arr[3][2] = 2 ; arr[3][3] = 4 ; arr[3][4] = 4 ; arr[3][5] = 0;
        arr[4][0] = 0 ; arr[4][1] = 0 ; arr[4][2] = 0 ; arr[4][3] = 2 ; arr[4][4] = 0 ; arr[4][5] = 0;
        arr[5][0] = 0 ; arr[5][1] = 0 ; arr[5][2] = 1 ; arr[5][3] = 2 ; arr[5][4] = 4 ; arr[5][5] = 0;


        System.out.print(hourglassSum(arr));

    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

       List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                Integer sum = calculateHourGlassSum(arr,i,j);
                if(sum!=null) {
                    sums.add(sum);
                }

            }

        }
        return sums.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
    }

    private static Integer calculateHourGlassSum(int[][] arr, int i, int j) {

        int m = arr.length;
        int n = arr[0].length;
        int sum = 0;
        boolean calcCompleted = true;

        for(List<Integer> intList : hourGlass){

            int x = i + intList.get(0);
            int y = j + intList.get(1);

            if(x < m && y < n){
                sum = sum + arr[x][y];
            }
            else{
                calcCompleted = false;
                break;
            }

        }

        if(calcCompleted){
            return sum;
        }
        else{
            return null;
        }
    }

}
