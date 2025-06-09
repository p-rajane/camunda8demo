package com.camunda8.demo.packages.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class AdultWorker {

  @JobWorker(type = "adultWorker")
  public void adultWorker(final JobClient client, final ActivatedJob jo) {
    System.out.print("Adult Worker");
  }
}
