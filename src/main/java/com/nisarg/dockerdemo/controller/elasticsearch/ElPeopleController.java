package com.nisarg.dockerdemo.controller.elasticsearch;

import com.nisarg.dockerdemo.bean.Person;
import com.nisarg.dockerdemo.repository.elasticsearch.ElPeopleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/elasticsearch/people")
public class ElPeopleController {
    private ElPeopleRepository elPeopleRepository;

    @GetMapping("{id}")
    public Mono<Person> findById(@PathVariable String id) {
        log.info("Fetching person with id {}", id);
        return elPeopleRepository.findById(id);
    }

    @GetMapping
    public Flux<Person> findAll() {
        log.info("Fetching all people");
        return elPeopleRepository.findAll();
    }
}
