package com.orbitguard.orbitguard.controller;

import com.orbitguard.orbitguard.model.config.Config;
import com.orbitguard.orbitguard.model.config.ConfigService;
import com.orbitguard.orbitguard.model.objeto.Objeto;
import com.orbitguard.orbitguard.model.objeto.ObjetoService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrbitGuardController {

    @Autowired
    private ObjetoService objetoService;

    @Autowired
    private ConfigService configService;

    public Objeto addObjeto(Objeto obj) {
        return objetoService.save(obj);
    }

    public void updateLocalObjeto(Date start, Date end) {
        objetoService.updateLocalObjeto(start, end);
    }

    public List<Objeto> getObjetos() {
        return objetoService.findAll();
    }
    
    public List<Objeto> getObjetosDistanciaMaior(double distancia) {
        return objetoService.findByDistanciaGreaterThan(distancia);
    }
    
    public List<Object[]> getCountByDate() {
        return objetoService.countByDate();
    }

    public Config getConfig() {
        return configService.getConfig();
    }

    public Config saveConfig(Config config) {
        return configService.save(config);
    }
    
    public Long getCount() {
        return objetoService.count();
    }
}
