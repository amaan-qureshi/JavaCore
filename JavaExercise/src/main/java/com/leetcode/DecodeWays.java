package com.leetcode;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226"));
    }
    public int numDecodings(String s) {

        if(s.length() == 0) return 0;

        int[] coms = new int[s.length()+1];
        coms[0] = 1;
        coms[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2 ; i < coms.length ; i++){

            if(s.charAt(i-1) != '0') {
                coms[i] += coms[i-1];
            }

            int twoDigit = Integer.valueOf(s.substring(i-2, i));

            if(twoDigit >= 10 && twoDigit <= 26) {
                coms[i] += coms[i-2];
            }

        }

        return coms[coms.length-1];

    }

}
