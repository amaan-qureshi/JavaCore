package com.leetcode;

import java.util.*;

public class WordSearch2 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eats","rain"};
        System.out.println(new WordSearch2().findWords(board,words));
    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            //trie.add(word);
        }

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                exploreBoard(i, j, board, trie.root, visited, result);
            }
        }

        return new ArrayList<>(result);

    }

    private void exploreBoard(int i, int j, char[][] board, TrieNode current, boolean[][] visited, Set<String> result) {

        if (visited[i][j]) {
            return;
        }

        if (!current.children.containsKey(board[i][j])) {
            return;
        }

        visited[i][j] = true;

        current = current.children.get(board[i][j]);

        if (current.children.containsKey('*')) {
            //result.add(current.word);
        }

        List<Integer[]> neighbours = getNeigbours(i, j, board);
        for (Integer[] neighbour : neighbours) {
            exploreBoard(neighbour[0], neighbour[1], board, current, visited, result);
        }
        visited[i][j] = false;

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

class Trie2 {

    TrieNode root;
    Character endSymbol;

    Trie2() {
        root = new TrieNode();
        endSymbol = '*';
    }

    public void add(String word) {
        TrieNode current = root;

        for (Character c : word.toCharArray()) {

            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }

            current = current.children.get(c);
        }

        current.children.put('*', null);
       // current.word = word;
    }

}

class TrieNode2 {

    Map<Character, TrieNode> children = new HashMap<>();
    String word = "";

}