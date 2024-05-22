package com.orbitguard.model.storage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe Dao<T>
 * Esta implementação foi baseada na estrutura encontrada no repositório sistema-base.
 * Fonte Original: https://github.com/cgoettert/sistema-base
 * Autor Original: Charles Goettert
 */
public abstract class Dao<T> {
    @PersistenceContext
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
