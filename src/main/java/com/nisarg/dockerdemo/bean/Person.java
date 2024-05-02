package com.nisarg.dockerdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("people")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
}
