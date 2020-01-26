package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagMatrix {

    public static void main(String[] args) {

        List<List<Integer>> l = new ArrayList<>();

        List<Integer> r1 = new ArrayList<Integer>(Arrays.asList(1,3,4,10,11));
        List<Integer> r2 = new ArrayList<Integer>(Arrays.asList(2,5,9,12,19));
        List<Integer> r3 = new ArrayList<Integer>(Arrays.asList(6,8,13,18,20));
        List<Integer> r4 = new ArrayList<Integer>(Arrays.asList(7,14,17,21,24));
        List<Integer> r5 = new ArrayList<Integer>(Arrays.asList(15,16,22,23,25));

        l.add(r1);l.add(r2);l.add(r3);l.add(r4);l.add(r5);

        System.out.println(zigzagTraverse(l));
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        int height = array.size()-1;
        int width = array.get(0).size()-1;
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        List<Integer> results = new ArrayList<>();

        while(!isOutOfBound(row,col,height,width)){
            results.add(array.get(row).get(col));

            if(goingDown) {

                if(row == height){
                    goingDown = false;
                    col++;
                }
                else if (col == 0) {
                    goingDown = false;
                    row++;

                }

                else{
                    row++;
                    col--;
                }
            }
            else{

                if(col == width){
                    goingDown = true;
                    row++;
                }
                else if(row == 0){
                    goingDown = true;
                    col++;
                }

                else{
                    row--;
                    col++;
                }
            }

        }

        return results;
    }

    public static boolean isOutOfBound(int row, int col, int height, int width){
        return row > height || col > width || row < 0 || col < 0;
    }

}
