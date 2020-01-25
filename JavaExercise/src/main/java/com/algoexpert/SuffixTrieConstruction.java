package com.algoexpert;

import java.util.*;

public class SuffixTrieConstruction {

    public static void main(String[] args) {

        SuffixTrie suffixTrie = new SuffixTrie("apple");
        suffixTrie.populateSuffixTrieFrom("boy");
        suffixTrie.populateSuffixTrieFrom("boyhood");
        System.out.println(suffixTrie.contains("hood"));

      /* String str= "babc";
       System.out.println(str.substring(0));
        System.out.println(str.substring(1));
        System.out.println(str.substring(2));
        System.out.println(str.substring(3));*/
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.

            for (int i = 0; i < str.length(); i++) {

                String modifiedWord = str.substring(i);

                char[] chars = modifiedWord.toCharArray();
                TrieNode current = root;

                for (Character c : chars) {

                    if (!current.children.containsKey(c)) {
                        current.children.put(c, new TrieNode());
                    }

                    current = current.children.get(c);

                }
                current = current.children.put(endSymbol, null);
            }

        }

        public boolean contains(String str) {
            // Write your code here.
            char[] chars = str.toCharArray();
            TrieNode current = root;

            for (Character c : chars) {

                if (!current.children.containsKey(c)) {
                    return false;
                }

                current = current.children.get(c);

            }

            return current.children.containsKey(endSymbol);


        }
    }

}
