package com.camunda8.demo.packages.worker;

import java.util.Map;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.exception.ZeebeBpmnError;
import org.springframework.stereotype.Component;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;

@Component
public class NameWorker {

	@JobWorker
	public void nameWorker(final JobClient client, final ActivatedJob jo) {
		Map<String, Object> variablesAsMap = jo.getVariablesAsMap();
		System.out.print("Name Worker");
		if((int)variablesAsMap.get("age") == 18) {
			throw new ZeebeBpmnError("BPS", "Age is == 18");
		}
	}
}
