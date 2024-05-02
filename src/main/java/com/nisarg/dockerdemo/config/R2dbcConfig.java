package com.nisarg.dockerdemo.config;

import com.nisarg.dockerdemo.bean.Person;
import com.nisarg.dockerdemo.repository.PeopleRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.util.UUID;

@Slf4j
@Configuration
public class R2dbcConfig {

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }

    @Bean
    public CommandLineRunner initData(PeopleRepository peopleRepository) {
        return args -> {
            peopleRepository.save(new Person(UUID.randomUUID().toString(), "Nisarg", "nisarg@gmail.com")).log();
            peopleRepository.save(new Person(UUID.randomUUID().toString(), "John", "john@gmail.com")).log();
        };
    }
}