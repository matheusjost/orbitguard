package com.orbitguard.orbitguard.controller;

import com.orbitguard.orbitguard.model.objeto.Objeto;
import com.orbitguard.orbitguard.model.objeto.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrbitGuardController {

    @Autowired
    private ObjetoService service;

    public Objeto addObjeto(Objeto obj) {
        return service.save(obj);
    }

}
