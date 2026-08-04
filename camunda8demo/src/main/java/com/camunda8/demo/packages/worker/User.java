package com.camunda8.demo.packages.worker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String city;
    private String techStack;
    private String level;
    private boolean bankAccountExist;
}
