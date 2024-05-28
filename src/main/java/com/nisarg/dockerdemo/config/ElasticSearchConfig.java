package com.nisarg.dockerdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.config.EnableReactiveElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@Configuration
@EnableElasticsearchAuditing
@EnableReactiveElasticsearchAuditing
@EnableReactiveElasticsearchRepositories(basePackages = "com.nisarg.dockerdemo.elasticsearch.repository")
public class ElasticSearchConfig {
}
