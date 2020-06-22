package com.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static  List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        if(n == 0){
            result.add("");
            return result;
        }

        for(int c = 0 ; c < n ; c++){
            for (String left: generateParenthesis(c))
                for (String right: generateParenthesis(n-1-c))
                    result.add("(" + left + ")" + right);

        }

        return result;
    }
}
