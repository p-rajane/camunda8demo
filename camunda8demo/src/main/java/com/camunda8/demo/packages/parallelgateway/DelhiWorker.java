package com.camunda8.demo.packages.parallelgateway;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class DelhiWorker {

  @JobWorker(type = "delhiWorker")
  public void delhiWorker(final JobClient client, final ActivatedJob jo) {
    System.out.print("Delhi Worker");
  }
}
