package com.orbitguard.orbitguard.controller;

import com.orbitguard.orbitguard.model.objeto.Objeto;
import com.orbitguard.orbitguard.model.objeto.ObjetoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrbitGuardController {

    @Autowired
    private ObjetoService service;

    public Objeto addObjeto(Objeto obj) {
        return service.save(obj);
    }

    public List<Objeto> getObjetos() {
        return service.findAll();
    }
    
    public List<Objeto> getObjetosDistanciaMaiorLimit(double distancia, int limit) {
        return service.findByDistanciaGreaterThanLimit(distancia, limit);
    }
    
    public List<Objeto> getObjetosDistanciaMaior(double distancia) {
        return service.findByDistanciaGreaterThan(distancia);
    }
}
