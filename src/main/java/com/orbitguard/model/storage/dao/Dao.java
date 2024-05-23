package com.orbitguard.model.storage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Classe Dao<T>
 * Esta implementação foi baseada na estrutura encontrada no repositório sistema-base.
 * Fonte Original: https://github.com/cgoettert/sistema-base
 * Autor Original: Charles Goettert
 */
public abstract class Dao<T> {
    private EntityManager em;
    protected EntityManager getEntityManager() {
        if (this.em == null || !this.em.isOpen()) {
            this.em = JpaUtil.getEntityManager();
        }
        return this.em;
    }
}
