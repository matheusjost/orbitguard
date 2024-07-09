package com.orbitguard.orbitguard.controller;

import com.orbitguard.orbitguard.model.objeto.Objeto;
import com.orbitguard.orbitguard.model.objeto.ObjetoService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrbitGuardController {

    @Autowired
    private ObjetoService service;

    public Objeto addObjeto(Objeto obj) {
        return service.save(obj);
    }

    public void updateLocalObjeto(Date start, Date end) {
        service.updateLocalObjeto(start, end);
    }

    public List<Objeto> getObjetos() {
        return service.findAll();
    }
    
    public List<Objeto> getObjetosDistanciaMaior(double distancia) {
        return service.findByDistanciaGreaterThan(distancia);
    }
    
    public List<Object[]> getCountByDate() {
        return service.countByDate();
    }
    
    public Long getCount() {
        return service.count();
    }
}
