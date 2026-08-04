package com.camunda8.demo.packages.loanprocessing;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidateAgeCriteria {

    @JobWorker(type = "validateAgeCriteria")
    public Map<String, Object> validateAgeCriteria(final JobClient jobClient, final ActivatedJob activatedJob) {
        return Map.of("age", 19);
    }
}
