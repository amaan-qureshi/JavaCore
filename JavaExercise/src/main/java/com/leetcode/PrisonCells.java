package com.leetcode;

import java.util.Arrays;

public class PrisonCells {

    public static void main(String[] args) {

        int[] res = prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0},1000000000);
        for(int i = 0 ; i < res.length ; i++){
            System.out.print(res[i]+", ");
        }
        //0, 0, 1, 1, 1, 1, 1, 0,
        //0, 0, 1, 1, 1, 1, 1, 0,
    }

    public static int[] prisonAfterNDays2(int[] cells, int N) {

        int[] firstSimulation = new int[8];
        for (int i = 1; i < 7; i++) firstSimulation[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
        cells = firstSimulation.clone();
        N -= 1;
        int cycle = 1;
        while (N-- > 0) {
            int[] nextSimulation = new int[8];
            for (int i = 1; i < 7; i++) nextSimulation[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
            if (Arrays.equals(firstSimulation, nextSimulation)) N %= cycle;
            cells = nextSimulation.clone();
            cycle++;
        }
        return cells;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        int[] tmpCells = cells.clone();
        int[] tmpCellsFirstSim = tmpCells.clone();
        for(int i = 1 ; i < tmpCells.length-1 ; i++){
            tmpCellsFirstSim[i] =  (tmpCells[i-1] == tmpCells[i+1] ? 1 : 0);
        }

        int cycle = 0;
        int day = 0;
        int[] res = cells.clone();
        while(day < N){

            for(int i = 1 ; i < cells.length-1 ; i++){

                if((cells[i-1]== 1 && cells[i+1] == 1 )||(cells[i-1] == 0 && cells[i+1] == 0 )){
                    res[i] = 1;
                }

                else{
                    res[i] = 0;
                }
            }
            if(Arrays.equals(tmpCellsFirstSim,res)){
                cycle = day;
            }

            cells = res.clone();

            day++;
        }
        return res;
    }

}
