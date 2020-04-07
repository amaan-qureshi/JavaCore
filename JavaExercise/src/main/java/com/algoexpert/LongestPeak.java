package com.algoexpert;

public class LongestPeak {

    public static void main(String[] args) {
        int[] arr =  {1,3,2};
        System.out.println(longestPeak(arr));
    }

    public static int longestPeak(int[] array) {
        // Write your code here.
        int longest = 0;

        for (int i = 1; i < array.length - 1; i++) {

            if (IsPeak(array, i)) {

                int peakStart = findPeakStart(i - 1, array);
                int peakEnd = findPeakEnd(i + 1, array);

                int size = (peakEnd - peakStart)+1;
                if (size > longest) {
                    longest = size;
                }

            }
        }

        return longest;
    }

    private static int findPeakEnd(int i, int[] array) {

        int end = i;
        while (end < array.length-1 && array[end + 1] < array[end]) {
            end++;
        }
        return end;
    }

    private static int findPeakStart(int i, int[] array) {

        int start = i;
        while (start > 0 && array[start - 1] < array[start]) {
            start--;
        }
        return start;
    }

    private static boolean IsPeak(int[] array, int i) {
        return array[i - 1] < array[i] && array[i] > array[i + 1];
    }


}
