package com.nisarg.dockerdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.config.EnableReactiveElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchAuditing
@EnableReactiveElasticsearchAuditing
@EnableElasticsearchRepositories(basePackages = "com.nisarg.dockerdemo.repository.elasticsearch")
public class ElasticSearchConfig {
}
