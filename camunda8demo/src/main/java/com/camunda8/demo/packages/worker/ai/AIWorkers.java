package com.camunda8.demo.packages.worker.ai;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

/**
 * @author Pramod Rajane
 */

@Component
public class AIWorkers {
    @JobWorker(type = "mcpToolAnalyzer")
    public void afterErrorWorker(final JobClient client, final ActivatedJob jo) {
        System.out.print("AI Agentic response == " + jo.getVariables());
    }
}
