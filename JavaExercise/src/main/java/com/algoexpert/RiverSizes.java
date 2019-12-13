package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {

    public static void main(String[] args) {

        int [][] matrix = {
                {1,1,0,0,0,0,1,1},
                {1,0,1,1,1,1,0,1},
                {0,1,1,0,0,0,1,1}};


        System.out.print(riverSizes(matrix));

    }


    public static ArrayList<Integer> riverSizes(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] flags = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                int count = 0;
                count = traverse(count,i,j,matrix,flags);
                result.add(count);
            }

        }


        return result;
    }

    public static int traverse(int count, int i, int j, int[][] matrix, boolean[][] flags) {

        if(matrix[i][j] == 1 && !flags[i][j]){

            count++;
            flags[i][j] = true;
            return traverse(count, i, j, matrix, flags);
        }
        if (j+1 < matrix[i].length && matrix[i][j + 1] == 1 && !flags[i][j + 1]) {

            count++;
            i = i;
            j = j + 1;
            flags[i][j] = true;
            return traverse(count, i, j, matrix, flags);

        }
        if (i+1 < matrix.length && matrix[i + 1][j] == 1 && !flags[i + 1][j]) {
            count++;
            i = i + 1;
            j = j;
            flags[i][j] = true;
            return traverse(count, i, j, matrix, flags);
        }
        if (j-1 > 0 && matrix[i][j - 1] == 1 && !flags[i][j - 1]) {
            count++;
            i = i;
            j = j - 1;
            flags[i][j] = true;
            return traverse(count, i, j, matrix, flags);
        }
        if (i-1 > 0 && matrix[i - 1][j] == 1 && !flags[i - 1][j]) {
            count++;
            i = i - 1;
            j = j;
            flags[i][j] = true;
            return traverse(count, i, j, matrix, flags);
        }

        return count;
    }


}
