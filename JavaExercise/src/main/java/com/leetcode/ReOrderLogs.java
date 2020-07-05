package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderLogs {

    public static void main(String[] args) {
        String[] arr = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String res[] = new ReOrderLogs().reorderLogFiles(arr);
        for(String str: res){
            System.out.println(str);
        }
    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {



                if(Character.isLetter(o1.charAt(o1.indexOf(" ")+1)) && Character.isDigit(o2.charAt(o2.indexOf(" ")+1))) return -1;
                if(Character.isDigit(o1.charAt(o1.indexOf(" ")+1)) && Character.isLetter(o2.charAt(o2.indexOf(" ")+1))) return 1;

                if(Character.isLetter(o1.charAt(o1.indexOf(" ")+1))){

                    if(o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" "))) == 0){
                        return o1.compareTo(o2);
                    }
                    else{
                        return o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")));
                    }

                }

                return 0;
            }
        });
        return logs;
    }

}
