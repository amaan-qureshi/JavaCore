package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch1 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String s = "226";

        System.out.println( s.substring(0,2));

        //String[] words = new String[]{"oath", "pea", "eat", "rain"};
        //System.out.println(new WordSearch1().exist(board, "ABCCEDF"));
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {


                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int wordIdx, boolean[][] visited) {

        if (wordIdx >= word.length())
            return true;

        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(wordIdx)) {
            return false;
        }

        visited[i][j] = true;


        List<Integer[]> neighbours = getNeigbours(i, j, board);
        boolean result = false;

        for (Integer[] neighbour : neighbours) {
            result = dfs(board, neighbour[0], neighbour[1], word, wordIdx+1, visited);
            if(result){
                break;
            }
        }
        visited[i][j] = false;
        return result;
    }

    private List<Integer[]> getNeigbours(int i, int j, char[][] board) {

        List<Integer[]> list = new ArrayList<>();
        if (i > 0) {
            list.add(new Integer[]{i - 1, j});
        }
        if (j < board[0].length - 1) {
            list.add(new Integer[]{i, j + 1});
        }
        if (i < board.length - 1) {
            list.add(new Integer[]{i + 1, j});
        }
        if (j > 0) {
            list.add(new Integer[]{i, j - 1});
        }
        return list;

    }

}

