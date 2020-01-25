package com.algoexpert;

public class AlphabetRotation {

    public static void main(String[] args) {
        System.out.print(caesarCypherEncryptor("xyz",2));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.

        StringBuilder sb = new StringBuilder("");

        for(int i=0 ; i < str.length() ; i++){

            int index = str.charAt(i) - 'a';
            index= index+key;
            if(index%26 >= 0){
                index = index%26;
            }
            char c = (char)(index+'a');
            sb.append(c+"");
        }


        return sb.toString();
    }
}
