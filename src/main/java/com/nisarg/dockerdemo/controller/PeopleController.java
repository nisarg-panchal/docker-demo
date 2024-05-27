package com.nisarg.dockerdemo.controller;

import com.nisarg.dockerdemo.bean.Person;
import com.nisarg.dockerdemo.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("{personId}")
    public Mono<Person> getPersonById(@PathVariable UUID personId) {
        log.info("Fetching person by Id:{}", personId);
        return peopleRepository.findById(personId);
    }

    @GetMapping("/")
    public Flux<Person> findAll() {
        log.info("Find All");
        return peopleRepository.findAll();
    }
}
