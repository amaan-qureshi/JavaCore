package com.leetcode;

public class NumToWords {

    public static void main(String[] args) {
        NumToWords n = new NumToWords();

        System.out.println(n.numberToWords(1000000));
    }

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String str = "";
        if (billion != 0) {
            str += numberToWords3(billion) + " Billion ";
        }
        if (million != 0) {
            str += numberToWords3(million) + " Million ";
        }
        if (thousand != 0) {
            str += numberToWords3(thousand) + " Thousand ";
        }
        return str += numberToWords3(rest);

    }

    public String numberToWords3(int num) {
        String str = "" + num;

        if (num / 100 != 0) {
            String tmp = firstDigit(Integer.parseInt(String.valueOf(str.charAt(0)))) + " Hundred " + numberToWords3(Integer.parseInt(str.substring(1)));
            return tmp.trim();
        } else if (num / 10 != 0) {
            if (str.charAt(0) == '1' || str.charAt(0) == '0') {
                return firstDigit(num);
            } else {
                String tmp = secondDigit(Integer.parseInt(String.valueOf(str.charAt(0)))) + " " + firstDigit(Integer.parseInt(String.valueOf(str.charAt(1))));
                return tmp.trim();
            }
        } else {
            return firstDigit(num);
        }

    }


    public String firstDigit(int num) {
        switch (num) {
            case (1):
                return "One";
            case (2):
                return "Two";
            case (3):
                return "Three";
            case (4):
                return "Four";
            case (5):
                return "Five";
            case (6):
                return "Six";
            case (7):
                return "Seven";
            case (8):
                return "Eight";
            case (9):
                return "Nine";
            case (10):
                return "Ten";
            case (11):
                return "Eleven";
            case (12):
                return "Twelve";
            case (13):
                return "Thirteen";
            case (14):
                return "Fourteen";
            case (15):
                return "Fifteen";
            case (16):
                return "Sixteen";
            case (17):
                return "Seventeen";
            case (18):
                return "Eighteen";
            case (19):
                return "Nineteen";
        }
        return "";
    }

    public String secondDigit(int num) {
        switch (num) {
            case (2):
                return "Twenty";
            case (3):
                return "Thirty";
            case (4):
                return "Forty";
            case (5):
                return "Fifty";
            case (6):
                return "Sixty";
            case (7):
                return "Seventy";
            case (8):
                return "Eighty";
            case (9):
                return "Ninety";
        }
        return "";
    }
}