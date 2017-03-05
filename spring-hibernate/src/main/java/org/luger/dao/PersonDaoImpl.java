package org.luger.dao;

import org.hibernate.SessionFactory;
import org.luger.model.Person;
import org.luger.model.Person_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.MapJoin;
import javax.persistence.criteria.Root;

/**
 * Created by gerardo8.
 */
@Repository
public class PersonDaoImpl extends AbstractDao<Person, Long> implements PersonDao {

    @Override
    public Person findByEmail(String email) {


        CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.select(root);

        query.where(builder.equal(root.get(Person_.email), email));
        return this.getSession().createQuery(query).uniqueResult();
    }
}
