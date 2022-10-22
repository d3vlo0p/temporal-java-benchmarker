package dev.loop.temporalio.benchmarker.activityworker.activity;

import java.util.Random;

import org.springframework.stereotype.Service;

import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivity;
import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityInput;
import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("BenchmarkActivity")
public class BenchmarkActivityImpl implements BenchmarkActivity {

    Random r = new Random();

    @Override
    public BenchmarkActivityResult benchmark(BenchmarkActivityInput input) {
        Long startTime = System.currentTimeMillis();
        Long millisToWait = r.nextLong(input.minDurationInMillis(), input.maxDurationInMillis());
        log.info("Millis To Wait: {}", millisToWait);
        try {
            Thread.sleep(millisToWait);
        } catch (InterruptedException e) {
            log.warn("Wait interrupted", e);
        }
        return new BenchmarkActivityResult(System.currentTimeMillis() - startTime);
    }

}
