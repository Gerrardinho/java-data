package org.luger.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by gerardo8.
 */
@SuppressWarnings("unchecked")
public abstract class AbstractDao<T, ID extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> clazz;

    public AbstractDao(){
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(final ID id) {
        return this.getSession().get(this.clazz, id);
    }

    public List<T> findAll() {
        return this.getSession().createQuery("FROM Person").getResultList();
    }

    public void save(final T entity) {
        this.getSession().persist(entity);
    }

    public T update(final T entity) {
        return (T) this.getSession().merge(entity);
    }

    public void delete(final T entity) {
        this.getSession().delete(entity);
    }

    public void deleteById(final ID id) {
        final T entity = this.findById(id);
        this.delete(entity);
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

}
