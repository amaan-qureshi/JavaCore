package com.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Room {

    int id;
    int start;
    int end;

    public Room(int i, int i1, int i2) {
        this.id = i;
        this.start = i1;
        this.end = i2;
    }
}

public class MinMeetingRooms {

    public static void main(String[] args) {
        //int[][] array = {{0, 30}, {5, 40}, {35, 60}};
        int[][] array = {{1293,2986},{848,3846},{4284,5907},{4466,4781},{518,2918},{300,5870}};
        System.out.println(new MinMeetingRooms().minMeetingRooms(array));
    }

    public int minMeetingRooms(int[][] intervals) {

        if(intervals==null || intervals.length == 0)return 0;

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int c = 0;
        for(int[] i : intervals){
            starts[c] = i[0];
            ends[c] = i[1];
            c++;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);


       int p1 = 0;
       int p2 = 0;
       int minRooms = 0;

       while(p1<intervals.length){

           if(starts[p1] >= ends[p2]){
               p2++;
               minRooms--;
           }

           minRooms++;
           p1++;

       }


        return minRooms;
    }

    void print(int[][] array) {

        for (int[] i : array) {
            System.out.println("[" + i[0] + " " + i[1] + "]");
        }
        System.out.println();
    }

}
