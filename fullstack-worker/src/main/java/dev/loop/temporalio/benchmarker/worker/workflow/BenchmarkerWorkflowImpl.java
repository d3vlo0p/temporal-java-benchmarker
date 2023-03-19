package dev.loop.temporalio.benchmarker.worker.workflow;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;

import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivity;
import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityInput;
import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityResult;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkInput;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkResult;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkerWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.activity.LocalActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

public class BenchmarkerWorkflowImpl implements BenchmarkerWorkflow {

    BenchmarkActivity activity = Boolean.FALSE.equals(ActivityConfiguration.getLocalActivity())
            ? Workflow.newActivityStub(BenchmarkActivity.class,
                    ActivityOptions.newBuilder()
                            .setTaskQueue(ActivityConfiguration.getTaskQueue())
                            .setStartToCloseTimeout(Duration.ofSeconds(10))
                            .setRetryOptions(RetryOptions.newBuilder()
                                    .setMaximumAttempts(3)
                                    .build())
                            .build())
            : Workflow.newLocalActivityStub(BenchmarkActivity.class,
                    LocalActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(10))
                            .setRetryOptions(RetryOptions.newBuilder()
                                    .setMaximumAttempts(3)
                                    .build())
                            .build());

    static Logger log = Workflow.getLogger(BenchmarkerWorkflowImpl.class);

    @Override
    public BenchmarkResult benchmark(BenchmarkInput input) {
        long startTime = Workflow.currentTimeMillis();
        List<BenchmarkActivityResult> results = new LinkedList<>();
        for (int i = 0; i < input.iterations(); i++) {
            results.add(activity
                    .benchmark(new BenchmarkActivityInput(input.minDurationInMillis(), input.maxDurationInMillis())));
        }
        log.info("Total wf execution: {} ms", Workflow.currentTimeMillis() - startTime);
        return new BenchmarkResult(results);
    }

}
