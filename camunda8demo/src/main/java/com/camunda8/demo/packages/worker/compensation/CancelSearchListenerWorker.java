package com.camunda8.demo.packages.worker.compensation;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class CancelSearchListenerWorker {
	
	@JobWorker
	public void cancelSearchListenerWorker(final JobClient jobClient, final ActivatedJob activatedJob) {
		System.out.println("inside cancel search.");
	}

}
