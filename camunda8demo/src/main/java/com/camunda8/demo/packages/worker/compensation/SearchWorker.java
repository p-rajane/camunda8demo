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

    @JobWorker(type = "prepareMenu")
    public void prepareMenu(final JobClient jobClient, final ActivatedJob activatedJob) {
        System.out.println("prepareMenu operation started.");
    }

    @JobWorker(type = "changeMenu")
    public void changeMenu(final JobClient jobClient, final ActivatedJob activatedJob) {
        System.out.println("changeMenu operation started.");
    }

    @JobWorker(type = "gotoOtherCustomer")
    public void gotoOtherCustomer(final JobClient jobClient, final ActivatedJob activatedJob) {
        System.out.println("gotoOtherCustomer operation started.");
    }

}
