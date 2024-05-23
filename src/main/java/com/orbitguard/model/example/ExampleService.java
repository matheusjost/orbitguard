package com.orbitguard.model.example;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ExampleService implements ExampleLocalService {

    private ExampleDao dao;

    public ExampleService(ExampleDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(String nome) {
        Example e = new Example();
        e.setNome(nome);

        dao.create(e);
    }
}
