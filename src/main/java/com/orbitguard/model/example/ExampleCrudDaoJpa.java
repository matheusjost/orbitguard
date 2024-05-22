package com.orbitguard.model.example;

import com.orbitguard.model.storage.dao.CrudDaoJpa;

import javax.ejb.Stateless;

@Stateless
public class ExampleCrudDaoJpa extends CrudDaoJpa<Example> implements ExampleDao {
    public ExampleCrudDaoJpa() {
        super(Example.class);
    }
}
