package com.camunda8.demo.packages.onboarding;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.exception.ZeebeBpmnError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Slf4j
public class OnboardingWorkers {

    @Autowired
    ZeebeClient zeebeClient;

    @JobWorker(type = "onboardingToSystem")
    public void onboardToSystem(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        log.info("Onboarded to system, Employee Name == {}", variablesAsMap.get("name"));
    }

    @JobWorker(type = "accountCreation")
    public void accountCreation(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        log.info("Bank account created successfully for employee == {}", variablesAsMap.get("name"));
    }

    @JobWorker(type = "rmsPoolAllocation")
    public void rmsPoolAllocation(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        log.info("Employee == {} Allocated to RMS pool.", variablesAsMap.get("name"));
    }

    @JobWorker(type = "projectAllocation")
    public void projectAllocation(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        log.info("Employee == {} Allocated to Billable project.", variablesAsMap.get("name"));
    }

    @JobWorker(type = "backgroundVerification")
    public void backgroundVerification(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        log.info("Background verifications started for employee == {}.", variablesAsMap.get("name"));
        if(true) {
            throw new ZeebeBpmnError("VERIFICATION_FAILED", "Background verification failed.", Collections.emptyMap());
        }
    }

    @JobWorker(type = "offboarding")
    public void offboarding(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        log.info("Employee == {} offboarded from system.", variablesAsMap.get("name"));
    }

    @JobWorker(type = "printTask")
    public void printTask(final JobClient jobClient, final ActivatedJob activatedJob) {
        log.info("Inside multi instance == {}", activatedJob.getVariable("eachElement"));
    }

}
