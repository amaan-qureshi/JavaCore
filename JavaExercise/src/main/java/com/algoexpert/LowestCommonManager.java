package com.algoexpert;


import java.util.*;

public class LowestCommonManager {

    public static void main(String[] args) {

        OrgChart d = new OrgChart('D');
    }


    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        List<OrgChart> pathToReporteeOne = new ArrayList<>();
        depthFirst(topManager,reportOne,pathToReporteeOne);

        List<OrgChart> pathToReporteeTwo = new ArrayList<>();
        depthFirst(topManager,reportOne,pathToReporteeOne);

        List<OrgChart> longer = pathToReporteeOne.size() >=  pathToReporteeTwo.size()  ? pathToReporteeOne : pathToReporteeTwo;
        List<OrgChart> shorter = pathToReporteeOne.size() <  pathToReporteeTwo.size()  ? pathToReporteeTwo : pathToReporteeOne;

        for(int i = shorter.size()-1 ; i >= 0 ; i--){

            final int index = i;
            Optional<OrgChart> result = longer.stream().filter(orgChart -> orgChart.name == shorter.get(index).name).findAny();
            if(result.isPresent()){
                return result.get();
            }
        }

        return null;
    }

    private static void depthFirst(OrgChart topManager, OrgChart reportOne, List<OrgChart> pathToReporteeOne) {

        Stack<OrgChart> stack = new Stack<OrgChart>();
        stack.push(topManager);

        while(!stack.isEmpty()){

            OrgChart o = stack.pop();
            if(o.name == reportOne.name){
                Object[] os =  stack.toArray();
                for(Object oe : os){
                    pathToReporteeOne.add((OrgChart)oe);
                }

                return;
            }

            for(OrgChart d : o.directReports){
                stack.push(d);
            }

        }

    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

}
