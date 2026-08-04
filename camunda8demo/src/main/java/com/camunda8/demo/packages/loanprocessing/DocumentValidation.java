package com.camunda8.demo.packages.loanprocessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Component
public class DocumentValidation {

    @JobWorker(type = "validateDocument")
    public Map<String, Object> validateDocument(final JobClient jobClient, final ActivatedJob activatedJob) throws InvocationTargetException, IllegalAccessException, JsonProcessingException {
        Map<String, Object> variablesAsMap = (Map<String, Object>)activatedJob.getVariable("result");
        return  Map.of("age", 15);
    }
}
