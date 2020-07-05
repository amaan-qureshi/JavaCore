package com.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class RectangleMania {

    public static int rectangleMania(Point[] coords) {
        // Write your code here.

        Set<String> coordsSet = new HashSet<>();

        for (Point coord : coords) {
            coordsSet.add(coord.x + "," + coord.y);
        }

        int rectangles = 0;

        for (Point p1 : coords) {
            for (Point p2 : coords) {

                if (!(isInUpperRight(p1, p2))) continue;
                if (topLeftExists(p1, p2, coordsSet) && bottomRightExists(p1, p2, coordsSet)) rectangles++;

            }
        }

        return rectangles;
    }

    private static boolean bottomRightExists(Point p1, Point p2, Set<String> coords) {
        return coords.contains(p2.x + "," + p1.y);
    }

    private static boolean topLeftExists(Point p1, Point p2, Set<String> coords) {
        return coords.contains(p1.x + "," + p2.y);
    }

    private static boolean isInUpperRight(Point p1, Point p2) {
        return p2.x > p1.x && p2.y > p1.y;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
