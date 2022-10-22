package dev.loop.temporalio.benchmarker.commons.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface BenchmarkActivity {

    @ActivityMethod
    public BenchmarkActivityResult benchmark(BenchmarkActivityInput input);

}
