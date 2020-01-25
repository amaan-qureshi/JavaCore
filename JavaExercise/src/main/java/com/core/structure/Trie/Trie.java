package com.core.structure.Trie;

public class Trie {

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public int getIndex(char t) {
        return t - 'a';
    }

    public boolean insert(String key) {

        if(key==null){
            return false;
        }

        key = key.toLowerCase();
        TrieNode current = root;

        for(int level = 0 ; level < key.length() ; level ++){

            if(current.children[getIndex(key.charAt(level))] == null){
                current.children[getIndex(key.charAt(level))] = new TrieNode();
            }

            current = current.children[getIndex(key.charAt(level))];

        }

        current.markAsLeaf();

        return false;
    }

    public boolean search(String key) {

        key = key.toLowerCase();
        TrieNode current= root;

        for(int level = 0 ; level < key.length() ; level++){

            if(current.children[getIndex(key.charAt(level))] == null){
                return false;
            }

            current = current.children[getIndex(key.charAt(level))];
        }

        if(current.isEndWord)return true;

        return false;
    }

    public boolean delete(String key) {
        return false;
    }
}
