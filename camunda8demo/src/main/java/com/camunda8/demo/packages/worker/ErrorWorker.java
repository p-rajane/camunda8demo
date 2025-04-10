package com.camunda8.demo.packages.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.exception.ZeebeBpmnError;
import org.springframework.stereotype.Component;

@Component
public class ErrorWorker {

	@JobWorker
	public void errorWorker(final JobClient client, final ActivatedJob jo) {
		System.out.print("Error Worker");
	}
}
