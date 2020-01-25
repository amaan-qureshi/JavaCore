package com.core.structure.Trie;

import java.util.*;
import java.util.stream.Collectors;

class DictWord {

    public static void main(String[] args) {

        String[] arr = {"the", "hello", "there", "answer", "any", "dragon", "world", "their", "inc"};

        System.out.print(isFormationPossible(arr,"helloworld"));
    }


    public static Object isFormationPossible(String[] dict,String word) {
        // write your code here
        Trie trie = new Trie();
        for(String st : dict){
            trie.insert(st);
        }

        List<String> breakDown = new ArrayList<>();
        List<Character> words = new ArrayList<>();

        for(int i = 0 ; i < word.length() ; i++){

            words.add(word.charAt(i));
            boolean found = trie
                    .search(words.stream()
                            .map(String::valueOf).collect(Collectors.joining()));

            if(found){
                breakDown.add(words.stream()
                        .map(String::valueOf).collect(Collectors.joining()));
                words.clear();
            }
        }

        //return false;
        return breakDown.stream().map(String::valueOf).collect(Collectors.joining()).equals(word);
    }
}