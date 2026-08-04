package com.camunda8.demo.packages.loanprocessing;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Notification {

    @JobWorker(type = "notification")
    public void notify(final JobClient jobClient, final ActivatedJob activatedJob) {

        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        System.out.println();

    }
}
