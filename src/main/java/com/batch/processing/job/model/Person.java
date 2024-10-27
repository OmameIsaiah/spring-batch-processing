package com.batch.processing.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean active;
}