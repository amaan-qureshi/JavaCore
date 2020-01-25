package com.algoexpert;

import java.lang.reflect.Array;
import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        System.out.print(groupAnagrams(Arrays.asList("cinema","a","flop","iceman","meacyne","lofp","olfp")));
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String word : words) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(word);
                map.put(sortedWord, list);
            }

        }

        for (Map.Entry<String, List<String>> ent : map.entrySet()) {

            if (ent.getValue().size() > 1) {
                result.add(ent.getValue());
            }


        }


        return result;
    }
}
