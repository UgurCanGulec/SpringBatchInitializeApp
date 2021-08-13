package com.j4v4developers.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class PersonJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Before starting the job " + jobExecution.getJobInstance().getJobName());
        System.out.println("Before starting the job " + jobExecution.getExecutionContext());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job has been complete.");

    }
}
