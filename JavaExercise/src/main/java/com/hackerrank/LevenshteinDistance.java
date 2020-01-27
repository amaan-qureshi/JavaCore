package com.hackerrank;

public class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc","abc"));
    }

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.

        int[][] matrix = new int[str1.length()+1][str2.length()+1];

        for(int i = 0 ; i < str1.length()+1 ; i++){
            for(int j = 0 ; j < str2.length()+1 ; j++){
                matrix[i][j] = j;
            }
            matrix[i][0] = i;
        }

        for(int i = 1 ; i < str1.length()+1 ; i++){

            for(int j = 1 ; j < str2.length()+1 ; j++){

               if(str1.charAt(i-1) == str2.charAt(j-2)){
                   matrix[i][j] = matrix[i-1][j-1];
               }
               else{
                   matrix[i][j] = 1+ Math.min(Math.min(matrix[i-1][j],matrix[i][j-1]),matrix[i-1][j-1]);
               }

            }
        }

        return matrix[str1.length()][str2.length()];
    }

}
