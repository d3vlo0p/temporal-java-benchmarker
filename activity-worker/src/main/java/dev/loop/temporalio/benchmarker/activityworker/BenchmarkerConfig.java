package dev.loop.temporalio.benchmarker.activityworker;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// @Configuration
@ConfigurationProperties(prefix = "benchmarker")
public class BenchmarkerConfig {

    Integer pollers = 0;
    Integer executors = 0;
    String taskQueue = "default";

}
