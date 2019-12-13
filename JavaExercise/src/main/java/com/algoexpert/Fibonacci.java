package com.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.print(getNthFib(9));
    }


    static Map<Integer,Integer> cache =new HashMap<>();

    static {

        cache.put(0,0);
        cache.put(1,0);
        cache.put(2,1);
    }

    public static int getNthFib(int n) {
        // Write your code here.
        if(n==0 || n==1 || n==2) {
            return cache.get(n);
        }

        int x;
        int y;
        if(cache.get(n-1) == null){
            x = getNthFib(n-1);
        }
        else{
            x = cache.get(n-1);
        }

        if(cache.get(n-2) == null){
            y = getNthFib(n-2);
        }
        else{
            y = cache.get(n-2);
        }

        cache.put(n,x+y);
        return x + y;
    }


}