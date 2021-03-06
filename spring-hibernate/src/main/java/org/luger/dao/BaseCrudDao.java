package org.luger.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gerardo8.
 */
interface BaseCrudDao<T, ID extends Serializable> {

    T findById(ID id);

    List<T> findAll();

    void save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(ID id);

}
