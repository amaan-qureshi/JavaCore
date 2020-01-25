package com.core.structure.Trie;

public class TrieNode {

    public TrieNode[] children;
    public boolean isEndWord;

    public TrieNode(){
        this.isEndWord = false;
        children = new TrieNode[26];
    }

    public void markAsLeaf(){
        this.isEndWord = true;
    }

    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }

}
