package com.camunda8.demo.packages.worker.compensation;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class BookingWorker {
	
	@JobWorker
	public void bookingWorker(final JobClient jobClient, final ActivatedJob activatedJob) {
		System.out.println("booking opeartion started.");
	}

}
