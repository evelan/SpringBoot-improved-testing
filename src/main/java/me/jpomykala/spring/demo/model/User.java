package me.jpomykala.spring.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Evelan on 23/10/2016.
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public Integer age;

    //standard getters and setters
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }
}
