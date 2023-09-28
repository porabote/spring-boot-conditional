package com.example.springboot.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @Min(0)
    @Max(150)
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + "'" +
                ", age='" + age + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        //if (this == 0) return true;
        return false;
    }
}
