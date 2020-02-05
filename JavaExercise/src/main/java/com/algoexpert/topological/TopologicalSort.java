package com.algoexpert.topological;
import java.util.*;

public class TopologicalSort {




    public static void main(String[] args) {

        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1,2});
        deps.add(new Integer[]{1,3});
        deps.add(new Integer[]{3,2});
        deps.add(new Integer[]{4,2});
        deps.add(new Integer[]{4,3});
        List<Integer> jobs = Arrays.asList(1,2,3,4);

        System.out.println(topologicalSort(jobs,deps));

    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {

        JobGraph graph = new JobGraph();
        for(Integer jobNumber : jobs){
            graph.addJob(jobNumber);
        }
        for(Integer[] dependency : deps){
            graph.addDependency(dependency[1],dependency[0]);
        }
        List<Integer> result = new ArrayList<>();

        Stack<JobNode> jobsWithNoDependencies = new Stack<>();

        for(Integer jobNumber : graph.jobs.keySet()){
            if(graph.jobs.get(jobNumber).dependecyCount == 0){
                jobsWithNoDependencies.push(graph.jobs.get(jobNumber));
            }
        }

        while(!jobsWithNoDependencies.isEmpty()){

            JobNode noDependecyJob = jobsWithNoDependencies.pop();
            result.add(noDependecyJob.job);
            graph.removeDependency(noDependecyJob,jobsWithNoDependencies);

        }

        // Write your code here.
        return result.size() == jobs.size() ? result : new ArrayList<>();
    }

    static class JobGraph{

        Map<Integer,JobNode> jobs = new HashMap<>();


        public void addJob(int jobNumber){
            JobNode node = new JobNode(jobNumber);
            jobs.put(jobNumber,node);
        }

        public void addDependency(int jobNumber,int dependencyNumber){

            JobNode job = this.jobs.get(jobNumber);
            JobNode dependency = this.jobs.get(dependencyNumber);
            job.dependencies.add(dependency);
            job.dependecyCount = job.dependecyCount+1;
        }

        public void removeDependency(JobNode noDependencyJob, Stack<JobNode> jobsWithNoDependencies) {

            for(Integer jobNumber : jobs.keySet()){

                if(jobs.get(jobNumber).dependencies.contains(noDependencyJob)){
                    jobs.get(jobNumber).dependencies.remove(noDependencyJob);
                    jobs.get(jobNumber).dependecyCount = jobs.get(jobNumber).dependecyCount - 1;
                    if(jobs.get(jobNumber).dependecyCount == 0){
                        jobsWithNoDependencies.push(jobs.get(jobNumber));
                    }
                }



            }

        }
    }

    static class JobNode{

        public Integer job;
        public List<JobNode> dependencies;
        int dependecyCount;

        JobNode(int jobNumber){

            this.job =jobNumber;
            dependencies = new ArrayList<>();
            this.dependecyCount = 0;
        }

    }

}
