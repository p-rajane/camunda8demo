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
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        log.info("Onboarded to system, Employee Name == {}", eachUserMap.get("name"));
    }

    @JobWorker(type = "accountCreation")
    public void accountCreation(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        if( !(boolean)eachUserMap.get("bankAccountExist") ) {
            log.info("New Account created for == {}", eachUserMap.get("name"));
        } else {
            log.info("Existing Account updated with payroll team for employee == {}", eachUserMap.get("name"));
        }
        log.info("Bank account created successfully for employee == {}", eachUserMap.get("name"));
    }

    @JobWorker(type = "rmsPoolAllocation")
    public void rmsPoolAllocation(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        log.info("Employee == {} Allocated to RMS pool.", eachUserMap.get("name"));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @JobWorker(type = "resourceManagerMailSender")
    public void resourceManagerMailSender(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        log.info("Email sent to == {} for employee == {} with tech stack == {}",
                variablesAsMap.get("resManEmail"),
                eachUserMap.get("name"),
                eachUserMap.get("techStack"));
    }

    @JobWorker(type = "unbilledReminder")
    public void unbilledReminder(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        log.info("Unbilled reminder sent to employee == {}, and account manager.",
                eachUserMap.get("name"));
    }

    @JobWorker(type = "backgroundVerification")
    public void backgroundVerification(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        log.info("Background verifications started for employee == {}.", eachUserMap.get("name"));
        if(true) {
            throw new ZeebeBpmnError("VERIFICATION_FAILED", "Background verification failed.", Collections.emptyMap());
        }
    }

    @JobWorker(type = "offboarding")
    public void offboarding(final JobClient jobClient, final ActivatedJob activatedJob) {
        Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
        Map<String, Object> eachUserMap = (Map<String, Object>) variablesAsMap.get("eachUser");
        log.info("Employee == {} offboarded from system.", eachUserMap.get("name"));
    }

    @JobWorker(type = "printTask")
    public void printTask(final JobClient jobClient, final ActivatedJob activatedJob) {
        log.info("Inside multi instance == {}", activatedJob.getVariable("eachElement"));
    }

}
