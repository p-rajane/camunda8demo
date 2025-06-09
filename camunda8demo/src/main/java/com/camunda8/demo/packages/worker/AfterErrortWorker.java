package com.camunda8.demo.packages.worker;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class AfterErrortWorker {
	
	@JobWorker
	public void afterErrorWorker(final JobClient client, final ActivatedJob jo) {
		System.out.print("After error...");
	}

}
