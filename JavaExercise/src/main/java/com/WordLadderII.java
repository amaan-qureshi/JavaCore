package com;

import java.util.*;

public class WordLadderII {

    public static void main(String[] args) {

        System.out.println(new WordLadderII().findLadders("hit", "cog",
                Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return new ArrayList<>();

        Map<String, List<String>> preProcessedWords = new HashMap<>();
        //addWordToPreProcessMap(beginWord, preProcessedWords);
        wordList.forEach(word -> addWordToPreProcessMap(word, preProcessedWords));


        Queue<PairII> Q = new LinkedList<>();
        Q.offer(new PairII(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!Q.isEmpty()) {

            PairII wordPair = Q.poll();

            for (int i = 0; i < wordPair.word.length(); i++) {

                String wildWord = wordPair.word.substring(0, i) + "*" + wordPair.word.substring(i + 1, wordPair.word.length());

                for (String word : preProcessedWords.getOrDefault(wildWord, new ArrayList<>())) {

                    if (word.equals(endWord)) {
                        System.out.println(wordPair.level + 1);
                        return new ArrayList<>();
                    }

                    if (!visited.contains(word)) {

                        visited.add(word);
                        Q.add(new PairII(word, wordPair.level + 1));

                    }

                }

            }


        }
        System.out.println(preProcessedWords);
        return new ArrayList<>();
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

class PairII {
    String word;
    int level;

    PairII(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
