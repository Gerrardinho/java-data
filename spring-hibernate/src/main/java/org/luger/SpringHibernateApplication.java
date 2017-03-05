package org.luger;

import org.luger.model.Person;
import org.luger.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by gerardo8 on 25/02/2017.
 */
@SpringBootApplication
public class SpringHibernateApplication {

    private final PersonService personService;

    public SpringHibernateApplication(PersonService personService) {
        this.personService = personService;
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            personService.save(new Person("Gerardo", "López", "gerardo.lopezre@gmail.com"));
            personService.save(new Person("Steven", "Gerrard", "steven.gerrard@gmail.com"));
            personService.save(new Person("Frank", "Lampard", "frank.lampard@gmail.com"));

            Person person = personService.findByEmail("gerardo.lopezre@gmail.com");

            System.out.println(person);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }
}
