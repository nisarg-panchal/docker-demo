package com.nisarg.dockerdemo.repository;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import java.util.UUID;

public interface PeopleRepository extends ReactiveSortingRepository<Person, UUID>, ReactiveCrudRepository<Person, UUID> {
}
