package com.br.claudemir.controller;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.claudemir.entity.Person;
import com.br.claudemir.repository.PersonRepository;

@RestController
@RequestMapping("/app")
public class MeuController {

    private final PersonRepository personRepository;

    public MeuController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String> createPerson(@RequestBody Map<String, String> objs) {
        // Itere sobre o Map para chamar o PersonRepository para cada par chave-valor
        objs.forEach((key, value) -> {
            Person person = new Person();
            person.setFirstName(key);
            person.setLastName(value);
            personRepository.save(person);
        });

        return ResponseEntity.status(201).body("Dados salvos com sucesso");
    }
}
