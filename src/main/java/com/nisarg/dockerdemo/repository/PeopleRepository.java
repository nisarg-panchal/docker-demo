package com.nisarg.dockerdemo.repository;

import com.nisarg.dockerdemo.bean.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PeopleRepository extends ReactiveCrudRepository<Person, String> {
}
