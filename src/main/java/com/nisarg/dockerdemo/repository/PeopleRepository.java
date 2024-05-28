package com.nisarg.dockerdemo.repository;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PeopleRepository extends ReactiveCrudRepository<Person, UUID> {
}
