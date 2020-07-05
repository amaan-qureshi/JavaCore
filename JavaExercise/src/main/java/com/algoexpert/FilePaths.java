package com.algoexpert;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiFunction;

public class FilePaths {

    public static boolean test(int a,int b,BiFunction<Integer,Integer, Boolean> func){
        return func.apply(a,b);
    }

    public static String shortenPath(String path) {
        // Write your code here;
        test(1,2, (a, b) -> a > b);
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String token: tokens){
            stack.push(token);
        }
        StringBuilder sb = new StringBuilder("");

        while(!stack.isEmpty()){

            String token = stack.pop();
            if(token.equals(".")){
                continue;
            }
            else if(token.equals("..")){
                stack.pop();
                continue;
            }
            sb.insert(0, token+"/");
        }

        sb.setLength(sb.length() - 1);

        if(path.charAt(0)=='/'){
            sb.insert(0,"/");
        }

        return sb.toString();
    }

}
