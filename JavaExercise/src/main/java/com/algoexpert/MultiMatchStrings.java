package com.algoexpert;

import java.util.*;

public class MultiMatchStrings {

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        List<Boolean> booleans = new ArrayList<>();

        Trie trie = new Trie();
        for (String str : smallStrings) {
            trie.insert(str);
        }

        Map<String, Boolean> matching = new HashMap<>();

        for (int i = 0; i < bigString.length(); i++) {

            findSmallString(bigString, i, trie, matching);
        }

        for (String str : smallStrings) {
            booleans.add(matching.containsKey(str));
        }

        return booleans;
    }

    private static void findSmallString(String bigString, int j, Trie trie, Map<String, Boolean> matching) {

        int startIndex = j;
        TrieNode node = trie.root;

        for (int i = startIndex; i < bigString.length(); i++) {


            if (node.children.containsKey(bigString.charAt(i))) {
                node = node.children.get(bigString.charAt(i));
            } else {
                break;
            }

            if (node.children.containsKey(Trie.endSymbol)) {

                matching.put(node.word, true);
            }


        }


    }

    static class Trie {

        TrieNode root = new TrieNode();
        final static Character endSymbol = '*';

        void insert(String str) {

            TrieNode current = this.root;

            for (int i = 0; i < str.length(); i++) {

                if (!current.children.containsKey(str.charAt(i))) {
                    current.children.put(str.charAt(i), new TrieNode());
                }

                current = current.children.get(str.charAt(i));
            }

            current.word = str;
            current.children.put(endSymbol, null);
        }

    }

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        String word;

    }
}
