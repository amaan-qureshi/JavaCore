package com.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

    public static void main(String[] args) {

        //String[] arr = patternMatcher("xxyxxy", "gogopowerrangergogopowerranger");
        String[] arr = patternMatcher("xyx", "thisshouldobviouslybewrong");
        if (arr.length == 0) {
            System.out.println(arr);
        } else {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public static String[] patternMatcher(String pattern, String str) {

        String finalPattern = pattern.toCharArray()[0] == 'y' ?
                pattern.replaceAll("x", "z").replaceAll("y", "x").replaceAll("z", "y") :
                pattern;
        boolean isSwitched = !finalPattern.equals(pattern);
        Map<String, Long> countMap = new HashMap<>();
        countMap.put("x", finalPattern.chars().filter(c -> c == 'x').count());
        countMap.put("y", finalPattern.chars().filter(c -> c == 'y').count());

        int firstYIdx = finalPattern.indexOf('y');

        if (countMap.get("y") == 0) {

            double lengthOfX = (double) str.length() / (double) countMap.get("x");

            if (Math.floor(lengthOfX) == lengthOfX) {

                String x = str.substring(0, (int) lengthOfX);
                String potentialString = "";

                int count = 0;
                while (count < countMap.get("x")) {
                    potentialString += x;
                    count++;
                }

                if (str.equals(potentialString)) {
                    return isSwitched ? new String[]{"", x} : new String[]{x, ""};
                }

            }
        } else {

            for (int lengthOfX = 1; lengthOfX < str.length(); lengthOfX++) {

                double lengthOfY = ((double) str.length() - ((double) lengthOfX * (double) countMap.get("x"))) / (double) countMap.get("y");
                if (Math.floor(lengthOfY) == lengthOfY && (lengthOfY > 0)) {

                    int positionY = firstYIdx * lengthOfX;
                    String potentialX = str.substring(0, lengthOfX);
                    String potentialY = str.substring(positionY, positionY + (int) lengthOfY);
                    String potentialString = "";
                    for (int i = 0; i < finalPattern.length(); i++) {

                        if (finalPattern.charAt(i) == 'x') {
                            potentialString = potentialString + potentialX;
                        } else {
                            potentialString = potentialString + potentialY;
                        }

                    }
                    if (potentialString.equals(str)) {
                        return isSwitched ? new String[]{potentialY, potentialX} : new String[]{potentialX, potentialY};
                    }
                }
            }
        }

        return new String[0];
    }


}
