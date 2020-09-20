package com.example.springbootrabbitmq.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
public class Employee implements Serializable {

    private String id;
    private String name;
    private String surname;

}
