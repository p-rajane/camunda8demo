package com.camunda8.demo.packages;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

		@Autowired ZeebeClient client;
		
		@GetMapping("/getDetails/{route}/{age}")
		public String getCall(@PathVariable("route") String route, @PathVariable("age") int age) {
			Map map = new HashMap();
			map.put("route", route);
			map.put("callActivity", true);
			map.put("age", age);
			client.newCreateInstanceCommand()
			.bpmnProcessId("FirstModel_")
			.latestVersion()
					.variables(map)
			.send().join();
			return "<h1><span style=\"color: #ff6600;\"><strong>Hello Pramod Rajane</strong></span></h1>";
		}
}
