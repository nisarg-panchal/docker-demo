package com.nisarg.dockerdemo.controller;

import com.nisarg.dockerdemo.bean.Person;
import com.nisarg.dockerdemo.elasticsearch.repository.ElPeopleRepository;
import com.nisarg.dockerdemo.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private final PeopleRepository peopleRepository;
    private final ElPeopleRepository elPeopleRepository;

    @GetMapping("{personId}")
    public Mono<Person> getPersonById(@PathVariable UUID personId) {
        log.info("Fetching person by Id:{}", personId);
        return peopleRepository.findById(personId);
    }

    @GetMapping("/")
    public Flux<Person> findAll() {
        log.info("Find All");
        List<Person> people = new LinkedList<>();
        Flux<Person> peopleFlux = peopleRepository.findAll();
        peopleFlux.subscribe(people::add);
        if (!people.isEmpty()) {
            log.info("Storing {} people in Elastic-search", people.size());
            elPeopleRepository.saveAll(people);
        } else {
            log.info("No people stored in Elastic-search");
        }
        return peopleFlux;
    }
}
