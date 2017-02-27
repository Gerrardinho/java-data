package org.luger;

import org.luger.domain.Person;
import org.luger.domain.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by gerardo8 on 25/02/2017.
 */
@SpringBootApplication
public class SpringDataJpaApplication {

    @Bean
    CommandLineRunner runner(PersonRepository personRepository) {
        return args -> {

            Person person1 = new Person("Christopher", "Wallace", "wallace@gmail.com");
            Person person2 = new Person("Lesane", "Crooks", "crooks@gmail.com");
            Person person3 = new Person("Marshall", "Mathers", "marshall@gmail.com");

            personRepository.save(person1);
            personRepository.save(person2);
            personRepository.save(person3);

            person1.getFriends().add(person2);
            person1.getFriends().add(person3);

            personRepository.save(person1);

        };
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
}
