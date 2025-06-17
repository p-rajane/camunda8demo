package com.camunda8.demo.packages.worker.compensation;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class SearchWorker {
	
	@JobWorker
	public void searchWorker(final JobClient jobClient, final ActivatedJob activatedJob) {
		System.out.println("search operation started.");
	}

}
