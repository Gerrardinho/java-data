package org.luger.service;

import org.luger.dao.PersonDao;
import org.luger.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gerardo8.
 */
@Service
@Transactional
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person findByEmail(String email) {
        return this.personDao.findByEmail(email);
    }

    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    public Person save(Person person) {
        this.personDao.save(person);
        return person;
    }

}
