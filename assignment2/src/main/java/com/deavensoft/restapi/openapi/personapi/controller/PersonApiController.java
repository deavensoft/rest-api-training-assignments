package com.deavensoft.restapi.openapi.personapi.controller;

import com.deavensoft.restapi.openapi.model.Person;
import com.deavensoft.restapi.openapi.personapi.service.PersonService;
import com.deavensoft.restapi.openapi.service.PersonsApi;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PersonApiController implements PersonsApi {

    private final PersonService personService;

    @Autowired
    public PersonApiController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id) {
        Person person = this.personService.getPerson(id);

        return person == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.ok(person);
    }

    @Override
    public ResponseEntity<List<Person>> getPersons() {

        List<Person> persons = this.personService.getPersons();

        return ResponseEntity.ok(persons);
    }

    @Override
    public ResponseEntity<Person> addPerson(
            @Valid @RequestBody Person person) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.addPerson(person));
    }


}
