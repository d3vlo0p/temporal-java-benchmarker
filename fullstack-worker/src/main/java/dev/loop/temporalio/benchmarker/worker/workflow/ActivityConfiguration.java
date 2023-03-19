package dev.loop.temporalio.benchmarker.worker.workflow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivityConfiguration {

    static String TASKQUEUE;
    static Boolean localActivity;

    @Value("${benchmarker.activity-task-queue:default}")
    public static void setNameStatic(String taskQueue) {
        ActivityConfiguration.TASKQUEUE = taskQueue;
    }

    public static String getTaskQueue() {
        return TASKQUEUE;
    }

    @Value("${benchmarker.local-activity:false}")
    public static void setLocalActivity(Boolean localActivity) {
        ActivityConfiguration.localActivity = localActivity;
    }

    public static Boolean getLocalActivity() {
        return localActivity;
    }

}
