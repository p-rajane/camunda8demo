package com.camunda8.demo;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = {"mcpToolModel.bpmn", "model.bpmn", "callActivity.bpmn", "kafka-connector.bpmn",
        "emailConnector.bpmn", "emailConnector_freemail.bpmn", "errorEvent.bpmn", "compensationEvent.bpmn", "eventBasedGateway.bpmn"})//@Deployment(resources = {"model.bpmn", "callActivity.bpmn", "kafka-connector.bpmn", "emailConnector.bpmn", "errorEvent.bpmn", "compensationEvent.bpmn", "LoanProcessWorkflow.bpmn"})
public class Camunda8demoApplication {

  public static void main(String[] args) {
    SpringApplication.run(Camunda8demoApplication.class, args);
  }
}
