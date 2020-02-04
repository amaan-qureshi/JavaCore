package com.algoexpert;
import java.util.*;

public class LowestCommonManager {

    public static void main(String[] args) {

        OrgChart a = new OrgChart('A');
        a.directReports.addAll(Arrays.asList(new OrgChart('B'),new OrgChart('C')));
        a.directReports.get(0).directReports.addAll(Arrays.asList(new OrgChart('D'),new OrgChart('E')));
        a.directReports.get(0).directReports.get(0).directReports.addAll(Arrays.asList(new OrgChart('H'),new OrgChart('I')));
        a.directReports.get(1).directReports.addAll(Arrays.asList(new OrgChart('F'),new OrgChart('G')));

        System.out.println(getLowestCommonManager(a, a.directReports.get(0).directReports.get(1),a.directReports.get(0).directReports.get(0).directReports.get(1)).name);
    }

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        return getOrgInfo(topManager,reportOne,reportTwo).lcm;
    }

    public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {

        int importantReportees = 0;

        for(OrgChart reportees : manager.directReports){

            OrgInfo orgInfo = getOrgInfo(reportees,reportOne,reportTwo);
            if(orgInfo.lcm != null){
                return orgInfo;
            }
            importantReportees = importantReportees+orgInfo.numOfImpEmp;
        }

        if(manager==reportOne || manager == reportTwo){
            importantReportees++;
        }

        OrgChart lcm = importantReportees == 2 ? manager : null;

        return new OrgInfo(lcm,importantReportees);
    }

    static class OrgInfo{

        OrgChart lcm;
        int numOfImpEmp;


        OrgInfo(OrgChart lcm,int numOfImpEmp){
            this.lcm = lcm;
            this.numOfImpEmp = numOfImpEmp;
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
