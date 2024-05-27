package com.nisarg.dockerdemo.repository.elasticsearch;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ElPeopleRepository extends ReactiveElasticsearchRepository<Person, UUID> {
}
