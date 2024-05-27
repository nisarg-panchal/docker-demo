package com.nisarg.dockerdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Document(indexName = "people")
@Table("people")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Field(type = FieldType.Text, name = "id")
    private UUID id;
    @Field(type = FieldType.Text, name = "name")
    private String name;
    @Field(type = FieldType.Text, name = "email")
    private String email;
}
