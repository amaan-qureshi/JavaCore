package com.hackerrank.warmup;

public class SolutionCountingValleys {

    static int countingValleys(int n, String s) {

        String[] c = s.split("");
        int valleys = 0;
        int level = 0;

        for(int i= 0 ; i < c.length ; i++){

            if(c[i].equals("U")){

                level++;
                if(level == 0){
                    valleys++;
                }

            }
            else if(c[i].equals("D")){

                level--;

            }

        }


        return valleys;
    }

}
