package com.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RiverSize {

    public static void main(String[] args) {

        int[][] input = {{1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                         {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                         {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                         {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                         {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}};

        List<Integer> result = riverSizes(input);
        System.out.print(result);

    }

    public static List<Integer> riverSizes(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 1)
                    findRiverSizes(i, j, matrix, visited, result);

            }

        }
        return result;
    }

    public static void findRiverSizes(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> result) {
        if (visited[i][j]) {
            return;
        }
        LinkedList<Integer[]> stack = new LinkedList<>();
        int riverSize = 0;
        Integer[] node = {i, j};
        stack.push(node);

        while (!stack.isEmpty()) {

            Integer[] tn = stack.pop();
            if (visited[tn[0]][tn[1]]) {
                continue;
            }
            visited[tn[0]][tn[1]] = true;
            riverSize++;
            List<Integer[]> children = getEligibleChildren(tn[0], tn[1], matrix);

            for (Integer[] child : children) {
                if (!visited[child[0]][child[1]]) {
                    stack.push(child);
                }

            }

        }
        result.add(riverSize);
    }

    public static List<Integer[]> getEligibleChildren(int i, int j, int[][] matrix) {

        List<Integer[]> results = new ArrayList<>();

      /*  if ( i > 0 && matrix[i-1][j] == 1) {
            Integer[] node = {i-1, j};
            results.add(node);
        }
        if ( i < matrix.length - 1 && matrix[i + 1][j] == 1) {
            Integer[] node = {i + 1, j};
            results.add(node);
        }
        if ( j > 0 && matrix[i][j - 1] == 1) {
            Integer[] node = {i, j - 1};
            results.add(node);
        }
        if ( j < matrix[0].length - 1 && matrix[i][j+1] == 1) {
            Integer[] node = {i, j+1};
            results.add(node);
        }*/

        if ((j - 1) >= 0 && matrix[i][j - 1] == 1) {
            Integer[] node = {i, j - 1};
            results.add(node);
        }
        if ((i + 1) < matrix.length && matrix[i + 1][j] == 1) {
            Integer[] node = {i + 1, j};
            results.add(node);
        }
        if ((j + 1) < matrix[i].length && matrix[i][j + 1] == 1) {
            Integer[] node = {i, j + 1};
            results.add(node);
        }
        if ((i - 1) >= 0 && matrix[i - 1][j] == 1) {
            Integer[] node = {i - 1, j};
            results.add(node);
        }
        return results;
    }
}
