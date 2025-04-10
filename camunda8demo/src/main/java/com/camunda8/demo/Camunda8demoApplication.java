package com.camunda8.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.annotation.Deployment;

@SpringBootApplication
@Deployment(resources = {"model.bpmn","callActivity.bpmn"})
public class Camunda8demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Camunda8demoApplication.class, args);
	}

}
