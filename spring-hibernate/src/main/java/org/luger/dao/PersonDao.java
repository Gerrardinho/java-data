package org.luger.dao;

import org.luger.model.Person;

/**
 * Created by gerardo8.
 */
public interface PersonDao extends BaseCrudDao<Person, Long> {
    Person findByEmail(String email);
}
