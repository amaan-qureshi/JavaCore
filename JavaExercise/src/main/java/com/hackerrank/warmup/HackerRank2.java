package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

public class HackerRank2 {

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>());
        matrix.get(0).add(1);
        matrix.get(0).add(2);
        matrix.get(0).add(3);
        matrix.get(0).add(4);

        matrix.add(new ArrayList<>());
        matrix.get(1).add(5);
        matrix.get(1).add(6);
        matrix.get(1).add(7);
        matrix.get(1).add(8);

        matrix.add(new ArrayList<>());


        matrix.get(2).add(9);
        matrix.get(2).add(10);
        matrix.get(2).add(11);
        matrix.get(2).add(12);

        matrix.add(new ArrayList<>());
        matrix.get(3).add(13);
        matrix.get(3).add(14);
        matrix.get(3).add(15);
        matrix.get(3).add(16);

        printAntiDiag(matrix);


    }

    public static void print(List<List<Integer>> matrix){
        for(List<Integer> ints : matrix){
            System.out.println(ints);
        }
    }

    public static void printAntiDiag(List<List<Integer>> matrix) {


        for (int j = matrix.get(0).size() - 1; j >= 0; j--) {

            int p = j;
            int q = 0;

            while( p <  matrix.size() && q < matrix.get(0).size()) {

                System.out.println(matrix.get(q).get(p));
                p = p+1;
                q = q+1;
            }
        }

        for (int i = 1; i < matrix.size(); i++) {

            int p = i;
            int q = 0;

            while( p <  matrix.size() && q < matrix.get(0).size()-1) {
                System.out.println(matrix.get(p).get(q));
                p = p + 1;
                q = q + 1;
            }
        }

    }





}
