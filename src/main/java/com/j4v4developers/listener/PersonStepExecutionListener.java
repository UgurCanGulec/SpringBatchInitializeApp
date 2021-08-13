package com.j4v4developers.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class PersonStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Before step execution");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("After step execution");
        return null;
    }
}
