package com.camunda8.demo.packages.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CalculateWorker {

  @JobWorker
  public void calculate(final JobClient client, final ActivatedJob jo) {
    client.newCompleteCommand(jo.getKey()).variables(Map.of("usingClient", "rajane")).send().join();
    // To throw error which will be catch by error catch event
    /*client.newThrowErrorCommand(jo.getKey())
    .errorCode("ERR")
    .send()
    .join();*/
  }
}
