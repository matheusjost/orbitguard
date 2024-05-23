package com.orbitguard.controller;

import com.orbitguard.model.example.ExampleLocalService;

import javax.inject.Inject;

public class OrbitGuardController {

    private ExampleLocalService service;

    @Inject
    public OrbitGuardController(ExampleLocalService service) {
        this.service = service;
    }

    public OrbitGuardController() {
        // TODO: VERIFICAR AS DEPENDECY INJECTIONS
    }
}
