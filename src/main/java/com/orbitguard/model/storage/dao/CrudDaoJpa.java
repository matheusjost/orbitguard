package com.orbitguard.model.storage.dao;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Classe CrudDaoJpa<T>
 * Esta implementação foi baseada na estrutura encontrada no repositório sistema-base.
 * Fonte Original: https://github.com/cgoettert/sistema-base
 * Autor Original: Charles Goettert
 */
public abstract class CrudDaoJpa<T> extends Dao<T> implements CrudDao<T> {
    private final Class<T> entityClass;
    public CrudDaoJpa(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected Class<T> getEntityClass() {
        return this.entityClass;
    }
    @Override
    public void create(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    @Override
    public void update(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    @Override
    public void remove(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(entity)) {
                entity = em.merge(entity);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    @Override
    public T find(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(getEntityClass(), id);
        } finally {
            em.close();
        }
    }
    @Override
    public List<T> findAll() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(getEntityClass()));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }

}
