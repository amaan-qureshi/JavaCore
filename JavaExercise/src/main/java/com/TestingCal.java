package com;


import java.util.Calendar;

public class TestingCal {

    public static void main(String[] args) {

        java.util.Calendar result = null;

        Object baseValidity = "32503625182051";

        if(baseValidity instanceof java.util.Calendar){
            result = (java.util.Calendar)baseValidity;
        }
        else{
            try{
                long baseVal = Long.parseLong((String)baseValidity);
                result = Calendar.getInstance();
                result.setTimeInMillis(baseVal);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(result.getTime());

    }
}
