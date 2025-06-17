package com.camunda8.demo.packages.worker.compensation;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class CancelBookingListenerWorker {
	
	@JobWorker
	public void cancelBookingListenerWorker(final JobClient jobClient, final ActivatedJob activatedJob) {
		System.out.println("inside cancel booking.");
	}

}
