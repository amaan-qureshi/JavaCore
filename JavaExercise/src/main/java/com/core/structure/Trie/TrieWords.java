package com.core.structure.Trie;

import java.util.*;
import java.util.stream.Collectors;

class TrieWords {

    public static void main(String[] args) {
        Trie root = new Trie();
        root.insert("the");
        root.insert("a");
        root.insert("there");
        root.insert("answer");
        root.insert("any");
        root.insert("by");
        root.insert("bye");
        root.insert("their");
        root.insert("abc");

        System.out.print(findWords(root.root));

    }

    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList<String> result, int level, ArrayList<Character> word) {
        // use this as helper function
        if (root.isEndWord) {
            result.add(word.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        for (int i = 0; i < root.children.length; i++) {

            if (root.children[i] != null) {
                word.add(getChar(i));
                ++level;
                getWords(root.children[i], result,level, word);
                --level;
            }
        }


       word.subList(level-1, word.size()).clear();
       //System.out.print(word);


    }

    public static char getChar(int i) {

        return (char) (i + 'a');
    }


    public static ArrayList<String> findWords(TrieNode root) {
        ArrayList<String> result = new ArrayList<String>();
        // write your code here

        for (int i = 0; i < root.children.length; i++) {

            if (root.children[i] != null) {

                ArrayList<Character> word = new ArrayList<Character>();
                word.add(getChar(i));
                getWords(root.children[i], result, 1, word);

            }
        }

        return result;
    }
}

