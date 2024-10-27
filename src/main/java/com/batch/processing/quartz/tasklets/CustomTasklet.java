package com.batch.processing.quartz.tasklets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomTasklet implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        log.info("CustomTasklet start..");

        // ... your code

        log.info("CustomTasklet done..");
        return RepeatStatus.FINISHED;
    }
}