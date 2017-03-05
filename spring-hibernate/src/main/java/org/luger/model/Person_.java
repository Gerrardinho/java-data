package org.luger.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by gerardo8.
 */
@StaticMetamodel(Person.class)
public class Person_ {
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, String> email;
}
