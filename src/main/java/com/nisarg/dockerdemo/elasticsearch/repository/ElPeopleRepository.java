package com.nisarg.dockerdemo.elasticsearch.repository;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

import java.util.UUID;

public interface ElPeopleRepository extends ReactiveElasticsearchRepository<Person, UUID> {
}
