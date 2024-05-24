package com.orbitguard.orbitguard.controller;

import com.orbitguard.orbitguard.model.example.Example;
import com.orbitguard.orbitguard.model.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrbitGuardController {

    @Autowired
    private ExampleService service;

    public Example addExample(Example example) {
        return service.save(example);
    }

}
