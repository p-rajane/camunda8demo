package com.camunda8.demo.packages.adhoc;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class AdHocWorker {

  @JobWorker(type = "task1")
  public void task1 (final JobClient client, final ActivatedJob jo) {
    System.out.print("Task1 Worker");
  }

    @JobWorker(type = "task2")
    public void task2(final JobClient client, final ActivatedJob jo) {
        System.out.print("Task2 Worker");
    }

    @JobWorker(type = "task3")
    public void task3 (final JobClient client, final ActivatedJob jo) {
        System.out.print("Task3 Worker");
    }

    @JobWorker(type = "task4")
    public void task4 (final JobClient client, final ActivatedJob jo) {
        System.out.print("Task4 Worker");
    }
}
