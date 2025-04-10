package com.camunda8.demo.packages.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CallActivityWorker {

	@JobWorker
	public Map<String, Object> callActivityWorker(final JobClient client, final ActivatedJob jo) {
		Map map = new HashMap();
		map.put("callActivityVariable", "Child variable");
		System.out.print("Call Activity Worker");
		return map;
	}
}
