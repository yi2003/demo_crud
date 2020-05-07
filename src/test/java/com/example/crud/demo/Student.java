package com.example.crud.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private Integer num;
    private String name;
    private Integer age;
    private Integer level;
    private String major;
    private String school;

    public Student(Integer num, String name, Integer age, Integer level, String major, String school) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.level = level;
        this.major = major;
        this.school = school;
    }
}
