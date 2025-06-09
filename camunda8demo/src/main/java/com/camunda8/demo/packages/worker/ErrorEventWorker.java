package com.camunda8.demo.packages.worker;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class ErrorEventWorker {
	
	@JobWorker
	public void errorEventWorker(final JobClient client, final ActivatedJob jo) {
		client.newThrowErrorCommand(jo.getKey())
	    .errorCode("BUSINESS_FAILURE")
	    .errorMessage("Business failure occured...")
	    .send()
	    .join();
	}

}
