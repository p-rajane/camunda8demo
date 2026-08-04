package com.camunda8.demo.packages;

import com.camunda8.demo.packages.worker.User;
import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    client
        .newCreateInstanceCommand()
        .bpmnProcessId("FirstModel_")
        .latestVersion()
        .variables(map)
        .send()
        .join();
    return "<h1><span style=\"color: #ff6600;\"><strong>Hello Pramod Rajane</strong></span></h1>";
  }

  @PostMapping("/multi-instance")
    public void callMultiInstance(@RequestBody List<User> userList) {

      /*Map<String, Object> variables = new HashMap<>();
      variables.put("list", userList);

      client.newCreateInstanceCommand()
              .bpmnProcessId("MultiInstance")
              .latestVersion()
              .variables(variables)
              .send()
              .join();*/

      Map<String, Object> variables = new HashMap<>();
      variables.put("list", userList);

      client.newCreateInstanceCommand()
              .bpmnProcessId("MainProcess")
              .latestVersion()
              .variables(variables)
              .send()
              .join();
    }

}
