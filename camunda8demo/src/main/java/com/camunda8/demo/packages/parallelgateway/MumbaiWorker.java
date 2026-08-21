package com.camunda8.demo.packages.parallelgateway;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class MumbaiWorker {

  @JobWorker(type = "mumbaiWorker")
  public void mumbaiWorker(final JobClient client, final ActivatedJob jo) {
    System.out.print("Mumbai Worker");
  }
}
