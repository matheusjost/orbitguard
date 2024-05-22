package com.orbitguard.model.storage.dao;

import java.util.List;

/**
 * Classe CrudDao<T>
 * Esta implementação foi baseada na estrutura encontrada no repositório sistema-base.
 * Fonte Original: https://github.com/cgoettert/sistema-base
 * Autor Original: Charles Goettert
 */
public interface CrudDao<T> {
    void create(T obj);
    void update(T obj);
    void remove(T obj);
    T find(Object id);
    List<T> findAll();
}
