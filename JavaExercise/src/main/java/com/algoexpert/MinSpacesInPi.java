package com.algoexpert;

import java.util.*;

public class MinSpacesInPi {

    int i;



    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    public static void main(String[] args) {

        System.out.println(numbersInPi("3141592653589793238462643383279",new String[]{"314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"}));
    }

    public static int numbersInPi(String pi, String[] numbers) {
        // Write your code here.
        Set<String> numSet = new HashSet<String>();
        for (String s : numbers) {
            numSet.add(s);
        }
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpaces = minSpaces(pi, numSet, cache, 0);
        return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
    }

    public static int minSpaces(String pi, Set<String> numSet, Map<Integer, Integer> cache, int idx) {

        if (pi.length() == idx) {
            return -1;
        }
        //if(cache.containsKey(idx)) return cache.get(idx);

        int minSpaces = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {

            String prefix = pi.substring(idx, i + 1);
            if (numSet.contains(prefix)) {

                int minSpacesInSuffix = minSpaces(pi, numSet, cache, i + 1);
                if (minSpacesInSuffix == Integer.MAX_VALUE) {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix);
                } else {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
                }
            }

        }
        //cache.put(idx,minSpaces);
        return minSpaces;//cache.get(idx);
    }
}