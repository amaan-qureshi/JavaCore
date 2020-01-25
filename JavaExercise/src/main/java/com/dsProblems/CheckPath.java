package com.dsProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CheckPath {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("NewYork","Chicago");
        map.put("Boston","Texas");
        map.put("Missouri","NewYork");
        map.put("Texas","Missouri");

        System.out.print(tracePath(map));


    }


    public static String tracePath(Map<String,String> map) {

        String result = "";

        String start = null;

        HashSet<String> values = new HashSet<>();
        for(String keys : map.keySet()){
            values.add(map.get(keys));
        }

        for(String keys : map.keySet()){
            if(!values.contains(keys)){
                start = keys;
                break;
            }
        }

        while(true){

            String val = map.get(start);
            if(val == null){
                break;
            }

            result = result+start+"->"+val+" , ";
            start = val;

        }

        return result;
    }
}
