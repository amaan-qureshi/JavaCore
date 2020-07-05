package com.leetcode;
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        JobGraph graph = new JobGraph();
        for (int i = 0; i < numCourses; i++) {
            graph.addJob(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.addDependency(prerequisites[i][1], (prerequisites[i][0]));
        }

        List<Integer> result = new ArrayList<>();
        Stack<JobNode> jobsWithNoDependencies = new Stack<>();

        for (Integer jobNumber : graph.jobs.keySet()) {
            if (graph.jobs.get(jobNumber).dependecyCount == 0) {
                jobsWithNoDependencies.push(graph.jobs.get(jobNumber));
            }
        }

        while (!jobsWithNoDependencies.isEmpty()) {
            JobNode noDependecyJob = jobsWithNoDependencies.pop();
            result.add(noDependecyJob.job);
            graph.removeDependency(noDependecyJob, jobsWithNoDependencies);

        }


        return result.size() == numCourses;
    }


}

class JobNode {

    public Integer job;
    public List<JobNode> dependencies;
    int dependecyCount;

    JobNode(int jobNumber) {

        this.job = jobNumber;
        dependencies = new ArrayList<>();
        this.dependecyCount = 0;
    }

}

class JobGraph {

    Map<Integer, JobNode> jobs = new HashMap<>();


    public void addJob(int jobNumber) {
        JobNode node = new JobNode(jobNumber);
        jobs.put(jobNumber, node);
    }

    public void addDependency(int jobNumber, int dependencyNumber) {

        JobNode job = this.jobs.get(jobNumber);
        JobNode dependency = this.jobs.get(dependencyNumber);
        job.dependencies.add(dependency);
        job.dependecyCount = job.dependecyCount + 1;
    }

    public void removeDependency(JobNode noDependencyJob, Stack<JobNode> jobsWithNoDependencies) {

        for (Integer jobNumber : jobs.keySet()) {

            if (jobs.get(jobNumber).dependencies.contains(noDependencyJob)) {
                jobs.get(jobNumber).dependencies.remove(noDependencyJob);
                jobs.get(jobNumber).dependecyCount = jobs.get(jobNumber).dependecyCount - 1;
                if (jobs.get(jobNumber).dependecyCount == 0) {
                    jobsWithNoDependencies.push(jobs.get(jobNumber));
                }
            }


        }

    }
}