package com.algoexpert;

import java.util.*;

public class BoggleBoard {


    public static void main(String[] args) {

        char[][] board = {
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'},
        };

        String[] words = {"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};

        System.out.println(boggleBoard(board, words));
    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {


                exploreBoard(i, j, board, t.root, visited, result);

            }

        }

        return new ArrayList<>(result);
    }

    private static void exploreBoard(int i, int j, char[][] board, TrieNode current, boolean[][] visited, Set<String> result) {

        if (visited[i][j]) {
            return;
        }

        if (!current.children.containsKey(board[i][j])) {
            return;
        }

        visited[i][j] = true;

        current = current.children.get(board[i][j]);

        if (current.children.containsKey('*')) {
            result.add(current.word);
        }

        List<Integer[]> neighbours = getNeigbours(i, j, board);

        for (Integer[] neighbour : neighbours) {
            exploreBoard(neighbour[0], neighbour[1], board, current, visited, result);
        }

        visited[i][j] = false;

    }

    private static List<Integer[]> getNeigbours(int i, int j, char[][] board) {

        List<Integer[]> list = new ArrayList<>();

        if (i > 0 && j > 0) {
            list.add(new Integer[]{i - 1, j - 1});
        }
        if (i > 0 && j < board[0].length - 1) {
            list.add(new Integer[]{i - 1, j + 1});
        }
        if (i < board.length - 1 && j < board[0].length - 1) {
            list.add(new Integer[]{i + 1, j + 1});
        }
        if (i < board.length - 1 && j > 0) {
            list.add(new Integer[]{i + 1, j - 1});
        }
        if (i > 0) {
            list.add(new Integer[]{i - 1, j});
        }
        if (i < board.length - 1) {
            list.add(new Integer[]{i + 1, j});
        }
        if (j > 0) {
            list.add(new Integer[]{i, j - 1});
        }
        if (j < board[0].length - 1) {
            list.add(new Integer[]{i, j + 1});
        }


        return list;
    }

    static class Trie {

        TrieNode root;
        char endSymbol = '*';

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String str) {

            TrieNode current = root;

            for (Character c : str.toCharArray()) {

                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }

                current = current.children.get(c);
            }

            current.children.put('*', null);
            current.word = str;

        }
    }

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        String word;

    }


}
