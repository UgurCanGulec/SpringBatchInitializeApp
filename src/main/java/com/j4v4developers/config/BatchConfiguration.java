package com.j4v4developers.config;

import com.j4v4developers.listener.PersonJobExecutionListener;
import com.j4v4developers.listener.PersonStepExecutionListener;
import com.j4v4developers.model.Person;
import com.j4v4developers.processor.InMemoryItemProcessor;
import com.j4v4developers.reader.InMemoryReader;
import com.j4v4developers.writer.ConsoleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private PersonJobExecutionListener personJobExecutionListener;
    @Autowired
    private PersonStepExecutionListener personStepExecutionListener;
    @Autowired
    private InMemoryItemProcessor inMemoryItemProcessor;

    @Bean
    public InMemoryReader reader() {
        return new InMemoryReader();
    }

    @Bean
    public Step personRaiseSalaryStep() {
        return stepBuilderFactory.get("personRaiseSalaryStep")
                .listener(personStepExecutionListener)
                .<Person, Person>chunk(3)
                .reader(reader())
                .processor(inMemoryItemProcessor)
                .writer(new ConsoleItemWriter())
                .build();
    }

    @Bean
    public Job personRaiseSalaryJob() {
        return jobBuilderFactory.get("personRaiseSalaryJob")
                .listener(personStepExecutionListener)
                .start(personRaiseSalaryStep())
                .build();
    }
}
