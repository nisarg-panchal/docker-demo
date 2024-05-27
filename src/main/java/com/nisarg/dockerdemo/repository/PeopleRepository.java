package com.nisarg.dockerdemo.repository;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PeopleRepository extends ReactiveCrudRepository<Person, UUID> {
}
