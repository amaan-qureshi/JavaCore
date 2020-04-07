package com;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HackerRank1 {

    public static void main(String[] args) {
       System.out.println(canConstructLetter("abcdefghijklmnopqrstuvwxyz", "a b c d e f g h i j k l m n o p q r s t u v w x y z")) ;
    }

    public static boolean canConstructLetter(String text, String note) {
        // Write your code here

        System.out.println("text: " + text);
        System.out.println("note: " + note);
        text = text.toLowerCase().replaceAll(" ","").trim();
        note = note.toLowerCase().replaceAll(" ","").trim();

        Map<String, Long> letterMap =
                text.chars().mapToObj(c -> (char)c + "").collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Character s : note.toCharArray()) {

            String str = s.toString();
            if (letterMap.containsKey(str) && letterMap.get(str) > 0) {
                letterMap.put(str, letterMap.get(str) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}


