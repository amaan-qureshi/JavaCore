package com.hackerrank.warmup;

public class SolutionRepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long count = 0;

        count =  (s.chars().mapToObj(c -> (char) c).filter( c -> c == 'a').count()) * (n/s.length());

        long remainingNoOfAs = s.substring(0,(int)(n%s.length())).chars()
                .mapToObj(c -> (char) c).filter( c -> c == 'a').count();

        count = count + remainingNoOfAs;

        return count;
    }

    public static void main(String[] args) {

        System.out.print(repeatedString("a",1000000000000L));
    }

}
