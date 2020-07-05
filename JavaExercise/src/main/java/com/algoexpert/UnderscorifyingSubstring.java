package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnderscorifyingSubstring {

    public static void main(String[] args) {
        underscorifySubstring("testthis is a testtest to see if testestest it works", "amaan");
    }

    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        str.chars().filter( c -> c=='x').count();
        str.chars().filter( c -> c=='y').count();
        str.indexOf('y');
        List<Integer[]> subStringLocation = new ArrayList<>();

        int startIndex = 0;

        while (startIndex < str.length()) {

            int next = str.indexOf(substring, startIndex);

            if (next != -1) {
                subStringLocation.add(new Integer[]{next, next + substring.length()});
                startIndex = next + 1;
            } else {
                break;
            }

        }

        if(subStringLocation.isEmpty()){
            return str;
        }

        for (Integer[] locs : subStringLocation) {
            System.out.println(locs[0] + " " + locs[1]);
        }

        List<Integer[]> subStringCollapsed = new ArrayList<>();
        subStringCollapsed.add(subStringLocation.get(0));

        Integer[] previous = subStringLocation.get(0);

        for (int i = 1; i < subStringLocation.size(); i++) {

            Integer[] current = subStringLocation.get(i);

            if (previous[1] == current[0] || (previous[0] < current[0] && current[0] < previous[1])) {
                previous[1] = current[1];
            } else {
                subStringCollapsed.add(current);
                previous = current;
            }

        }

        System.out.println("--------------------");
        StringBuilder sb = new StringBuilder(str);
        int x = 0;
        int y = 1;
        for (Integer[] locs : subStringCollapsed) {
            System.out.println(locs[0] + " " + locs[1]);
            System.out.println(str.substring(locs[0], locs[1]));
            sb.insert(locs[0]+x,"_");
            sb.insert(locs[1]+y,"_");
            x+=2;
            y+=2;
        }

        return sb.toString();
    }

}
