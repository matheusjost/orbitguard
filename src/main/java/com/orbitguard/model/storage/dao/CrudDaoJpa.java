package com.orbitguard.model.storage.dao;

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
        getEntityManager().persist(entity);
    }
    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }
    @Override
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    @Override
    public T find(Object id) {
        return getEntityManager().find(getEntityClass(), id);
    }
    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
