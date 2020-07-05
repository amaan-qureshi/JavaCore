package com.algoexpert;
import java.util.*;

public class SpiralPrint {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6}
        } ;
        System.out.println(spiralTraverse(arr));
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.

        int startR = 0;
        int endR = array.length-1;
        int startC = 0;
        int endC = array[0].length-1;
        List<Integer> result = new ArrayList<>();

        while(startR<=endR && startC <=endC){

            for(int i = startC ; i<=endC ; i++){
                result.add(array[startR][i]);
            }

            for(int i = startR+1 ; i<=endR ; i++){
                result.add(array[i][endC]);
            }

            for(int i = endC-1 ; i>=startC ; i--){
                result.add(array[endR][i]);
            }

            for(int i = endR-1 ; i>startR ; i--){
                result.add(array[i][startC]);
            }

            startR++;
            endR--;
            startC++;
            endC--;

        }

        return result;
    }

}
