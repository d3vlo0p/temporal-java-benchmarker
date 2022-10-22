package dev.loop.temporalio.benchmarker.workflowworker.workflow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivityConfiguration {

    static String TASKQUEUE;

    @Value("${benchmarker.activity-task-queue}")
    public void setNameStatic(String taskQueue) {
        ActivityConfiguration.TASKQUEUE = taskQueue;
    }

    public static String getTaskQueue() {
        return TASKQUEUE;
    }

}
