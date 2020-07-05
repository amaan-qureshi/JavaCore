package com.leetcode;

public class Stoi {

    public static void main(String[] args) {

        System.out.println(myAtoi("-   234"));
    }

    public static int myAtoi(String str) {

        int mul = 1;
        boolean checkMul = true;
        boolean numStarted = false;
        String num = "";

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ' && !checkMul) break;

            if (str.charAt(i) == ' ' && !numStarted) continue;

            if (str.charAt(i) == '-' && !numStarted && checkMul) {
                mul = -1;
                checkMul = false;
                continue;
            }

            if (str.charAt(i) == '+' && !numStarted && checkMul) {
                checkMul = false;
                continue;
            }

            if (isNumeric(Character.toString(str.charAt(i)))) {
                numStarted = true;
                num = num + Character.toString(str.charAt(i));
                continue;
            }

            break;

        }

        if (num.equals("")) return 0;
        num = removeLeadingZeroes(num);
        String intStr = Integer.MAX_VALUE + "";
        if (num.length() > intStr.length()) {

            if (mul == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }

        }
        if (num.equals("")) return 0;
        Long val = Long.parseLong(num);
        if (val > Integer.MAX_VALUE) {
            if (mul == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else
            return Integer.parseInt(num) * mul;

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String removeLeadingZeroes(String value) {
        while (value.indexOf("0") == 0)
            value = value.substring(1);
        return value;
    }
}

