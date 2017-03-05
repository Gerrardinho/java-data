package org.luger.web;

import org.luger.model.Person;
import org.luger.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by gerardo8.
 */
@RestController
@RequestMapping(value = "/people", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/search")
    public ResponseEntity<Person> findById(@RequestParam String email) {
        Person person = personService.findByEmail(email);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<Collection<Person>> all() {
        List<Person> people = personService.findAll();
        return ResponseEntity.ok(people);
    }

}
