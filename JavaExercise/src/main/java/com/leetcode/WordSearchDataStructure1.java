package com.leetcode;

import java.util.*;

public class WordSearchDataStructure1 {
}

class Trie {

    TrieNode root;
    Character endSymbol;

    public Trie() {
        root = new TrieNode();
        endSymbol = '*';
    }

    public void insert(String word) {

        TrieNode current = this.root;
        for (Character c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.children.put(endSymbol, null);

    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
}