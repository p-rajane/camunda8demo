package com.camunda8.demo.packages.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.CustomHeaders;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class AgeWorker {

  @JobWorker
  public void ageWorker(
      final JobClient client, final ActivatedJob jo, @CustomHeaders Map<String, String> headers) {
    Map<String, Object> variablesAsMap = jo.getVariablesAsMap();
    System.out.print("Age Worker");
  }
}
