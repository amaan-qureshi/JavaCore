package com;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        System.out.println(new WordLadder().ladderLength("hit", "cog",
                Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "zog","cog"})));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Map<String, List<String>> preProcessedWords = new HashMap<>();
        //addWordToPreProcessMap(beginWord, preProcessedWords);
        wordList.forEach(word -> addWordToPreProcessMap(word, preProcessedWords));

        Map<String, Set<String>> result = new HashMap<>();

        Queue<Pair> Q = new LinkedList<>();
        Q.offer(new Pair(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        outer:
        while (!Q.isEmpty()) {

            Pair wordPair = Q.poll();

            for (int i = 0; i < wordPair.word.length(); i++) {

                String wildWord = wordPair.word.substring(0, i) + "*" + wordPair.word.substring(i + 1, wordPair.word.length());

                for (String word : preProcessedWords.getOrDefault(wildWord, new ArrayList<>())) {

                    if (word.equals(endWord)) {
                        if (result.containsKey(word)) {
                            result.get(word).add(wordPair.word);
                        } else {
                            Set<String> l = new HashSet<>();
                            l.add(wordPair.word);
                            result.put(word, l);
                        }
                        //break outer;
                    }

                    if (!visited.contains(word)) {
                        if (result.containsKey(word)) {
                            result.get(word).add(wordPair.word);
                        } else {
                            Set<String> l = new HashSet<>();
                            l.add(wordPair.word);
                            result.put(word, l);
                        }
                        visited.add(word);
                        Q.add(new Pair(word, wordPair.level + 1));

                    }

                }

            }


        }


        List<List<String>> outPuts = new ArrayList<>();




        System.out.println(preProcessedWords);
        return -1;
    }

    private void addWordToPreProcessMap(String beginWord, Map<String, List<String>> preProcessedWords) {
        for (int i = 0; i < beginWord.length(); i++) {
            String wildWord = beginWord.substring(0, i) + "*" + beginWord.substring(i + 1, beginWord.length());
            if (preProcessedWords.containsKey(wildWord)) {
                preProcessedWords.get(wildWord).add(beginWord);
            } else {
                List<String> words = new ArrayList<>();
                words.add(beginWord);
                preProcessedWords.put(wildWord, words);
            }
        }
    }


}

class Pair {
    String word;
    int level;

    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
