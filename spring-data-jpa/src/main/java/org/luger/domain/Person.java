package org.luger.domain;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gerardo8 on 25/02/2017.
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "people")
public class Person extends AbstractPersistable<Long> {

    @Column(nullable = false, columnDefinition = "text")
    private String firstName;

    @Column(nullable = false, columnDefinition = "text")
    private String lastName;

    @Email
    @NaturalId
    @Column(nullable = false, columnDefinition = "text")
    private String email;

    @ManyToMany
    @JoinTable(
        name = "friendships",
        joinColumns = @JoinColumn(name = "first_person", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "second_person", referencedColumnName = "id")
    )
    private Set<Person> friends = new HashSet<>();

    @ManyToMany(mappedBy = "friends")
    private Set<Person> friendOf = new HashSet<>();

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
