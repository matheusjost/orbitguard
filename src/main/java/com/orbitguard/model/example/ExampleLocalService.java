package com.orbitguard.model.example;

import javax.ejb.Local;

@Local
public interface ExampleLocalService {
    void create(String nome);
}
